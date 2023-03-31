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
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[][] graph = new int[N + 1][N + 1];
			Arrays.fill(graph[0], 1);
			
			int result = 0;
			for (int i = 1; i <= N; i++) {
				graph[i][i] = graph[i - 1][i];
				for (int j = i + 1; j <= N; j++) {
					if(arr[i] < arr[j]) {
						graph[i][j] = Math.max(graph[i - 1][j], graph[i][i] + 1);
						result = Math.max(result, graph[i][j]);
					}
					else {
						graph[i][j]= graph[i - 1][j];
					}
				}
			}
			
			sb.append("#" + tc + " " + result + "\n");
		}
		
		System.out.println(sb);
	}
}