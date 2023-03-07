import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int L;
	static int R;
	static int[][] map;
	static int[][] tmpMap;
	static boolean[][] visited;
	static Queue<int[]> q;
	static int sum; // 연합의 인구수
	static int count; // 연합을 이루고 있는 칸의 개수
	
	private static boolean bfs(int x, int y) {
		
		boolean isTrue = true; // 한 번이라도 인구 이동이 있었다면 false 리턴
		
		// 상하좌우
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		visited[x][y] = true;
		q.add(new int[] {x, y});
		sum = map[x][y];
		count = 1;
		
		Queue<int[]> tmp = new LinkedList<>();
		tmp.add(new int[] {x, y});
		
		while(!tmp.isEmpty()) {
			int[] point = tmp.poll();
			
			for (int i = 0; i < 4; i++) { // 사방 탐색
				int nx = point[0] + dx[i];
				int ny = point[1] + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 체크
					if(!visited[nx][ny]) { // 국경선을 열지 않은 곳일 때만 방문
						int sub = Math.abs(map[point[0]][point[1]] - map[nx][ny]); // 두 나라의 인구 차이
						if(sub >= L && sub <= R) { // 인구 차이가 L명 이상 R명 이하라면
							isTrue =  false; // 인구 이동이 있었으므로 false로 바꿔주고
							visited[nx][ny] = true;
							sum += map[nx][ny];
							count++;
							q.add(new int[] {nx, ny});
							tmp.add(new int[] {nx, ny});
						}
					}
				}
			}
		}
		
		return isTrue;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean isTrue = false;
		
		int result = -1;
		
		while(!isTrue) { // 모든 인구 이동이 없을 때까지
			tmpMap = new int[N][N];
			visited = new boolean[N][N];
			
			isTrue = true; // 인구 이동이 있었다면 false
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						q = new LinkedList<>();
						if(!bfs(i, j)) { // 인구 이동이 있었다면
							isTrue = false;
							while(!q.isEmpty()) {
								int[] idx = q.poll();
								tmpMap[idx[0]][idx[1]] = sum / count;
							}
						}
						else tmpMap[i][j] = map[i][j];
					}
				}
			}
			
			map = tmpMap;
			result++;
		}
		
		// 출력
		System.out.println(result);
	}

}