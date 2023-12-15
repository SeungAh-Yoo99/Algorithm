import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        주어진 문자열이 팰린드롬이 아닌 경우, 답은 '문자열 길이'
        주어진 문자열이 모두 같은 문자로 이루어진 경우 답은 '-1'
        팰린드롬이지만, 모두 같은 문자열로 이루어지진 않은 경우, 문자 하나만 제외해도 팰린드롬은 깨짐. 답은 '문자열 길이 - 1'
         */

        // 하나의 문자열 입력
        char[] string = br.readLine().toCharArray();

        // 팰린드롬인지 확인
        int result = -1;
        int s = 0, e = string.length - 1;
        while(s <= e) {
            if(string[s] != string[e]) { // 팰린드롬이 아닐 경우
                result = string.length;
                break;
            }
            s++;
            e--;
        }

        if(result == -1) { // 팰린드롬일 경우 모든 문자가 같은지 확인
            for (int i = 1; i < string.length; i++) {
                if(string[0] != string[i]) { // 같은 문자 아닌걸 발견했다면
                    result = string.length - 1; // 문자열 길이 - 1이 답
                    break;
                }
            }
        }

        System.out.println(result);
    }
}