import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken()); // 부피
				arr[i][1] = Integer.parseInt(st.nextToken()); // 가치
			}
            
			// dp
			int[] dp = new int[K + 1];
			for (int i = 0; i < N; i++) {
				if(arr[i][0] > K) break;
				for (int j = K - arr[i][0]; j >= 0; j--) {
					dp[arr[i][0] + j] = Math.max(dp[arr[i][0] + j], dp[j] + arr[i][1]);
				}
			}
			
			sb.append("#" + tc + " " + dp[K] + "\n");
		}
		System.out.println(sb);
	}

}