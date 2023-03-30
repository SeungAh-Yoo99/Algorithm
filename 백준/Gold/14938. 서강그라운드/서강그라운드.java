import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[] item = new int[n + 1];
		int[][] graph = new int[n + 1][n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
			Arrays.fill(graph[i], 1501);
			graph[i][i] = 0;
		}
		
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			graph[a][b] = l;
			graph[b][a] = l;
		}
		
		// 플로이드 워셜로 최소 거리 구하기
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
						graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
				}
			}
		}
		
		// 최소거리가 수색범위보다 작다면 아이템 수 더해줌
		int result = 0;
		for (int i = 1; i <= n; i++) {
			int tmp = 0;
			for (int j = 1; j <= n; j++) {
				if(graph[i][j] <= m) tmp += item[j];
			}
			result = Math.max(result, tmp);
		}
		
		// 출력
		System.out.println(result);
	}

}