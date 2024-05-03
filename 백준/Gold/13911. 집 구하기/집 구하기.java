import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int MAX_LEN = 100_000_001;

    static int V;
    static ArrayList<ArrayList<int[]>> edges;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 비용 0으로 모든 맥도날드에 갈 수 있는 가상의 맥도날드 점정 V + 1과
        // 비용 0으로 모든 스타벅스에 갈 수 있는 가상의 스타벅스 점정 V + 2 추가
        // V + 1에서 출발하는 다익스트라를 사용하여 모든 정점에 대해 맥도날드로 가는 최소값을 구할 수 있음.
        // V + 2에서 출발하는 다익스트라를 사용하여 모든 정점에 대해 스타벅스로 가는 최소값을 구할 수 있음.

        edges = new ArrayList<>();
        for (int i = 0; i < V + 3; i++) {
            edges.add(new ArrayList<>());
        }

        int u, v, w;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            edges.get(u).add(new int[] {v, w});
            edges.get(v).add(new int[] {u, w});
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int tmp;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            tmp = Integer.parseInt(st.nextToken());
            edges.get(V + 1).add(new int[] {tmp, 0});
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            tmp = Integer.parseInt(st.nextToken());
            edges.get(V + 2).add(new int[] {tmp, 0});
        }

        int[] macLen = dijkstra(V + 1);
        int[] starLen = dijkstra(V + 2);

        int result = -1;
        for (int i = 1; i <= V; i++) {

            if(macLen[i] != 0 && macLen[i] <= x && starLen[i] != 0 && starLen[i] <= y) {
                if(result == -1) result = macLen[i] + starLen[i];
                else result = Math.min(result, macLen[i] + starLen[i]);
            }
        }

        System.out.println(result);
    }

    // start 정점에서 가장 가까운 맥도날드와 스타벅스 거리를 리턴
    private static int[] dijkstra(int start) {

        int[] visited = new int[V + 3];
        Arrays.fill(visited, MAX_LEN);
        visited[start] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {start, 0});

        int[] now, next;
        ArrayList<int[]> edge;
        while(!q.isEmpty()) {
            now = q.poll();

            if(visited[now[0]] < now[1]) continue;

            edge = edges.get(now[0]);
            for (int i = 0; i < edge.size(); i++) {
                next = edge.get(i);

                if(visited[next[0]] > now[1] + next[1]) {
                    visited[next[0]] = now[1] + next[1];
                    q.add(new int[] {next[0], visited[next[0]]});
                }
            }
        }

        return visited;
    }
}