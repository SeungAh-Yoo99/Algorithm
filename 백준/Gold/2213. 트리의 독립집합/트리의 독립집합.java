import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    // DFS에서 리턴 값으로 사용할 클래스
    private static class Node {
        int o; // 현재 노드를 포함했을 때 최댓값
        ArrayList<Integer> oList; // o의 경우에 포함되는 정점 리스트

        int x; // 혅재 노드를 포함하지 않았을 때 최솟값
        ArrayList<Integer> xList; // x의 경우에 포함되는 정점 리스트

        Node(int w, int n) { // 현재 노드의 가중치와 정점 번호 입력
            this.o = w;
            this.oList = new ArrayList<>();
            oList.add(n);

            this.x = 0;
            this.xList = new ArrayList<>();
        }
    }

    static int[] weight;
    static ArrayList<ArrayList<Integer>> edges;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        // 정점의 가중치
        weight = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        // 긴선 정보
        edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
        int u, v;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            edges.get(u).add(v);
            edges.get(v).add(u);
        }

        // 1번 정점부터 DFS
        Node ret = dfs(0, 1);

        // 1번 노드를 포함시킨 경우와 포함시키지 않은 경우 중 더 큰 수를 담으로 출력
        StringBuilder result = new StringBuilder();
        if(ret.o > ret.x) {
            result.append(ret.o).append("\n");

            Collections.sort(ret.oList);
            for (int i = 0; i < ret.oList.size(); i++) {
                result.append(ret.oList.get(i)).append(" ");
            }
        }
        else {
            result.append(ret.x).append("\n");

            Collections.sort(ret.xList);
            for (int i = 0; i < ret.xList.size(); i++) {
                result.append(ret.xList.get(i)).append(" ");
            }
        }

        System.out.println(result);
    }

    static Node dfs(int parent, int node) {

        Node ret = new Node(weight[node], node);

        // node에 연결된 간선 정보
        ArrayList<Integer> edge = edges.get(node);

        int next;
        Node child;
        for (int i = 0; i < edge.size(); i++) {
            next = edge.get(i);

            if(next != parent) { // 역행 방지
                child = dfs(node, next); // 자식 노드의 최댓값 구해오기

                // 현재 노드를 포함하는 경우, 자식 노드는 무조건 포함시킬 수 없음
                ret.o += child.x;
                ret.oList.addAll(child.xList);

                // 현재 노드를 포함하지 않는 경우, 자식 노드를 포함시키건 시키지 않건 상관 없음
                // 더 큰 경우를 선택
                if(child.o > child.x) {
                    ret.x += child.o;
                    ret.xList.addAll(child.oList);
                }
                else {
                    ret.x += child.x;
                    ret.xList.addAll(child.xList);
                }
            }
        }

        return ret;
    }
}
