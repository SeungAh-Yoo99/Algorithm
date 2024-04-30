import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] coin = new int[k][2];

        long[][] dp = new long[T + 1][k];
        Arrays.fill(dp[0], 1);

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            coin[i][0] = Integer.parseInt(st.nextToken());
            coin[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(coin, (o1, o2) -> o1[0] - o2[0]);

        // 가장 작은 금액의 동전의 경우는 미리 구해놓기
        int p = coin[0][0], c = 1;
        while(c <= coin[0][1] && p * c <= T) {
            dp[p * c][0]++;
            c++;
        }

        for (int i = 1; i < k; i++) { // 동전 순서대로 확인

            // 현재 동전의 금액
            p = coin[i][0];

            for (int j = 1; j <= T; j++) { // 만들고자 하는 금액
                c = 0;
                while((c <= coin[i][1]) && (j - p * c >= 0)) {
                    dp[j][i] += dp[j - p * c][i - 1];
                    c++;
                }
            }
        }

        System.out.println(dp[T][k - 1]);
    }
}