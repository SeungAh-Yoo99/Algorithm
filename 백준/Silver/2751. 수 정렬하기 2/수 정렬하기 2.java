import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 음수 배열
        boolean[] negative = new boolean[1_000_001];
        // 양수 배열
        boolean[] positive = new boolean[1_000_001];

        int temp;
        for (int i = 0; i < N; i++) {
            temp = Integer.parseInt(br.readLine());

            if(temp < 0) {
                negative[-1 * temp] = true;
            }
            else {
                positive[temp] = true;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1_000_000; i > 0; i--) {
            if(negative[i]) result.append(-1 * i).append("\n");
        }
        for (int i = 0; i <= 1_000_000; i++) {
            if(positive[i]) result.append(i).append("\n");
        }
        System.out.println(result);
    }
}