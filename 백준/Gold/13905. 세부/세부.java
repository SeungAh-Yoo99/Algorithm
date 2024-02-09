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

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        // 다리 정보
        ArrayList<ArrayList<int[]>> edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        int h1, h2, k;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            h1 = Integer.parseInt(st.nextToken());
            h2 = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            edges.get(h1).add(new int[] {h2, k});
            edges.get(h2).add(new int[] {h1, k});
        }

        // 다익스트라로 최대 무게 구하기
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]); // 무게 내림차순
        pq.add(new int[] {s, 1_000_001});

        // 각 섬에 들고 올 수 있는 최대 개수
        int[] visited = new int[N + 1];
        visited[s] = 1_000_001;

        int[] now, next;
        ArrayList<int[]> edge;
        int result = 0;
        while(!pq.isEmpty()) {
            now = pq.poll();

            if(now[0] == e) {
                result = now[1];
                break;
            }

            if(visited[now[0]] > now[1]) continue;

            edge = edges.get(now[0]);
            for (int i = 0; i < edge.size(); i++) {
                next = edge.get(i);
                if(visited[next[0]] < Math.min(now[1], next[1])) {
                    visited[next[0]] = Math.min(now[1], next[1]);
                    pq.add(new int[] {next[0], visited[next[0]]});
                }
            }
        }

        System.out.println(result);
    }
}
