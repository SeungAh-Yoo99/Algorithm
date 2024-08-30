import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        // 재민이가 부르는 수를 저장
        Stack<Integer> stack = new Stack<>();

        int n;
        for (int i = 0; i < K; i++) {
            n = Integer.parseInt(br.readLine());

            // 0을 불렀다면 잘못 부른 수 없애줌
            if(n == 0 && !stack.isEmpty()) stack.pop();
            else stack.push(n);
        }

        long result = 0;
        while(!stack.isEmpty()) result += stack.pop();
        System.out.println(result);
    }
}