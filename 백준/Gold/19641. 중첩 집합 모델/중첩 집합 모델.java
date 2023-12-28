import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> edges;
    static int[][] tree;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 정점의 개수
        int N = Integer.parseInt(br.readLine());

        // 정점에 연결된 정점을 담을 배열
        edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        // 간선 정보 입력
        int a, b;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            while(true) {
                b = Integer.parseInt(st.nextToken());
                if(b == -1) break;
                edges.get(a).add(b);
            }
            // 정렬
            Collections.sort(edges.get(a));
        }

        // S := 루트 노드
        int S = Integer.parseInt(br.readLine());

        // left, right 저장 배열
        tree = new int[N + 1][2];

        // dfs로 left, right 구하기
        getRight(S, 1);

        // 출력
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            result.append(i + " " + tree[i][0] + " " + tree[i][1] + "\n");
        }
        System.out.println(result);
    }

    private static int getRight(int node, int n) {

        // left 저장
        tree[node][0] = n;

        // 자식 노드 방문
        ArrayList<Integer> edge = edges.get(node);
        int next;
        for (int i = 0; i < edge.size(); i++) {
            next = edge.get(i);
            if(tree[next][0] != 0) continue; // 부모 노드인 경우
            n = getRight(next, n + 1);
        }

        // right 저장
        tree[node][1] = n + 1;

        return n + 1;
    }
}