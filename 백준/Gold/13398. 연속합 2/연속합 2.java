import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i][0] := i를 포함하지 않음
        // dp[i][1] := i를 포함한 수열 중 아직 제거한 수 없음
        // dp[i][2] := i를 포함한 수열 중 제거한 수 있음
        int[][] dp = new int[n][3];
        dp[0][0] = 0;
        dp[0][1] = arr[0];
        dp[0][2] = arr[0];

        int answer = Math.max(-100_000_001, arr[0]);

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = Math.max(dp[i - 1][1], 0) + arr[i];
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][2]) + arr[i];
            answer = Math.max(Math.max(dp[i][0], dp[i][1]), Math.max(dp[i][2], answer));
        }

        System.out.println(answer);
    }
}
