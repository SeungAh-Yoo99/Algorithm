import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Route implements Comparable{

        int node;
        int weight;
        ArrayList<Integer> way;

        Route(int node, int weight, ArrayList<Integer> way) {
            this.node = node;
            this.weight = weight;
            this.way = (ArrayList<Integer>)way.clone();
        }

        Route(int node, int weight, ArrayList<Integer> way, int newWay) {
            this.node = node;
            this.weight = weight;
            this.way = (ArrayList<Integer>)way.clone();
            this.way.add(newWay);
        }

        @Override
        public int compareTo(Object o) {
            Route r = (Route) o;
            return this.weight - r.weight;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<int[]>> edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        // 회선 정보
        int[][] line_info = new int[M][2];

        int A, B, C;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            edges.get(A).add(new int[] {B, C, i});
            edges.get(B).add(new int[] {A, C, i});
            line_info[i][0] = A;
            line_info[i][1] = B;
        }

        // 해당 회선을 사용했는지 여부
        boolean[] use = new boolean[M];
        int count = 0;

        // 다익스트라
        PriorityQueue<Route> pq = new PriorityQueue<>();
        pq.add(new Route(1, 0, new ArrayList<>()));

        int[] visited = new int[N + 1];
        Arrays.fill(visited, Integer.MAX_VALUE);

        Route now;
        ArrayList<int[]> edge;
        int[] next;
        while(!pq.isEmpty()) {
            now = pq.poll();

            if (now.weight < visited[now.node]) {
                visited[now.node] = now.weight;
                for (int i = 0; i < now.way.size(); i++) {
                    if(!use[now.way.get(i)]) {
                        use[now.way.get(i)] = true;
                        count++;
                    }
                }
            }
            else continue;

            edge = edges.get(now.node);
            for (int i = 0; i < edge.size(); i++) {
                next = edge.get(i);
                if(visited[next[0]] > now.weight + next[1]) {
                    pq.add(new Route(next[0], now.weight + next[1], now.way, next[2]));
                }
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(count + "\n");
        for (int i = 0; i < M; i++) {
            if(use[i]) {
                result.append(line_info[i][0] + " " + line_info[i][1] + "\n");
            }
        }
        System.out.println(result);
    }
}