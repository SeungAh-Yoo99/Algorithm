import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main  {

    static int V;
    static ArrayList<ArrayList<int[]>> edges;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
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

        int oneToV = bfs(1, V);
        int oneToP = bfs(1, P);
        int pToV = bfs(P, V);

        if(oneToP == -1 || pToV == -1) System.out.println("GOOD BYE");
        else if(oneToV != oneToP + pToV) System.out.println("GOOD BYE");
        else System.out.println("SAVE HIM");
    }

    private static int bfs(int start, int end) {

        int[] visited = new int[V + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[] {start, 0});

        int[] now, next;
        ArrayList<int[]> edge;
        while(!pq.isEmpty()) {
            now = pq.poll();

            if(now[0] == end) return now[1];

            if(now[1] > visited[now[0]]) continue;

            edge = edges.get(now[0]);
            for (int i = 0; i < edge.size(); i++) {
                next = edge.get(i);

                if(visited[next[0]] > now[1] + next[1]) {
                    visited[next[0]] = now[1] + next[1];
                    pq.add(new int[] {next[0], visited[next[0]]});
                }
            }
        }

        return -1;
    }
}