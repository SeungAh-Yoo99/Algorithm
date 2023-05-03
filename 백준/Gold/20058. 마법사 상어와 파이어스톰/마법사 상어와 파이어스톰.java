import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int Q;
	static int mapSize;
	static int[][] map;
	static int[] L;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int resultSum;
	static int resultCount;
	
	private static void init() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		mapSize = (int)Math.pow(2, N);
		
		map = new int[mapSize][mapSize];
		for (int i = 0; i < mapSize; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < mapSize; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		L = new int[Q];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			L[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	private static void play() {
		
		for (int i = 0; i < Q; i++) {
			// 맵 부분 격자로 나눈 구역 별로 90도 회전
			turn(L[i]);
			// 얼음 녹이기
			melt();
		}
		
		// 답 구하기
		getResult();
	}
	
	private static void turn(int l) {
		int[][] subMap; // 90도 회전한 맵 저장
		int subMapSize = (int)Math.pow(2, l);
		for (int i = 0; i < mapSize; i += subMapSize) {  // 부분 격자로 나눈 구역 별로
			for (int j = 0; j < mapSize; j += subMapSize) {
				subMap = new int[subMapSize][subMapSize];
				for (int k = 0; k < subMapSize ; k++) { // 90도 회전
					for (int m = 0; m < subMapSize; m++) {
						subMap[k][m] = map[(subMapSize - 1) + i - m][j + k];
					}
				}
				for (int k = 0; k < subMapSize; k++) { // 회전한 정보 맵에 저장
					for (int m = 0; m < subMapSize; m++) {
						map[i + k][j + m] = subMap[k][m];
					}
				}
			}
		}
	}
	
	private static void melt() {
		int[][] tmpMap = new int[mapSize][mapSize];
		int count, nx, ny;
		
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				count = 0; // 인접한 얼음 칸의 개수
				for (int k = 0; k < 4; k++) {
					nx = i + dx[k];
					ny = j + dy[k];
					if(nx >= 0 && nx < mapSize && ny >= 0 && ny < mapSize) {
						if(map[nx][ny] != 0) count++;
					}
				}
				if(count >= 3) tmpMap[i][j] = map[i][j];
				else tmpMap[i][j] = map[i][j] > 0 ? map[i][j] - 1 : 0;
			}
		}
		
		map = tmpMap;
	}
	
	private static void getResult() {
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				if(map[i][j] != 0) resultCount = Math.max(resultCount, bfs(i, j));
			}
		}
	}
	
	private static int bfs(int x, int y) {
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		resultSum += map[x][y];
		map[x][y] = 0;
		int ret = 1;
		
		int nx, ny;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				nx = now[0] + dx[i];
				ny = now[1] + dy[i];
				if(nx >= 0 && nx < mapSize && ny >= 0 && ny < mapSize) {
					if(map[nx][ny] != 0) {
						resultSum += map[nx][ny];
						map[nx][ny] = 0;
						ret++;
						q.add(new int[] {nx, ny});
					}
				}
			}
		}
		
		return ret;
	}

	public static void main(String[] args) throws Exception{

		// 입력
		init();
		
		// 시뮬레이션 시작
		play();
		
		// 답 출력
		System.out.println(resultSum + "\n" + resultCount);
	}

}