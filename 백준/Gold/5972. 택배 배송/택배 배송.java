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

        // 길 정보
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

        // 다익스트라로 최소 여물 구하기
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int[] visited = new int[N + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);

        pq.add(new int[] {1, 0});
        visited[1] = 0;

        int result = 0;
        int[] now, next;
        ArrayList<int[]> edge;
        while(!pq.isEmpty()) {
            now = pq.poll();
            if(now[0] == N) {
                result = now[1];
                break;
            }

            if(visited[now[0]] < now[1]) continue;

            edge = edges.get(now[0]);
            for (int i = 0; i < edge.size(); i++) {
                next = edge.get(i);
                if(visited[next[0]] > now[1] + next[1]) {
                    visited[next[0]] = now[1] + next[1];
                    pq.add(new int[] {next[0], visited[next[0]]});
                }
            }
        }

        System.out.println(result);
    }
}
