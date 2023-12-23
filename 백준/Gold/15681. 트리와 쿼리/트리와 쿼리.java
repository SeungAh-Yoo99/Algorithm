import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<ArrayList<Integer>> edges;
    static int[] numOfNode;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 정점의 수, R := 루트의 번호, Q := 쿼리의 수
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        // 간선 정보
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

        // 각 노드를 루트로 하는 서브트리에 속한 노드의 수 구하기
        numOfNode = new int[N + 1];
        visited = new boolean[N + 1];
        getNumOfNode(R);

        // 쿼리에 대한 답 출력
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            result.append(numOfNode[Integer.parseInt(br.readLine())] + "\n");
        }
        System.out.println(result);
    }

    private static int getNumOfNode(int node) {

        visited[node] = true;

        int sum = 1; // 서브트리 노드 개수

        ArrayList<Integer> edge = edges.get(node);
        for (int i = 0; i < edge.size(); i++) {
            if(!visited[edge.get(i)]) {
                sum += getNumOfNode(edge.get(i));
            }
        }

        numOfNode[node] = sum;
        return sum;
    }
}