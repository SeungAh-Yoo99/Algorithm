import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			boolean[][] student = new boolean[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				student[i][i] = true;
			}
			
			int M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				student[a][b] = true;
			}
			
			// 플로이드 워셜
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					for (int k = 1; k <= N; k++) {
						if(student[j][i] && student[i][k]) student[j][k] = true;
					}
				}
			}
			
			int result = 0;
			for (int i = 1; i <= N; i++) {
				boolean flag = true;
				for (int j = 1; j <= N; j++) {
					if(!student[i][j] && !student[j][i]) {
						flag = false;
						break;
					}
				}
				if(flag) result++;
			}
			
			sb.append("#" + tc + " " + result + "\n");
		}
		
		System.out.println(sb);
	}

}