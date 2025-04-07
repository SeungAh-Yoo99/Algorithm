import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static final long MAX = Long.MAX_VALUE;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 오솔길 정보
        ArrayList<ArrayList<int[]>> edges = new ArrayList<>();
        for(int i = 0; i <= N; i++)
            edges.add(new ArrayList<>());

        int a, b, d;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            edges.get(a).add(new int[] {b, d});
            edges.get(b).add(new int[] {a, d});
        }

        // 여우의 최단거리 구하기
        long[] fox = new long[N + 1];
        Arrays.fill(fox, MAX);
        fox[1] = 0;

        // 다익스트라
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] < o2[1] ? -1 : 1);
        pq.add(new long[] {1, 0});

        long[] now; int[] next;
        ArrayList<int[]> edge;
        while(!pq.isEmpty()) {
            now = pq.poll();

            // 이미 현재 경로보다 최단거리를 구했다면 넘어가기
            if(now[1] > fox[(int)now[0]]) continue;

            // 현재 그루터기에 연결된 오솔길 리스트
            edge = edges.get((int)now[0]);

            for (int i = 0; i < edge.size(); i++) {
                next = edge.get(i);

                // 늑대의 2배 빠르기를 소수점 없이 구하기 위해 곱하기 2
                if(now[1] + next[1] * 2 < fox[next[0]]) { // 최단거리를 찾은 경우
                    fox[next[0]] = now[1] + next[1] * 2;
                    pq.add(new long[] {next[0], now[1] + next[1] * 2});
                }
            }
        }

        // 늑대의 최단거리 구하기
        // wolf[0][i] := i번째 그루터기에 절반 속도로 왔을 때 최솟값
        // wolf[1][i] := i번째 그루터기에 2배 속도로 왔을 때 최솟값
        long[][] wolf = new long[2][N + 1];
        Arrays.fill(wolf[0], MAX);
        Arrays.fill(wolf[1], MAX);
        // 늑대는 1번 노드로 되돌아와 가는 것이 최단거리일 때도 있기 때문에
        // 1번 노드를 0으로 초기화하면 안됨

        // 다익스트라
        pq = new PriorityQueue<>((o1, o2) -> o1[1] < o2[1] ? -1 : 1);
        pq.add(new long[] {1, 0, 0});

        while(!pq.isEmpty()) {
            now = pq.poll();

            // 이미 현재 경로보다 최단거리를 구했다면 넘어가기
            if(now[1] > wolf[(int)now[2]][(int)now[0]]) continue;

            // 현재 그루터기에 연결된 오솔길 리스트
            edge = edges.get((int)now[0]);

            for (int i = 0; i < edge.size(); i++) {
                next = edge.get(i);

                // 2배 빠르게 갈 차례
                if(now[2] == 0) {
                    if(wolf[1][next[0]] > now[1] + next[1]) {
                        wolf[1][next[0]] = now[1] + next[1];
                        pq.add(new long[] {next[0], now[1] + next[1], 1});
                    }
                }
                // 절반 속도로 갈 차례
                else {
                    if(wolf[0][next[0]] > now[1] + 4 * next[1]) {
                        wolf[0][next[0]] = now[1] + 4 * next[1];
                        pq.add(new long[] {next[0], now[1] + 4 * next[1], 0});
                    }
                }
            }
        }

        // 여우가 더 빨리 갈 수 있는 그루터기 개수 세기
        int answer = 0;
        for (int i = 2; i <= N; i++) {
            if(fox[i] < wolf[0][i] && fox[i] < wolf[1][i])
                answer++;
        }
        System.out.println(answer);
    }
}