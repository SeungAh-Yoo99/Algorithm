import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2진수 입력
        char[] binary = br.readLine().toCharArray();

        // 2진수 -> 8진수를 담을 곳
        StringBuilder result = new StringBuilder();

        int tmp;
        for (int i = binary.length - 1; i >= 0; i -= 3) {
            tmp = 0;

            // 2진수를 3개씩 끊어서 읽으면 8진수가 됨
            for (int j = 0; j < 3; j++) {
                if(i - j < 0) break;

                tmp += (binary[i - j] - '0') * Math.pow(2, j);
            }

            result.append(tmp);
        }

        // 2진수를 뒤에서부터 8진수로 바꿔주었기 때문에 답이 뒤집혀 있으므로 반대로 출력
        System.out.println(result.reverse());
    }
}