import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static char[] string;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        // T := 문자열 개수
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            string = br.readLine().toCharArray();

            result.append(isPalindrome(0, string.length - 1, false) + "\n");
        }

        System.out.println(result);
    }

    // 자체 회문일 경우 0 리턴, 유사회문이면 1리턴, 일반 문자열이라면 2 리턴
    private static int isPalindrome(int s, int e, boolean flag) { // 회문인지 아닌지를 검사할 시작점 s, 끝점 e, 자체 회문 검사 중이라면 flag는 false, 유사회문인지 검사 중이라면 flag는 true

        while(s < e) {
            if(string[s] != string[e]) { // 서로 달라지는 지점을 발견했을 때
                if(flag) { // 유사회문인지 검사 중이었다면
                    return 2;
                }
                else { // 자체회문인지 검사 중이었다면, 하나가 달라진 시점에서 유사회문인지 검사하려 감
                    int tmp = isPalindrome(s + 1, e, true); // 왼쪽 문자열 하나 건너뛴 경우
                    tmp = Math.min(tmp, isPalindrome(s, e - 1, true)); // 오른쪽 문자열 하나 건너 뛴 경우. 두 경우를 검사해 둘 중 하나라도 유사회문이라면 tmp는 1
                    return tmp;
                }
            }
            else {
                s++;
                e--;
            }
        }

        // 여기까지 무사히 왔다면 자체회문이거나 유사회문
        if(flag) return 1;
        else return 0;
    }
}
