import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	private static int N;
	private static int[] fenwick_tree;
	
	private static void update(int idx, int value) {
		
		while(idx <= N) {
			fenwick_tree[idx] += value;
			idx += (idx & -idx);
		}
		
	}
	
	private static int sum(int idx) {
		
		int result = 0;
		while(idx > 0) {
			result += fenwick_tree[idx];
			idx -= (idx & -idx);
		}
		return result;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		fenwick_tree = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			update(i, arr[i]);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int I = Integer.parseInt(st.nextToken());
			int J = Integer.parseInt(st.nextToken());
			sb.append((sum(J) - sum(I - 1)) + "\n");
		}
		System.out.println(sb);
	}

}
