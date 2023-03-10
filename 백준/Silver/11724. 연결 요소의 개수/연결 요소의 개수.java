import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	private static int[] parent;
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a < b) parent[b] = a;
		else if(a > b) parent[a] = b;
	}
	
	private static int find(int i) {
		if(parent[i] == i) return i;
		else {
			return parent[i] = find(parent[i]);
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
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
		for (int p : parent) {
			visited[p] = true;
		}
		
		int result = 0;
		for (int i = 1; i <= N; i++) {
			if(visited[i]) result++;
		}
		
		System.out.println(result);
	}

}