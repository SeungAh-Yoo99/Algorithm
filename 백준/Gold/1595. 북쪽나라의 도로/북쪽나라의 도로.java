import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<int[]>> edges;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        edges = new ArrayList<>();
        for (int i = 0; i < 10_001; i++) {
            edges.add(new ArrayList<>());
        }

        String line;
        int s, e, w;
        while((line = br.readLine()) != null) {
            st = new StringTokenizer(line);

            if(!st.hasMoreTokens()) break;
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            edges.get(s).add(new int[] {e, w});
            edges.get(e).add(new int[] {s, w});
        }

        visited = new boolean[10_001];
        result = 0;
        getMaxLength(1);

        System.out.println(result);
    }

    private static int getMaxLength(int node) {

        visited[node] = true;

        ArrayList<int[]> edge = edges.get(node);
        int size = edge.size();
        int[] child = new int[size + 2];

        int[] next;
        for (int i = 0; i < size; i++) {
            next = edge.get(i);

            if(!visited[next[0]]) child[i] = getMaxLength(next[0]) + next[1];
        }

        Arrays.sort(child);

        result = Math.max(result, child[size + 1] + child[size]);
        return child[size + 1];
    }
}