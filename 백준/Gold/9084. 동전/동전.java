import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int N, M;
        int[] coin;
        long[][] dp;
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());

            coin = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }

            M = Integer.parseInt(br.readLine());
            dp = new long[N][M + 1];

            for (int i = 0; i <= M; i += coin[N - 1]) {
                dp[N - 1][i] = 1;
            }

            for (int i = N - 2; i >= 0; i--) {

                dp[i][0] = 1;
                for (int j = 1; j <= M; j++) {
                    if(j - coin[i] >= 0) {
                        dp[i][j] += dp[i][j - coin[i]];

                    }
                    for (int k = N - 1; k > i; k--) {
                        if(j - coin[k] >= 0) dp[i][j] += dp[k][j - coin[k]];
                    }
                }
            }

            result.append(dp[0][M] + "\n");
        }

        System.out.print(result);
    }
}