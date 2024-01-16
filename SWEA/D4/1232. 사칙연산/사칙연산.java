import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static String[] node;
    static int[][] child;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int N, n;
        for (int tc = 1; tc <= 10; tc++) {
            // N := 정점의 개수
            N = Integer.parseInt(br.readLine());

            // 노드 정보
            node = new String[N + 1];

            // 노드의 자식 정보
            child = new int[N + 1][2];

            // 노드 정보 입력
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                node[n] = st.nextToken();

                // node[n]이 연산자라며 자식 노드의 정보를 입력 받음
                if(node[n].equals("+") || node[n].equals("-") || node[n].equals("*") || node[n].equals("/")) {
                    child[n][0] = Integer.parseInt(st.nextToken());
                    child[n][1] = Integer.parseInt(st.nextToken());
                }
            }

            // 재귀를 통해 연산 후 값 구하기
            answer.append("#" + tc + " " + (int)postorder(1) + "\n");
        }

        // 출력
        System.out.println(answer);
    }

    private static double postorder(int n) {

        // 리프 노드인 경우, 해당 노드의 값을 리턴
        if(child[n][0] == 0) return Double.parseDouble(node[n]);

        // 리프 노드가 아니라면 해당 노드는 연산자
        // 왼쪽 서브 트리, 오른쪽 서브 트리의 결과 값을 해당 연산자로 계산 후 리턴
        double left = postorder(child[n][0]);
        double right = postorder(child[n][1]);

        if(node[n].equals("+")) return left + right;
        else if(node[n].equals("-")) return left - right;
        else if(node[n].equals("*")) return left * right;
        else return left / right;
    }
}