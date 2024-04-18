import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<ArrayList<int[]>> edges;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        int A, B, C;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            edges.get(A).add(new int[] {B, C});
            edges.get(B).add(new int[] {A, C});
        }

        visited = new boolean[N + 1];

        result = new int[2];

        dfs(1);

        int answer = result[1] / T + (result[1] % T == 0 ? 0 : 1);
        System.out.println(answer);
    }

    private static int[] dfs(int node) {

        int[] ret = new int[2];

        visited[node] = true;

        ArrayList<int[]> edge = edges.get(node);
        int[][] arr = new int[edge.size() + 1][2];

        int[] next, tmp;
        for (int i = 0; i < edge.size(); i++) {
            next = edge.get(i);

            if(!visited[next[0]]) {
                tmp = dfs(next[0]);
                arr[i][0] = tmp[0] + 1;
                arr[i][1] = tmp[1] + next[1];
            }
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        if(arr[0][0] + arr[1][0] == result[0] && arr[0][1] + arr[1][1] < result[1])
            result[1] = arr[0][1] + arr[1][1];
        else if(arr[0][0] + arr[1][0] > result[0]) {
            result[0] = arr[0][0] + arr[1][0];
            result[1] = arr[0][1] + arr[1][1];
        }

        ret[0] = arr[0][0];
        ret[1] = arr[0][1];

        return ret;
    }
}