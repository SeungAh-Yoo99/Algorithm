import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<ArrayList<int[]>> edges;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        int a, b, c;
        for (int i = 0; i < E; i++) {
           st = new StringTokenizer(br.readLine());
           a = Integer.parseInt(st.nextToken());
           b = Integer.parseInt(st.nextToken());
           c = Integer.parseInt(st.nextToken());

           edges.get(a).add(new int[] {b, c});
           edges.get(b).add(new int[] {a, c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // v1에서 v2까지의 최단거리 구하기
        long result = bfs(v1, v2);

        // v1에서 v2로 가는 경로가 없는 경우
        if(result == -1) {
            System.out.println(-1);
            return;
        }

        // 1에서 v1, v2 가는 경우
        int oneToV1 = bfs(1, v1);
        int oneToV2 = bfs(1, v2);

        // v1, v2에서 N으로 가는 경우
        int v1ToN = bfs(v1, N);
        int v2ToN = bfs(v2, N);

        // 경로가 없는 경우
        if((oneToV1 == -1 || v2ToN == -1) && (oneToV2 == -1 || v1ToN == -1)) {
            System.out.println(-1);
        } else {
            if(oneToV1 == -1 || v2ToN == -1) {
                result += oneToV2 + v1ToN;
            }
            else if(oneToV2 == -1 || v1ToN == -1) {
                result += oneToV1 + v2ToN;
            }
            else {
                result += Math.min(oneToV2 + v1ToN, oneToV1 + v2ToN);
            }
            System.out.println(result);
        }
    }

    private static int bfs(int start, int end) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[] {start, 0});

        int[] visited = new int[N + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[start] = 0;

        int[] now, next;
        ArrayList<int[]> edge;
        while(!pq.isEmpty()) {
            now = pq.poll();

            if(now[0] == end) {
                return now[1];
            }

            if(visited[now[0]] < now[1]) continue;

            edge = edges.get(now[0]);
            for (int i = 0; i < edge.size(); i++) {
                next = edge.get(i);
                if(visited[next[0]] > now[1] + next[1]) {
                    visited[next[0]] = now[1] + next[1];
                    pq.add(new int[] {next[0], now[1] + next[1]});
                }
            }
        }

        return -1;
    }
}