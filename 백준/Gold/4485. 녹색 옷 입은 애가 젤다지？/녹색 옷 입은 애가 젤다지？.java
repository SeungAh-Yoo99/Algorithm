import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map;
	static int[][] visited;
	
	private static int bfs() {
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
		pq.add(new int[] {0, 0, map[0][0]});
		visited[0][0] = map[0][0];
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			int x = now[0];
			int y = now[1];
			int cost = now[2];
			
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if(visited[nx][ny] > cost + map[nx][ny]) {
						visited[nx][ny] = cost + map[nx][ny];
						pq.add(new int[] {nx, ny, cost + map[nx][ny]});
					}
				}
			}
		}
		
		return visited[N - 1][N - 1];
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = 1;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j]  = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[i], Integer.MAX_VALUE);
			}
			
			sb.append("Problem " + tc++ + ": " + bfs() + "\n");
		}
		
		System.out.println(sb);
	}

}