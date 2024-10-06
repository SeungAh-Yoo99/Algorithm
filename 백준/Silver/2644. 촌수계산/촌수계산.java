import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 관계 정보
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }

        int m = Integer.parseInt(br.readLine());
        int x, y;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            edges.get(x).add(y);
            edges.get(y).add(x);
        }

        // bfs
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {a, 0});

        boolean[] visited = new boolean[n + 1];
        visited[a] = true;

        int[] now; int next;
        ArrayList<Integer> edge;
        int result = -1;
        while(!q.isEmpty()) {
            now = q.poll();

            edge = edges.get(now[0]);
            for (int i = 0; i < edge.size(); i++) {
                next = edge.get(i);

                if(next == b) {
                    result = now[1] + 1;
                    break;
                }

                if(!visited[next]) {
                    visited[next] = true;
                    q.add(new int[] {next, now[1] + 1});
                }
            }
        }

        System.out.println(result);
    }
}