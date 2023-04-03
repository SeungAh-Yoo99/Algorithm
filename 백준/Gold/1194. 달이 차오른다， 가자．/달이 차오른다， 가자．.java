import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static char[][] map;
	static boolean[][][] visited;
	
	private static int bfs(int[] start) {
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		Queue<int[]> q = new LinkedList<>();
		
		int key = 0; // key 정보를 나타내는 비트
		
		q.add(new int[] {start[0], start[1], key, 0});
		visited[start[0]][start[1]][0] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					// 키 정보가 다른 경우가 들어왔다면
					if(!visited[nx][ny][now[2]]) {
						if(map[nx][ny] == '.' || map[nx][ny] == '0') {
							visited[nx][ny][now[2]] = true;
							q.add(new int[] {nx, ny, now[2], now[3] + 1});
						}
						else if(map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
							visited[nx][ny][now[2]] = true;
							
							// 키 추가
							int k = now[2] | (1 << (map[nx][ny] - 'a'));
							q.add(new int[] {nx, ny, k, now[3] + 1});
						}
						else if(map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
							// 키가 있을 때만 갈 수 있음
							if(((1 << (map[nx][ny] - 'A')) & now[2]) == 1 << (map[nx][ny] - 'A')) {
								visited[nx][ny][now[2]] = true;
								q.add(new int[] {nx, ny, now[2], now[3] + 1});
							}
						}
						else if(map[nx][ny] == '1') {
							// 도착
							return now[3] + 1;
						}
					}
				}
			}
		}
		
		return -1;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		int[] position = new int[2];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if(map[i][j] == '0') {
					position[0] = i;
					position[1] = j;
				}
			}
		}
		
		visited = new boolean[N][M][64];
		
		int result = bfs(position);
		
		System.out.println(result);
	}

}