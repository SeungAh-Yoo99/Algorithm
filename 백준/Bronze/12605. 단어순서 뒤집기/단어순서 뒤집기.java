import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Stack<String> stack;
        for (int tc = 1; tc <= N; tc++) {
            st = new StringTokenizer(br.readLine()); // 입력 받은 문자열을 공백 기준으로 슬라이싱

            stack = new Stack<>();
            while(st.hasMoreTokens()) { // 남은 단어가 있다면
                stack.push(st.nextToken()); // 스택에 넣기
            }

            result.append("Case #").append(tc).append(": ");
            while(!stack.isEmpty()) { // 단어 하나씩 꺼내서 result에 담기
                result.append(stack.pop()).append(" ");
            }
            result.append("\n");
        }

        // 출력
        System.out.print(result);
    }
}