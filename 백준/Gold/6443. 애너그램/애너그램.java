import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static char[] string;
    static int[] visited;
    static Stack<Character> stack;
    static StringBuilder result;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < N; tc++) {
            string = br.readLine().toCharArray();

            // 문자열에 사용된 알파벳 개수
            visited = new int[26];
            for (int i = 0; i < string.length; i++) {
                visited[string[i] - 'a']++;
            }

            stack = new Stack<>();
            combi(0);
        }

        System.out.println(result);
    }

    private static void combi(int n) {

        if(n == string.length) {
            for (char c : stack) {
                result.append(c);
            }
            result.append("\n");
            return;
        }

        for (int i = 0; i < 26; i++) {
            if(visited[i] > 0) {
                visited[i]--;
                stack.push((char)(i + 'a'));
                combi(n + 1);
                visited[i]++;
                stack.pop();
            }
        }
    }
}