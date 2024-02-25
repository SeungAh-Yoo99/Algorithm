import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<int[]>> edges;
    static boolean[] visited;
    static long result;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int v = Integer.parseInt(br.readLine());

        // 연결 노드 정보
        edges = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            edges.add(new ArrayList<>());
        }

        int s, e, w;
        for (int i = 1; i <= v; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            while(true) {
                e = Integer.parseInt(st.nextToken());
                if(e == -1) break;
                w = Integer.parseInt(st.nextToken());
                edges.get(s).add(new int[] {e, w});
            }
        }

        visited = new boolean[v + 1];
        result = 0;

        maxLength(1);

        System.out.println(result);
    }

    static private long maxLength(int node) {

        visited[node] = true;

        ArrayList<int[]> edge = edges.get(node);
        int size = edge.size();
        long[] weight = new long[size + 1];

        int[] next;
        for (int i = 0; i < size; i++) {
            next = edge.get(i);

            if(!visited[next[0]]) {
                weight[i] = maxLength(next[0]) + next[1];
            }
        }

        Arrays.sort(weight);

        result = Math.max(result, weight[size] + weight[size - 1]);

        return weight[size];
    }
}