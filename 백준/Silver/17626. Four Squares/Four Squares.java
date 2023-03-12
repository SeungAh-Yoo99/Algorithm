import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			int j = 1;
			while(i + Math.pow(j, 2) <= n) {
				int tmp = (int) (i + Math.pow(j, 2));
				dp[tmp] = Math.min(dp[tmp], dp[i] + 1);
				j++;
			}
		}
		
		System.out.println(dp[n]);
	}

}