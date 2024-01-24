import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int D;
    static ArrayList<ArrayList<Integer>> edges;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 노드의 개수, S := 케니소프트의 위치, D := 힘
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        // 연결관계
        edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        int x, y;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            edges.get(x).add(y);
            edges.get(y).add(x);
        }

        // 방문 체크
        visited = new boolean[N + 1];

        int answer = dfs(S) * 2;
        if(answer <= 0) System.out.println(0);
        else System.out.println(answer);
    }

    private static int dfs(int node) { // node를 루트로 하는 서브 트리에서 전단지를 뿌리기 위해 이동해야 하는 최소 거리 리턴

        visited[node] = true;

        // 리프노드인지 확인
        int count = 0, next;
        for (int i = 0; i < edges.get(node).size(); i++) {
            next = edges.get(node).get(i);
            if(!visited[next]) count++;
        }
        if(count == 0) { // 리프 노드라면
            return D * -1;
        }

        int tmp;
        int ret = D * -1;
        for (int i = 0; i < edges.get(node).size(); i++) {
            next = edges.get(node).get(i);
            if(!visited[next]) {
                tmp = dfs(next);
                if(tmp < 0) ret = Math.max(ret, tmp + 1);
                else ret = ret <= 0 ? tmp + 1 : ret + tmp + 1;
            }
        }

        return ret;
    }
}