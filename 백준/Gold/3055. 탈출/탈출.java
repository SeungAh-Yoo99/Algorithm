import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int R;
	static int C;
	static char[][] map;
	static Queue<int[]> water;
	static Queue<int[]> sonic;
	static int[][] floodTime;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	// 위치 별 물이 차는 시간 구하기
	private static void flood() {
		
		while(!water.isEmpty()) {
			int[] now = water.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
					if(map[nx][ny] == '.' && floodTime[nx][ny] == 0) {
						floodTime[nx][ny] = now[2] + 1;
						water.add(new int[] {nx, ny, now[2] + 1});
					}
				}
			}
		}
	}
	
	// 고슴도치 위치 별 최소 도착 시간 구하기
	private static int move() {
		
		while(!sonic.isEmpty()) {
			int[] now = sonic.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
					if(!visited[nx][ny]) {
						if(map[nx][ny] == 'D') return now[2] + 1;
						else if(map[nx][ny] == '.' && (floodTime[nx][ny] == 0 || floodTime[nx][ny] > now[2] + 1)) {
							visited[nx][ny] = true;
							sonic.add(new int[] {nx, ny, now[2] + 1});
						}
					}
					if(!visited[nx][ny] && floodTime[nx][ny] > now[2] + 1) {
						visited[nx][ny] = true;
						sonic.add(new int[] {nx, ny, now[2] + 1});
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
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		water = new LinkedList<>(); // 홍수의 시작 위치
		sonic = new LinkedList<>(); // 고슴도치 시작 위치
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'S') {
					sonic.add(new int[] {i, j, 0});
					visited[i][j] = true;
					map[i][j] = '.';
				}
				else if(map[i][j] == '*') {
					water.add(new int[] {i, j, 0});
				}
			}
		}
		
		floodTime = new int[R][C];
		flood();
		
		int result = move();
		if(result == -1) System.out.println("KAKTUS");
		else System.out.println(result);
	}

}