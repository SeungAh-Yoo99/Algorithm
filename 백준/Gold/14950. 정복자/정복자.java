import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<int[]>> edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        int A, B, C;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            edges.get(A).add(new int[] {B, C});
            edges.get(B).add(new int[] {A, C});
        }

        // 다익스트라
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[] {1, 0});

        // 현재 몇 개의 도시를 정복했는지
        int count = -1;

        // 총 비용
        long result = 0;

        // 이미 정복한 도시
        boolean[] visited = new boolean[N + 1];

        int[] now, next;
        ArrayList<int[]> edge;
        while(!pq.isEmpty()) {
            now = pq.poll();

            // 이미 더 작은 비용으로 정복한 도시라면
            if(visited[now[0]]) continue;

            // 아니라면 이번에 정복
            result += now[1] + t * (count > -1 ? count : 0);
            count++;
            visited[now[0]] = true;

            edge = edges.get(now[0]);
            for (int i = 0; i < edge.size(); i++) {
                next = edge.get(i);

                if(!visited[next[0]]) {
                    pq.add(next);
                }
            }
        }

        System.out.println(result);
    }
}