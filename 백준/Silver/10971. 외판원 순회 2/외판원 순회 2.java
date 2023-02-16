import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] W;
	static boolean[] visited;
	static int result = (int) 10e9;
	
	// c = 현재 몇 번째 방문 도시인지, s = 어디서부터 왔는지, cost = 비용이 얼마인지
	private static void tsp(int c, int s, int cost) {
		if(c == N && W[s][1] != 0) { // 마지막 도시에서 출발 도시로 가는 길이 있을 때만
			result = result < cost + W[s][1] ? result : cost + W[s][1];
			return;
		}
		
		for (int i = 2; i <= N; i++) {
			if(!visited[i] && W[s][i] != 0) { // 방문한 적 없고 길이 있을 때만
				visited[i] = true; // 방문 처리
				tsp(c + 1, i, cost + W[s][i]);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N 입력
		N = Integer.parseInt(br.readLine());
		
		// 비용 행렬 입력
		W = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 방문 체크 배열
		visited = new boolean[N + 1];
		
		// tsp
		tsp(1, 1, 0);
		
		// 출력
		System.out.println(result);
	}

}