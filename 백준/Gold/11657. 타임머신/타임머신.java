import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        final int MAX = 60_000_001;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 도시의 개수, M := 버스 노선의 개수
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 도로 정보
        ArrayList<ArrayList<int[]>> edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        // 도로 정보 입력
        int A, B, C;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            edges.get(A).add(new int[] {i, B, C});
        }

        // 1번에서 출발한 최단 거리
        int[] minLen = new int[N + 1];
        Arrays.fill(minLen, MAX);
        minLen[1] = 0;

        // 벨만-포드
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[0] - o2[0]));
        pq.add(new int[] {0, 1, 0}); // 1번에서 출발

        int[] now, next; ArrayList<int[]> edge;
        while (!pq.isEmpty()) {
            now = pq.poll(); // 현재 정점

            // 현재 루트보다 더 나은 경우를 이미 찾았다면 넘어감
            if(minLen[now[1]] < now[0]) continue;

            edge = edges.get(now[1]); // 현재 정점에 연결된 도로 정보
            for (int i = 0; i < edge.size(); i++) {
                next = edge.get(i); // 현재 정점에서 도로로 연결된 다음 정점

                if(minLen[next[1]] > now[0] + next[2]) { // 다음 정점으로 가는 최단 거리를 찾았다면
                    if(now[2] == M - 1) { // 가지고 있는 도로의 개수보다 많은 도로를 오갔다면 사이클이 존재하는 것
                        System.out.println(-1);
                        return;
                    }
                    minLen[next[1]] = now[0] + next[2];
                    pq.add(new int[] {minLen[next[1]], next[1], now[2] + 1});
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            if(minLen[i] == MAX) result.append("-1\n");
            else result.append(minLen[i] + "\n");
        }
        System.out.println(result);
    }
}