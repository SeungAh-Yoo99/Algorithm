import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 100_001;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 소모되는 연료의 양
        int[][] cost = new int[N][M + 2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
               cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dp[i][j][0]: (i - 1, j - 1) 공간에서 (i, j)로 넘어왔을 때의 최솟값
        // dp[i][j][1]: (i - 1, j) 공간에서 (i, j)로 넘어왔을 때의 최솟값
        // dp[i][j][2]: (i - 1, j + 1) 공간에서 (i, j)로 넘어왔을 때의 최솟값
        int[][][] dp = new int[N][M + 2][3];
        for (int i = 1; i <= M; i++) {
            Arrays.fill(dp[0][i], cost[0][i]);
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i][0], MAX);
            Arrays.fill(dp[i][M + 1], MAX);
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= M; j++) {
                // (i - 1, j - 1)에서 올 수 있는 최솟값
                dp[i][j][0] = Math.min(dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]) + cost[i][j];

                // (i - 1, j)에서 올 수 있는 최솟값
                dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + cost[i][j];

                // (i - 1, j + 1)에서 올 수 있는 최솟값
                dp[i][j][2] = Math.min(dp[i - 1][j + 1][0], dp[i - 1][j + 1][1]) + cost[i][j];
            }
        }

        // dp[N] 중 최솟값 구하기
        int result = MAX;
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < 3; j++) {
                result = Math.min(result, dp[N - 1][i][j]);
            }
        }

        System.out.println(result);
    }
}
