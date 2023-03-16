import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[][][] map; // x좌표, y좌표, (벽을 안부시고 왔을 때 최소값, 벽을 부시고 왔을 때 최소값)
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	private static void bfs() { // 모든 벽이 있을 때의 경로를 구하는 bfs
		
		Queue<int[]> q = new LinkedList<>();
		map[1][1][0] = 1; // 벽을 안부시고 왔을 때의 최소값
		map[1][1][1] = 0; // 벽을 부수고 왔을 때의 최소값
		q.add(new int[] {1, 1, 0}); // x좌표, y좌표, (벽을 부신 적 있다면 1, 없다면 0)
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(nx >= 1 && nx <= N && ny >= 1 && ny <= M) { // 범위 체크
					if(now[2] == 1) { // 벽을 이미 부수고 온 적이 있다면
						// 벽이 아니고 벽을 부수고 온 루트 중 최소값이면
						if(map[nx][ny][0] != -1)
							// 벽을 부수고 처음 왔거나 벽을 부수고 온 루트 중 최소값이면
							if(map[nx][ny][1] == 0 || map[nx][ny][1] > map[now[0]][now[1]][1] + 1) {
								map[nx][ny][1] = map[now[0]][now[1]][1] + 1; // 정보 갱신
								q.add(new int[] {nx, ny, 1}); // 큐에 담기
							}
					}
					else { // 벽을 아직 부순 적 없을 때
						if(map[nx][ny][0] == -1) { // 벽이면 부수고 들어가는 경우 더해줌
							map[nx][ny][1] = map[now[0]][now[1]][0] + 1; // 정보 갱신
							q.add(new int[] {nx, ny, 1}); // 큐에 담기
						}
						else if(map[nx][ny][0] != -1) // 벽이 아니고 
							// 벽을 부수지 않고 처음 온 경우나 최소 루트라면
							if(map[nx][ny][0] == 0 || map[nx][ny][0] > map[now[0]][now[1]][0] + 1) {
							map[nx][ny][0] = map[now[0]][now[1]][0] + 1; // 정보 갱신
							q.add(new int[] {nx, ny, 0}); // 큐에 담기
						}
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][M + 1][2];
		
		for (int i = 1; i <= N; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				// 벽일 경우 -1 저장
				if(tmp[j] == '1') map[i][j + 1][0] = -1;
			}
		}
		
		// bfs로 최단 경로 구하기
		bfs();
		
		if(map[N][M][0] == 0 && map[N][M][1] == 0) System.out.println(-1);
		else {
			int result = Integer.MAX_VALUE;
			if(map[N][M][0] != 0) result = Math.min(result, map[N][M][0]);
			if(map[N][M][1] != 0) result = Math.min(result, map[N][M][1]);
			System.out.println(result);
		}
	}

}