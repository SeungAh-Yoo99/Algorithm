import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] parent;
	
	private static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x != y) {
			if(x > y) parent[x] = y;
			else parent[y] = x;
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
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// N 크기의 배열 생성(1부터 시작)
			parent = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}
			
			// M개의 연산 수행
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(n == 0) { // union
					union(a, b);
				}
				else { // 두 원소가 같은 집합에 포함되어 있는지 확인
					a = find(a);
					b = find(b);
					if(a == b) sb.append(1);
					else sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
