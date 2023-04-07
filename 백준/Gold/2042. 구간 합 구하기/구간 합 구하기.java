import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static long[] arr;
	static long[] fenwick_tree;
	
	private static void update(int idx, long value1, long value2) {
		
		while(idx <= N) {
			fenwick_tree[idx] -= value1;
			fenwick_tree[idx] += value2;
			idx += (idx & -idx);
		}
		
	}
	
	private static long sum(int idx) {
		
		long result = 0;
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
		int K = Integer.parseInt(st.nextToken());
		
		arr = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		fenwick_tree = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			update(i, 0, arr[i]);
		}
		
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1) {
				update(b, arr[b], c);
				arr[b] = c;
			}
			else if(a == 2) {
				sb.append((sum((int)c) - sum(b - 1)) + "\n");
			}
		}
		
		System.out.println(sb);
	}

}