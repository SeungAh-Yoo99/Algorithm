import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[][] dp = new boolean[N + 1][N + 1];
		
		// 길이가 1인 수열은 무조건 팰린드롬
		for (int i = 1; i <= N; i++) {
			dp[i][i] = true;
		}
		
		// 길이가 2인 수열은 두 수가 같으면 팰린드롬
		for (int i = 1; i < N; i++) {
			if(arr[i] == arr[i + 1]) dp[i][i + 1] = true;
		}
		
		// 길이가 3 이상은 수열은 시작과 끝이 같을 때 그 안이 팰린드롬이면 팰린드롬
		for (int i = 2; i < N; i++) {
			for (int j = 1; j <= N - i; j++) {
				if(arr[j] == arr[j + i]) { // 시작과 끝이 같을 때
					if(dp[j + 1][j + i - 1]) { // 그 안이 팰린드롬이면
						dp[j][j + i] = true; // 그 수열도 팰린드롬
					}
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			sb.append((dp[S][E] ? 1 : 0) + "\n");
		}
		
		System.out.println(sb);
	}

}