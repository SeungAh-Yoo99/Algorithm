import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static ArrayList<ArrayList<Integer>> list;
	static int k;
	static int[] depth;
	static int[][] parent;
	
	private static void getDepth() {
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {1, 0});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int now = tmp[0];
			int d = tmp[1];
			
			for (int i = 0; i < list.get(now).size(); i++) {
				int next = list.get(now).get(i);
				if(next != 1 && depth[next] == 0) {
					depth[next] = d + 1;
					parent[0][next] = now;
					q.add(new int[] {next, d + 1});
				}
			}
		}
	}
	
	private static void getParent() {
		
		for (int i = 1; i <= k; i++) {
			for (int j = 2; j <= N; j++) {
				parent[i][j] = parent[i - 1][parent[i - 1][j]];
			}
		}
		
	}
	
	private static int lca(int a, int b) {
		// depth가 더 큰 수를 b에 저장
		if(depth[a] > depth[b]) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		// b의 조상 중 a와 depth가 같은 조상을 b에 저장
		int sub = depth[b] - depth[a];
		for (int i = k; i >= 0; i--) {
			if(Math.pow(2, i) <= sub) {
				b = parent[i][b];
				sub -= Math.pow(2, i);
			}
		}
		
		// 같은 depth로 올려줬을 때 같은 값이라면 리턴
		if(a == b) return a;
		
		// 공통 조상 중 가장 밑에 있는 조상 바로 밑 구하기
		for (int i = k; i >= 0; i--) {
			if(parent[i][a] != parent[i][b]) {
				a = parent[i][a];
				b = parent[i][b]; 
			}
		}
		
		return parent[0][a];
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		// 2^k >= N인 k 구하기
		
		for (int i = 0; i <= N; i++) {
			k = i;
			if(Math.pow(2, i) >= N) break;
		}
		
		depth = new int[N + 1];
		parent = new int[k + 1][N + 1];
		
		// 각 노드의 depth와 첫 번째 부모 구하기
		getDepth();
		
		// 각 노드의 2^i 번째 조상 구하기
		getParent();
		
		// M개의 공통 조상 구하기
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(lca(a, b) + "\n");
		}
		
		System.out.println(sb);
	}
}