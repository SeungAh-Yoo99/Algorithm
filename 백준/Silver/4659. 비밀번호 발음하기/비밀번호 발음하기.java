import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {

    // 모음
    static List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        String pwd = br.readLine();
        boolean answer;
        while(!pwd.equals("end")) {

            answer = true;

            // 조건 1. 모음 하나를 반드시 포함하여야 한다.
            if(!condition1(pwd)) {
                answer = false;
            }

            // 조건 2. 모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
            if(answer && !condition2(pwd)) {
                answer = false;
            }

            // 조건 3. 같은 글자가 연속적으로 두번 오면 안되나, ee와 oo는 허용한다.
            if(answer && !condition3(pwd)) {
                answer = false;
            }

            // 품질이 낮게 평가되는 경우
            if(!answer)
                result.append("<").append(pwd).append(">").append(" is not acceptable.").append("\n");
            else result.append("<").append(pwd).append(">").append(" is acceptable.").append("\n");

            pwd = br.readLine();
        }

        System.out.print(result);
    }


    private static boolean condition1(String s) {

        for(int i = 0; i < s.length(); i++) {
            if(vowels.contains(s.charAt(i))) return true;
        }

        return false;
    }

    private static boolean condition2(String s) {

        boolean isVowels = false;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {

            // 모음인 경우
            if(vowels.contains(s.charAt(i))) {
                // 이전 문자도 모음인 경우
                if(isVowels) count++;
                // 이전 문자는 자음인 경우
                else {
                    isVowels = true;
                    count = 1;
                }
            }
            // 자음인 경우
            else {
                // 이전 문자는 모음인 경우
                if(isVowels) {
                    isVowels = false;
                    count = 1;
                }
                // 이전 문자도 자음인 경우
                else count++;
            }

            // 모음 혹은 자음이 3개 연속으로 온 경우
            if(count == 3) return false;
        }

        return true;
    }

    private static boolean condition3(String s) {

        for (int i = 1; i < s.length(); i++) {
            // 같은 글자가 연속 두번 오고, e나 o가 아닌 경우
            if(s.charAt(i) == s.charAt(i - 1) && s.charAt(i) != 'e' && s.charAt(i) != 'o')
                return false;

        }

        return true;
    }
}