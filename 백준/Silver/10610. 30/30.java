import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        // 3의 배수는 자릿수를 모두 더했을 때의 수도 3의 배수
        // 30의 배수여야 하므로 0이 하나 이상 있어야 함
        int sum = 0;
        int[] count = new int[10];
        for (int i = 0; i < N.length(); i++) {
            sum += N.charAt(i) - '0';
            count[N.charAt(i) - '0']++;
        }

        // sum이 3의 배수이고 0을 하나 이상 가지고 있다면 답을 구하고 아니면 -1 출력
        if(sum % 3 != 0 || count[0] <= 0) {
            System.out.println(-1);
            return;
        }

        // 어떤 수로 조합해도 마지막이 0으로 끝나면 30배수의 수가 됨.
        // 가장 큰 수를 구해야 하므로 큰 숫자부터 개수대로 출력
        StringBuilder answer = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < count[i]; j++) {
                answer.append(i);
            }
        }
        System.out.println(answer);
    }
}