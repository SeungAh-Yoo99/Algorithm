import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    /*
    1번 패턴의 시작 100, 끝 1
    2번 패턴 01
     */

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String result = "SUBMARINE";

        int index = 0; // 현재 확인 중인 곳

        while(index < input.length()) {

            // 현재 위치가 1번 패턴의 시작인 경우
            if(index < input.length() - 2
                    && input.substring(index, index + 3).equals("100")) {

                index += 3;

                // 0 반복의 끝을 찾기
                while(index < input.length() && input.charAt(index) == '0')
                    index++;
                // 1번 패턴의 끝을 찾지 못한 경우
                if(index == input.length()) {
                    result = "NOISE";
                    break;
                }

                index++;

                // 1 반복의 끝을 찾기
                while(index < input.length() && input.charAt(index) == '1')
                    index++;

                // 만약 현재 위치가 또 다른 1번 패턴의 위치인 경우
                if(index < input.length() - 2 && input.substring(index - 2, index + 2).equals("1100")) {
                    index--;
                }
            }
            // 현재 위치가 2번 패턴의 시작인 경우
            else if(index < input.length() - 1
                    && input.substring(index, index + 2).equals("01")) {
                index += 2;
            }
            // 현재 위치에선 1, 2번 패턴을 모두 시작할 수 없는 경우
            else {
                result = "NOISE";
                break;
            }
        }

        System.out.println(result);
    }
}
