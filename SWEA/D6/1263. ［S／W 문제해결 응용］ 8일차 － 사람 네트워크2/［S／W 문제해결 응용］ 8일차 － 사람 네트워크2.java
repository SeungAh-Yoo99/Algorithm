import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			
			int[][] graph = new int[N + 1][N + 1];
			for (int i = 1; i <= N; i++) {
				Arrays.fill(graph[i], N * N);
				graph[i][i] = 0;
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					int tmp = Integer.parseInt(st.nextToken());
					if(tmp == 1) graph[i][j] = 1;
				}
			}
			
			// 플로이드 워셜
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					for (int k = 1; k <= N; k++) {
						graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
					}
				}
			}
			
			int result = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				int sum = 0;
				for (int j = 1; j <= N; j++) {
					sum += graph[i][j];
				}
				result = Math.min(result, sum);
			}
			
			sb.append("#" + test_case + " " + result + "\n");
		}
		
		System.out.println(sb);
	}

}