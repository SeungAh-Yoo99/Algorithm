import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<String, ArrayList<String>> child1;
    static Map<String, ArrayList<String>> child2;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        // T := 테스트 케이스의 개수
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            // 두 트리 정보 입력
            ArrayList<String> tree1 = new ArrayList<>();
            ArrayList<String> tree2 = new ArrayList<>();

            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                tree1.add(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                tree2.add(st.nextToken());
            }

            // 두 트리가 비어있다면
            if(tree1.size() != tree2.size()) { // 두 트리의 크기가 다르다면
                answer.append("false\n");
                continue;
            }
            else if(tree1.size() == 1 || tree1.size() == 2) { // 두 트리가 비어있다면
                answer.append("ture\n");
                continue;
            }

            child1 = new HashMap<>(); // 첫 번째 트리의 자식 정보
            child2 = new HashMap<>(); // 두 번째 트리의 자식 정보

            // 두 트리의 루트 정보
            String root1 = tree1.get(tree1.size() - 2);
            String root2 = tree2.get(tree2.size() - 2);

            // 트리를 순회하며 자식 정보 구하기
            bfs(tree1, tree1.size() - 2, child1);
            bfs(tree2, tree2.size() - 2, child2);

            // 두 트리가 동등한지 확인
            if(isSame(root1, root2)) answer.append("true\n");
            else answer.append("false\n");
        }

        // 출력
        System.out.println(answer);
    }

    private static int bfs(ArrayList<String> tree, int idx, Map<String, ArrayList<String>> child) {

        // idx에 해당하는 노드 child map에 추가
        String parent = tree.get(idx);
        child.put(parent, new ArrayList<>());

        // 오른쪽 자식 유무 확인
        String right = tree.get(idx - 1);
        if(!right.equals("nil")) { // 오른쪽 자식이 있다면 bfs로 재귀
            child.get(parent).add(right);
            idx = bfs(tree, idx - 1, child);
        } else { // 오른쪽 자식이 없다면
            idx--;
        }
        String left = tree.get(idx - 1);
        // 왼쪽 자식 유무 확인
        if(!left.equals("nil")) { // 왼쪽 자식이 있다면 bfs로 재귀
            child.get(parent).add(left);
            idx = bfs(tree, idx - 1, child);
        } else {
            idx--;
        }

        return idx;
    }

    private static boolean isSame(String node1, String node2) {

        if(node1.equals(node2)) { // 두 노드가 같다면
            ArrayList<String> c1 = child1.get(node1); // node1의 자식 정보
            ArrayList<String> c2 = child2.get(node2); // node2의 자식 정보

            // 자식의 개수가 다르면 동등하지 않음
            if(c1.size() != c2.size()) return false;

            // 두 자식 정보 정렬
            Collections.sort(c1);
            Collections.sort(c2);

            for (int i = 0; i < c1.size(); i++) { // 두 노드가 동등한지 확인
                if(!isSame(c1.get(i), c2.get(i))) return false; // 동등하지 않은 경우
            }
        } else { // 같지 않은 경우
            return false;
        }

        // 여기까지 왔다면 두 노드는 동등
        return true;
    }
}