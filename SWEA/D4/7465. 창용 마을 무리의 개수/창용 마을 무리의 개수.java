import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] parent;
	
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) {
			if(x < y) parent[y] = x;
			else parent[x] = y;
		}
	}
	
	private static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스의 수 T 입력
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			// 사람의 수 N, 서로 알고 있는 사람의 관계 수 M 입력
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 사람의 관계를 담을 배열
			parent = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}
			
			// 사람 관계 입력
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}
			
			for (int i = 1; i <= N; i++) {
				find(i);
			}
			
			boolean[] visited = new boolean[N + 1];
			int result = 0;
			for (int i = 1; i <= N; i++) {
				int n = find(i);
				if(!visited[n]) {
					visited[n] = true;
					result++;
				}
			}
			sb.append(result + "\n");
		}
		
		System.out.println(sb);
	}

}