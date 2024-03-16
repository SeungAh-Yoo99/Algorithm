import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> edges;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        int u, v;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            edges.get(u).add(v);
            edges.get(v).add(u);
        }

        visited = new boolean[N + 1];

        int[] ret = dfs(1);
        System.out.println(Math.min(ret[0], ret[1]));
    }

    private static int[] dfs(int node) {

        // ret[0] := node가 얼리 아답터가 아닌 경우
        // ret[1] := node가 얼리 아답터인 경우
        int[] ret = {0, 1};

        visited[node] = true;

        ArrayList<Integer> edge = edges.get(node);

        int next;
        int[] tmp;
        for (int i = 0; i < edge.size(); i++) {
            next = edge.get(i);

            if(!visited[next]) {
                tmp = dfs(next);

                // node가 얼리 아답터가 아닌 경우, node에 연결된 다른 노드들은 모두 얼리 아답터여야 한다.
                ret[0] += tmp[1];

                // node가 얼리 아답터인 경우, node에 연결된 다른 노드들은 얼리 아답터거나 아니거나 상관없다.
                ret[1] += Math.min(tmp[0], tmp[1]);
            }
        }

        return ret;
    }
}