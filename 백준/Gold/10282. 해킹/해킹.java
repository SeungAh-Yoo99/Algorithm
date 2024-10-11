import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int n, d, c, a, b, s, count, time;
        ArrayList<ArrayList<int[]>> edges;
        int[] now, next;
        ArrayList<int[]> edge;
        for (int tc = 0; tc < T; tc++) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                edges.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());

                edges.get(b).add(new int[] {a, s});
            }

            count = 0;
            time = 0;

            // dijstra
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
            pq.add(new int[] {c, 0});

            boolean[] visited = new boolean[n + 1];

            while(!pq.isEmpty()) {
                now = pq.poll();

                if(visited[now[0]]) continue;

                visited[now[0]] = true;
                count++;
                time = Math.max(time, now[1]);

                edge = edges.get(now[0]);
                for (int i = 0; i < edge.size(); i++) {
                    next = edge.get(i);

                    if(!visited[next[0]]) {
                        pq.add(new int[] {next[0], now[1] + next[1]});
                    }
                }
            }

            result.append(count).append(" ").append(time).append("\n");
        }

        System.out.println(result);
    }
}