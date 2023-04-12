import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] parent;

	private static void union(int a, int b) {
		 a = find(a);
		 b = find(b);
		 
		 if(a < b) parent[b] = a;
		 else parent[a] = b;
	}
	
	private static int find(int a) {
		if(parent[a] == a) return a;
		
		return parent[a] = find(parent[a]);
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int tmpA = find(a);
			int tmpB = find(b);
			
			if(parent[tmpA] == parent[tmpB]) {
				System.out.println(i);
				System.exit(0);
			}
			
			union(a, b);
		}
		
		System.out.println(0);
	}

}