import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] wines = new int[n];
        for (int i = 0; i < n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        // dp[i][0] := 현재 와인 마시지 않음
        // dp[i][1] := 현재 와인 마심 - 앞 단계 와인 마시지 않음
        // dp[i][2] := 현재 와인 마심 - 앞 단계 와인 마심
        int[][] dp = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] = wines[0];
        dp[0][2] = wines[0];

        for (int i = 1; i < n; i++) {

            // 현재 와인 마시지 않는 경우 - 이전 단계애서 가장 큰 수 저장
            dp[i][0] = Math.max(Math.max(dp[i - 1][0], dp[i - 1][1]), dp[i - 1][2]);

            // 현재 와인 마시는 경우 - 앞 와인 안마심
            dp[i][1] = dp[i - 1][0] + wines[i];

            // 현재 와인 마시는 경우 - 앞 와인 마심
            dp[i][2] = dp[i - 1][1] + wines[i];
        }

        // 마지막 단계 중 가장 큰 수 출력
        System.out.println(Math.max(Math.max(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]));
    }
}
