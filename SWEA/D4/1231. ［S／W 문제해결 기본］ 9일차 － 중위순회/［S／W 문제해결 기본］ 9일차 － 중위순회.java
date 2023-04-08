import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static char[] key;
	static int[][] child;
	static StringBuilder result;
	
	private static void inOrder(int node) {
		// left child가 있으면 재귀
		if(child[node][0] != 0) inOrder(child[node][0]);
		
		// 자신 추가
		result.append(key[node]);
		
		// right child가 있으면 재귀
		if(child[node][1] != 0) inOrder(child[node][1]);
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		result = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			result.append("#" + tc + " ");
			
			N = Integer.parseInt(br.readLine());
			
			key = new char[N + 1];
			child = new int[N + 1][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int node = Integer.parseInt(st.nextToken());
				key[node] = st.nextToken().toCharArray()[0];
				if(st.hasMoreTokens()) child[node][0] = Integer.parseInt(st.nextToken());
				if(st.hasMoreTokens()) child[node][1] = Integer.parseInt(st.nextToken());
			}
			
			// in-order 순회
			inOrder(1);
			result.append("\n");
		}
		
		// 출력
		System.out.println(result);
	}

}