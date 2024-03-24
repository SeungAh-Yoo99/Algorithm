import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> edges;
    static boolean[] visited;
    static int[] parent;
    static int[] depth;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        int a, b;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            edges.get(a).add(b);
            edges.get(b).add(a);
        }

        visited = new boolean[N + 1];
        parent = new int[N + 1];
        depth = new int[N + 1];

        // 각 노드별 조상 구하기(dfs)
        getParent(1, 0, 0);

        StringBuilder answer = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        int ret;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            ret = getLCA(a, b);
            answer.append(ret + "\n");
        }

        System.out.print(answer);
    }

    private static void getParent(int n, int p, int d) { // 조상을 구하는 메소드

        visited[n] = true;
        parent[n] = p;
        depth[n] = d;

        ArrayList<Integer> edge = edges.get(n);
        for (int i = 0; i < edge.size(); i++) {
            if(!visited[edge.get(i)]) {
                getParent(edge.get(i), n, d + 1);
            }
        }
    }

    private static int getLCA(int a, int b) {

        int sub;
        if(depth[a] > depth[b]) {
            sub = depth[a] - depth[b];

            while(sub-- > 0) a = parent[a];
        } else {
            sub = depth[b] - depth[a];

            while (sub-- > 0) b = parent[b];
        }

        while(a != 1) {
            if(a == b) return a;
            else {
                a = parent[a];
                b = parent[b];
            }
        }

        return 1;
    }
}