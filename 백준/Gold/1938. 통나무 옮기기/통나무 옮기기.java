import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int N;
	static char[][] map; // 평지 정보
	static int[][] B; // 기둥의 인덱스
	static int d; // 0 := 기둥이 현재 가로 방향, 1 := 기둥이 현재 세로 방향
	static int result = 0;

	public static void main(String[] args) throws Exception{

		// 시작 정보 구하기
		init();
		
		// 시뮬레이션 시작
		bfs();
		
		// 답 출력
		System.out.println(result);
	}
	
	private static void init() throws Exception{ // 시작 정보
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 한 변의 길이 N 입력
		map = new char[N][N];
		B = new int[3][2];
		int b = 0;
		for (int i = 0; i < N; i++) { // 맵 정보 입력
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) { // B, E 정보 구하기
				if(map[i][j] == 'B') {
					B[b][0] = i;
					B[b++][1] = j;
				}
			}
		}
		
		// 현재 기둥이 가로 방향인지, 세로 방향인지 구하기
		if(B[0][0] == B[1][0]) d = 0;
		else d = 1;
	}
	
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][][] visited = new boolean[N][N][2];
		
		q.add(new int[] {B[1][0], B[1][1], d, 0});
		Arrays.fill(visited[B[1][0]][B[1][1]], true);
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			// 돌리기
			if(now[0] - 1 >= 0 && now[0] + 1 < N && now[1] - 1 >= 0 && now[1] + 1 < N) { // 범위 체크
				if(turn(now[0], now[1])) { // 돌릴 수 있음
					if(now[2] == 0 && !visited[now[0]][now[1]][1]) { // 현재 가로 방향, 세로 방향 방문 x
						if(done(now[0], now[1], 1)) { // 도착
							result = now[3] + 1;
							return;
						}
						visited[now[0]][now[1]][1] = true;
						q.add(new int[] {now[0], now[1], 1, now[3] + 1});
					}
					else if(now[2] == 1 && !visited[now[0]][now[1]][0]) { // 현재 세로 방향, 가로 방향 방문 x
						if(done(now[0], now[1], 0)) { // 도착
							result = now[3] + 1;
							return;
						}
						visited[now[0]][now[1]][0] = true;
						q.add(new int[] {now[0], now[1], 0, now[3] + 1});
					}
				}
			}
				
			// 위, 아래, 왼쪽, 오른쪽 이동
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(now[2] == 0) { // 현재 가로 방향
					if(nx >= 0 && nx < N && ny - 1 >= 0 && ny + 1 < N) { // 범위 체크
						if(move(nx, ny, 0) && !visited[nx][ny][0]) { // 이동할 수 있음, 방문 x
							if(done(nx, ny, 0)) { // 도착
								result = now[3] + 1;
								return;
							}
							visited[nx][ny][0] = true;
							q.add(new int[] {nx, ny, 0, now[3] + 1});
						}
					}
				}
				else { // 현재 세로 방향
					if(nx - 1 >= 0 && nx + 1 < N && ny >= 0 && ny < N) { // 범위 체크
						if(move(nx, ny, 1) && !visited[nx][ny][1]) { // 이동할 수 있음, 방문 x
							if(done(nx, ny, 1)) { // 도착
								result = now[3] + 1;
								return;
							}
							visited[nx][ny][1] = true;
							q.add(new int[] {nx, ny, 1, now[3] + 1});
						}
					}
				}
					
			}
		}
	}
	
	private static boolean move(int x, int y, int d) {
		if(d == 0) {
			if(map[x][y - 1] != '1' && map[x][y] != '1' && map[x][y + 1] != '1') return true;
		}
		else {
			if(map[x - 1][y] != '1' && map[x][y] != '1' && map[x + 1][y] != '1') return true;
		}
		
		return false;
	}
	
	private static boolean turn(int x, int y) {
		if(map[x - 1][y - 1] != '1' && map[x - 1][y] != '1' && map[x - 1][y + 1] != '1'
				&& map[x][y - 1] != '1' && map[x][y] != '1' && map[x][y + 1] != '1'
				&& map[x + 1][y - 1] != '1' && map[x + 1][y] != '1' && map[x + 1][y + 1] != '1')
			return true;
		
		return false;
	}
	
	private static boolean done(int x, int y, int d) {
		if(d == 0) {
			if(map[x][y - 1] == 'E' && map[x][y] == 'E' && map[x][y + 1] == 'E') return true;
		}
		else {
			if(map[x - 1][y] == 'E' && map[x][y] == 'E' && map[x + 1][y] == 'E') return true;
		}
		
		return false;
	}
}