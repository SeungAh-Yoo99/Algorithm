import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int dp[] = new int[n + 1];
		Arrays.fill(dp, n + 1);
		dp[n] = 0;
		
		for (int i = n - 1;i >= 1;i--) {
			if(i * 3 <= n) dp[i] = dp[i * 3] + 1;
			if(i * 2 <= n) dp[i] = Math.min(dp[i], dp[i * 2] + 1);
			dp[i] = Math.min(dp[i], dp[i + 1] + 1);
		}
		
		System.out.println(dp[1]);
	}

}