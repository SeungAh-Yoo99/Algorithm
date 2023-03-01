import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static int[][] dp;
	static int result;
	
	private static void getAA(int node) {
		/*
		 * 현재 노드가 얼리 아답터가 아니면
		 * 모든 자식 노드가 얼리 아답터이어야 하므로
		 * 자식 노드가 얼리 아답터인 경우를 더해줌
		 * 
		 * 현재 노드가 얼리 아답터라면
		 * 자식 노드는 얼리 아답터거나 아니거나 상관 없으므로
		 * 둘 중 더 작은 수를 더해줌
		*/
		
		dp[node][0] = 0;
		dp[node][1] = 1;
		visited[node] = true;
		
		ArrayList<Integer> tmpList = list.get(node); // node의 자녀 노드 리스트를 가져옴
		
		for (int i = 0; i < tmpList.size(); i++) {
			int child = tmpList.get(i);
			if(!visited[child]) {
				getAA(child); // 자식 노드 dfs
				dp[node][0] += dp[child][1];
				dp[node][1] += Math.min(dp[child][0], dp[child][1]);
			}
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 친구 관계 트리의 정점 개수
		list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		 
		for (int i = 1; i < N; i++) { // N개의 정점 입력
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		 
		// dp[i][0]은 i노드가 얼리아답터가 아닌 경우의 수
		// dp[i][1]은 i노드가 얼리아답터일 경우의 수
		dp = new int[N + 1][2];
		visited = new boolean[N + 1];
		
		// dfs
		getAA(1);
		 
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}

}