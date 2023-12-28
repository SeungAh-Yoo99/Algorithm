import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] string = br.readLine().toCharArray();

        String result = "SUBMARINE";

        int idx = 0; // 확인 중인 문자 순서
        while(idx < string.length) {

            // 1. 시작이 "100"인 경우
            if(string[idx] == '1' && string[idx + 1] == '0' && string[idx + 2] == '0') {
                idx += 3;

                // '1'이 나올 때까지 뒤로
                while(idx < string.length && string[idx] == '0') idx++;

                // '1'을 찾지 못했다면 잡음
                if(idx == string.length) {
                    result = "NOISE";
                    break;
                }

                // '1'이 끝날 때까지 뒤로
                while(idx < string.length && string[idx] == '1') idx++;
            }
            // 2. 시작이 "01"인 경우
            else if (string[idx] == '0' && string[idx + 1] == '1') {
                 idx += 2;
            }
            // 3. 1번 패턴 이후 다시 1번 패턴이 나오는 경우
            else if (idx > 2 && string[idx - 2] == '1' && string[idx - 1] == '1' && string[idx] == '0') {
                idx--;
            }
            // 4. 위 경우에 해당하지 않으면 잡음
            else {
                result = "NOISE";
                break;
            }
        }

        // 출력
        System.out.println(result);
    }
}