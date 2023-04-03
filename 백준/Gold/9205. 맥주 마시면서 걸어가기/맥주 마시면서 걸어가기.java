import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[][] arr;
	static boolean[][] visited;
	
	private static boolean dfs(int node) {
		
		// 도착
		if(node == n + 1) {
			return true;
		}
		
		for (int i = 0; i < n + 2; i++) {
			int cost = Math.abs(arr[node][0] - arr[i][0]) + Math.abs(arr[node][1] - arr[i][1]);
			if(!visited[node][i] && cost <= 1000) {
				visited[node][i] = true;
				visited[i][node] = true;
				if(dfs(i)) return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			
			arr = new int[n + 2][2];
			
			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			visited = new boolean[n + 2][n + 2];
			for (int i = 0; i < n + 2; i++) {
				visited[i][i] = true;
			}
			
			if(dfs(0)) sb.append("happy\n");
			else sb.append("sad\n");
		}
		
		System.out.println(sb);
	}

}