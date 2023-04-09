import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	static int N;
	static char[][] graph;
	static boolean[][] visited;
	static int result;
	
	private static void countLandMines(int x, int y) { // 지뢰 주변의 땅에 카운트
		
		int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
		
		for (int i = 0; i < 8; i++) { // 8방 탐색
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 체크
				// 지뢰가 아니라면 카운트
				if(graph[nx][ny] != '*') graph[nx][ny] += 1;
			}
		}
	}
	
	private static void bfs(int x, int y) {
		
		int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int i = 0; i < 8; i++) { // 8방 탐색
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 체크
					if(graph[nx][ny] != '*' && !visited[nx][ny]) { // 지뢰가 아니고 방문전이라면
						visited[nx][ny] = true; // 방문 체크
						if(graph[nx][ny] == '0') { // 0이라면
							q.add(new int[] {nx, ny}); // 큐에 넣어줌
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 입력
			N = Integer.parseInt(br.readLine());
			
			graph = new char[N][N];
			for (int i = 0; i < N; i++) {
				graph[i] = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					if(graph[i][j] == '.') graph[i][j] = '0';
				}
			}
			
			result = 0;
			
			// 주변 지뢰 개수 세기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(graph[i][j] == '*') countLandMines(i, j);
				}
			}
			
			visited = new boolean[N][N];
			
			// 주변 지뢰 개수가 0인 칸들 먼저 방문 체크
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(graph[i][j] == '0' && !visited[i][j]) {
						result++;
						bfs(i, j);
					}
				}
			}
			
			// 나머지 칸들 방문 체크
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(graph[i][j] != '*' && !visited[i][j]) {
						visited[i][j] = true;
						result++;
					}
				}
			}
			
			sb.append("#" + tc + " " + result + "\n");
		}
		
		System.out.println(sb);
	}

}