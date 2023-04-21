import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	// 상어 클래스
	static class Shark {
		
		int num;
		int curX;
		int curY;
		int dis;
		int[][] priority;
		
		// 생성자
		public Shark(int num, int curX, int curY) {
			this.num = num;
			this.curX = curX;
			this.curY = curY;
			this.dis = 0;
			this.priority = new int[5][4];
		}
		
		// 방향 우선순위 세팅
		public void setPriority(int dis, int d1, int d2, int d3, int d4) {
			this.priority[dis][0] = d1;
			this.priority[dis][1] = d2;
			this.priority[dis][2] = d3;
			this.priority[dis][3] = d4;
		}
	}
	
	static int N;
	static int M;
	static int k;
	
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, -1, 1};
	
	static int[][][] map;
	static Shark[] sharkInfo;
	static int count; // 남은 상어 수
	
	// 입력
	private static void init() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		count = M;
		
		map = new int[N][N][2];
		sharkInfo = new Shark[M + 1];
		
		// 격자 모습 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j][0] = Integer.parseInt(st.nextToken());
				if(map[i][j][0] != 0) {
					sharkInfo[map[i][j][0]] = new Shark(map[i][j][0], i, j);
					map[i][j][1] = k;
				}
			}
		}
		
		// 상어 방향 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			sharkInfo[i].dis = Integer.parseInt(st.nextToken());
		}
		
		// 각 상어의 방향 우선순위 입력
		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= 4; j++) {
				st = new StringTokenizer(br.readLine());
				int d1 = Integer.parseInt(st.nextToken());
				int d2 = Integer.parseInt(st.nextToken());
				int d3 = Integer.parseInt(st.nextToken());
				int d4 = Integer.parseInt(st.nextToken());
				sharkInfo[i].setPriority(j, d1, d2, d3, d4);
			}
		}
	}
	
	// 시작
	private static int play() {
		
		int time = 0;
		
		// 1000초가 넘어도 다른 상어가 남아있으면 -1 출력
		while(count > 1 && time++ < 1000) {
			
			// 상어 이동
			sharksMove();
			
			// 상어 냄새 감소
			lightSmell();
			
			// 이동 후 상어 냄새 map에 저장
			for (int i = 1; i <= M; i++) {
				// 이미 쫓겨난 상어면 넘어감
				if(sharkInfo[i] == null) continue;
				
				Shark s = sharkInfo[i];
				map[s.curX][s.curY][0] = s.num;
				map[s.curX][s.curY][1] = k;
			}

		}
		
		if(time > 1000) time = -1;
		
		return time;
	}
	
	// 상어 이동
	private static void sharksMove() {
		
		// 상어가 이동할 위치 임시 저장
		int[][] tmpMap = new int[N][N];
		
		// 번호가 작은 상어부터 이동
		for (int i = 1; i <= M; i++) {
			// 이미 쫓겨난 상어면 넘어감
			if(sharkInfo[i] == null) continue;
			
			Shark s = sharkInfo[i];
			
			// 상어 이동 위치 구하기
			boolean flag = false; // 이동했다면 true
			for (int j = 0; j < 4; j++) {
				int nx = s.curX + dx[s.priority[s.dis][j]];
				int ny = s.curY + dy[s.priority[s.dis][j]];
				
				// 범위 체크
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
					// 냄새가 없다면
					if(map[nx][ny][0] == 0) {
						
						// 해당 자리에 이미 상어가 있다면 해당 상어 쫓겨남
						if(tmpMap[nx][ny] != 0) {
							sharkInfo[i] = null;
							count--;
							break;
						}
						
						// 해당 자리로 옮길 수 있는 경우
						flag = true;
						// 옮긴 자리 tmpMap에 표시
						tmpMap[nx][ny] = i;
						// 옮긴 위치 정보 저장
						s.curX = nx;
						s.curY = ny;
						s.dis = s.priority[s.dis][j];
						
						break;
					}
				}
			}
			// 아무 냄새가 없는 칸이 없다면 자신의 냄새가 있는 칸으로 이동
			if(!flag) {
				for (int j = 0; j < 4; j++) {
					int nx = s.curX + dx[s.priority[s.dis][j]];
					int ny = s.curY + dy[s.priority[s.dis][j]];
					
					// 범위 체크
					if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
						// 냄새가 없다면
						if(map[nx][ny][0] == s.num) {
							// 옮긴 자리 tmpMap에 표시
							tmpMap[nx][ny] = i;
							// 옮긴 위치 정보 저장
							s.curX = nx;
							s.curY = ny;
							s.dis = s.priority[s.dis][j];
							
							break;
						}
					}
				}
			}
		}
	}
	
	// 냄새 감소
	private static void lightSmell() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j][0] != 0) {
					if(--map[i][j][1] == 0) {
						map[i][j][0] = 0;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{

		// 입력
		init();
		
		// 실행
		int result = play();
		
		// 출력
		System.out.println(result);
	}

}