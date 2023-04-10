import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][][] dp = new int[N - 1][3][3];
		
		// 초기값
		st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int g1 = Integer.parseInt(st.nextToken());
		int b1 = Integer.parseInt(st.nextToken());
		
		// 초기값 세팅
		st = new StringTokenizer(br.readLine());
		int r2 = Integer.parseInt(st.nextToken());
		int g2 = Integer.parseInt(st.nextToken());
		int b2 = Integer.parseInt(st.nextToken());
		dp[0][0][1] = g1 + r2;
		dp[0][0][2] = b1 + r2;
		dp[0][1][0] = r1 + g2;
		dp[0][1][2] = b1 + g2;
		dp[0][2][0] = r1 + b2;
		dp[0][2][1] = g1 + b2;
		
		// 다음 값들
		for (int i = 1; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int[] now = new int[3];
			for (int j = 0; j < 3; j++) {
				now[j] = Integer.parseInt(st.nextToken());
			}
			
			// R
			for (int j = 0; j < 3; j++) {
				if(dp[i - 1][1][j] == 0) dp[i][0][j] = dp[i - 1][2][j] + now[0];
				else if(dp[i - 1][2][j] == 0) dp[i][0][j] = dp[i - 1][1][j] + now[0];
				else dp[i][0][j] = Math.min(dp[i - 1][1][j], dp[i - 1][2][j]) + now[0];
			}
			
			// G
			for (int j = 0; j < 3; j++) {
				if(dp[i - 1][0][j] == 0) dp[i][1][j] = dp[i - 1][2][j] + now[1];
				else if(dp[i - 1][2][j] == 0) dp[i][1][j] = dp[i - 1][0][j] + now[1];
				else dp[i][1][j] = Math.min(dp[i - 1][0][j], dp[i - 1][2][j]) + now[1];
			}
			
			// B
			for (int j = 0; j < 3; j++) {
				if(dp[i - 1][0][j] == 0) dp[i][2][j] = dp[i - 1][1][j] + now[2];
				else if(dp[i - 1][1][j] == 0) dp[i][2][j] = dp[i - 1][0][j] + now[2];
				else dp[i][2][j] = Math.min(dp[i - 1][0][j], dp[i - 1][1][j]) + now[2];
			}
		}
		
		// 마지막 값은 첫 번째 값이랑 같으면 안됨
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i == j) continue;
				result = Math.min(dp[N - 2][i][j], result);
			}
		}
		
		System.out.println(result);
	}

}