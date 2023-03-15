import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		final int MAX_VALUE = 5_000_001;
		
		int TC = Integer.parseInt(br.readLine());
for1:	for (int tc = 0; tc < TC; tc++) {
			// 입력
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				Arrays.fill(arr[i], MAX_VALUE);
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				arr[S][E] = Math.min(arr[S][E], T);
				arr[E][S] = Math.min(arr[E][S], T);
			}
			for (int i = 0; i < W; i++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken());
				int E = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());
				arr[S][E] = Math.min(arr[S][E], -T);;
			}
			
			// 출발
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					for (int k = 1; k <= N; k++) {
						arr[j][k] = Math.min(arr[j][k], arr[j][i] + arr[i][k]);
					}
				}
			}
			
			for (int i = 1; i <= N; i++) {
				if(arr[i][i] < 0) {
					sb.append("YES\n");
					continue for1;
				}
			}
			sb.append("NO\n");
		}

		// 출력
		System.out.println(sb);
	}

}