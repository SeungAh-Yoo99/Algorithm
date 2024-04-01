import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static ArrayList<ArrayList<Integer>> edges;
    private static boolean[] visited;
    private static int result;

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
        result = 0;

        getLongest(1);

        if(result % 2 == 0) System.out.println(result / 2);
        else System.out.println(result / 2 + 1);
    }

    private static int getLongest(int node) {

        visited[node] = true;

        ArrayList<Integer> edge = edges.get(node);
        int[] ret = new int[edge.size() + 2];

        for (int i = 0; i < edge.size(); i++) {
            if(!visited[edge.get(i)]) {
                ret[i] = getLongest(edge.get(i)) + 1;
            }
        }

        Arrays.sort(ret);

        result = Math.max(result, ret[ret.length - 1] + ret[ret.length - 2]);
        return ret[ret.length - 1];
    }
}