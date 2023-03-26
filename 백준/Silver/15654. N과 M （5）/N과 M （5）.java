import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visited;
	static int[] result;
	static StringBuilder sb;
	
	private static void perm(int n) {
		if(n == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[n] = arr[i];
				perm(n + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		visited = new boolean[N];
		result = new int[M];
		
		perm(0);
		
		System.out.println(sb);
	}

}