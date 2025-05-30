import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());

        // 고둘라가 방문하는 교차로
        int[] gRoot = new int[G];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < G; i++) {
            gRoot[i] = Integer.parseInt(st.nextToken());
        }

        // 도로 정보
        ArrayList<ArrayList<int[]>> edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        int U, V, L;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            U = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            // 도로 번호, 도착 지점, 걸리는 시간 순으로 저장
            edges.get(U).add(new int[] {i, V, L});
            edges.get(V).add(new int[] {i, U, L});
        }

        // 고둘라가 시간대별 지나가는 도로의 번호 저장
        ArrayList<Integer> times = new ArrayList<>();

        // 고둘라가 시간대별 지나가는 도로의 번호 구하기
        int s, e;
        ArrayList<int[]> edge;
        for (int i = 0; i < G - 1; i++) {
            s = gRoot[i];
            e = gRoot[i + 1];

            // s에서 e로 가기 위한 도로 번호 찾기
            edge = edges.get(s);
            for (int j = 0; j < edge.size(); j++) {
                if(edge.get(j)[1] == e) {
                    for (int k = 1; k <= edge.get(j)[2]; k++) {
                        times.add(edge.get(j)[0]);
                    }
                    break;
                }
            }
        }

        // 상근이가 A에서 B로 가는 최단 루트 구하기
        // 현재 위치, 현재 시각, 걸린 시간 순으로 저장
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.add(new int[] {A, K, 0});

        // 각 교차로에 도착할 수 있는 최단 시간 저장
        int[] visited = new int[N + 1];
        Arrays.fill(visited, 1_000_001);
        visited[A] = K;

        int[] now, tmp;
        while(!pq.isEmpty()) {
            now = pq.poll();

            // B까지 가는 최단거리를 찾은 경우
            if(now[0] == B) {
                System.out.println(now[2]);
                return;
            }

            // 이미 더 최단거리를 찾은 경로인 경우, 넘어가기
            if(visited[now[0]] < now[1]) continue;

            // now로부터 연결된 도로를 통해 다른 곳까지 이동
            edge = edges.get(now[0]);
            for (int[] next : edge) {
                tmp = new int[] {next[1], now[1] + next[2], now[2] + next[2]};

                // 만약 고둘라가 next 도로를 지나가는 중이라면 기다려야 함
                for (int i = now[1]; i < times.size(); i++) {
                    if(times.get(i) == next[0]) {
                        tmp[1]++;
                        tmp[2]++;
                    }
                    else break;
                }

                // 현재 경로가 최단경로일 경우에만 큐에 넣어줌
                if(visited[next[1]] > tmp[1]) {
                    visited[next[1]] = tmp[1];
                    pq.add(tmp);
                }
            }
        }
    }
}
