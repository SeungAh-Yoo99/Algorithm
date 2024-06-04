import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[] binary = br.readLine().toCharArray();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[] parent = new int[N + 1];
        int[] depth = new int[N + 1];

        Stack<Integer> stack = new Stack<>();

        // 썩은 사과
        int A = 0, B = 0;

        int node = 0;
        int d = 0;
        stack.push(0);
        for (int i = 0; i < binary.length; i++) {
            if(binary[i] == '0') {
                parent[++node] = stack.peek();
                depth[node] = ++d;
                stack.push(node);
            }
            else {
                d--;
                stack.pop();
            }

            if(i + 1 == X) A = node;
            if(i + 1 == Y) B = node;
        }

        // 썩은 사과 A와 B의 공통 조상 찾기
        while(A != B) {

            if(depth[A] == depth[B]) {
                A = parent[A];
                B = parent[B];
            }
            else if(depth[A] > depth[B]) {
                A = parent[A];
            }
            else {
                B = parent[B];
            }
        }

        // 사과를 나타내는 두 정수 구하기
        int I = 0, J = 0;
        node = 0;
        int tmp;
        for (int i = 0; i < binary.length; i++) {
            if(binary[i] == '0') {
                stack.push(++node);
                if(node == A) I = i + 1;
            }
            else {
                tmp = stack.pop();
                if(tmp == A) J = i + 1;
            }
        }
        System.out.println(I + " " + J);
    }
}