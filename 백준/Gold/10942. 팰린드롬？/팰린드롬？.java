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
		for (int i = 1; i <= N; i++) { // 수열 길이
			for (int j = 1; j <= N - i + 1; j++) { // 시작 위치
				// 시작 위치와 끝 위치가 다르면 확인 안해도 됨
				if(arr[j] != arr[j + i - 1]) continue;
				
				dp[i][j] = true;
				int start = j + 1;
				int end = j + i - 2;
				while(start <= end) {
					if(arr[start++] != arr[end--]) {
						dp[i][j] = false;
						break;
					}
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			int result = 0;
			if(dp[E - S + 1][S]) result = 1;

			sb.append(result + "\n");
		}
		
		System.out.println(sb);
	}

}