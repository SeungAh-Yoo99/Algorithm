import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	
	static int N;
	static int[][] map;
	static int result;
	
	private static void init() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	private static void play() {
		
		int x = N / 2, y = N / 2; // 시작 위치
		int n = 1; // 시작 이동 크기
		while(true) {
			// 왼쪽 방향으로 n만큼
			for (int i = 0; i < n - 1; i++) {
				move(0, x, y--);
			}
			// (0, 0)에 도착했다면 끝
			if(x == 0 && y == 0) break;
			// 아니라면 한 칸 더
			move(0, x, y--);
			
			// 아래 방향으로 n만큼
			for (int i = 0; i < n; i++) {
				move(1, x++, y);
			}
			
			n++;
			
			// 오른쪽 방향으로 n만큼
			for (int i = 0; i < n; i++) {
				move(2, x, y++);
			}
			
			// 위쪽 방향으로 n만큼
			for (int i = 0; i < n; i++) {
				move(3, x--, y);
			}
			
			n++;
		}
	}
	
	private static void move(int d, int x, int y) {
		
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		int rest = map[nx][ny]; // 알파 칸에 들어갈 남은 모래양
		
		// 1% 이동
		int nd = d + 1 > 3 ? 0 : d + 1;
		out(x + dx[nd], y + dy[nd], (int)(map[nx][ny] * 0.01));
		out(x - dx[nd], y - dy[nd], (int)(map[nx][ny] * 0.01));
		rest -= (int)(map[nx][ny] * 0.01) * 2;
		
		// 7% 이동
		out(nx + dx[nd], ny + dy[nd], (int)(map[nx][ny] * 0.07));
		out(nx - dx[nd], ny - dy[nd], (int)(map[nx][ny] * 0.07));
		rest -= (int)(map[nx][ny] * 0.07) * 2;
		
		// 2% 이동
		out(nx + dx[nd] * 2, ny + dy[nd] * 2, (int)(map[nx][ny] * 0.02));
		out(nx - dx[nd] * 2, ny - dy[nd] * 2, (int)(map[nx][ny] * 0.02));
		rest -= (int)(map[nx][ny] * 0.02) * 2;
		
		// 10% 이동
		out(nx + dx[d] + dx[nd], ny + dy[d] + dy[nd], (int)(map[nx][ny] * 0.1));
		out(nx + dx[d] - dx[nd], ny + dy[d] - dy[nd], (int)(map[nx][ny] * 0.1));
		rest -= (int)(map[nx][ny] * 0.1) * 2;
		
		// 5% 이동
		out(nx + dx[d] * 2, ny + dy[d] * 2, (int)(map[nx][ny] * 0.05));
		rest -=(int)(map[nx][ny] * 0.05);
		// 알파 이동
		
		out(nx + dx[d], ny + dy[d], rest);
		
		// 원래 자리 모래 없어짐
		map[nx][ny] = 0;
	}
	
	public static void out(int x, int y, int sand) {
		// 모래가 격자의 밖으로 나갔다면 결과값에 추가
		if(x < 0 || x >= N || y < 0 || y >= N) {
			result += sand;
			return;
		}
		
		// 아니라면 맵에 모래양 추가
		map[x][y] += sand;
	}

	public static void main(String[] args) throws Exception{

		// 입력
		init();
		
		// 시뮬레이션 시작
		play();
		
		// 출력
		System.out.println(result);
	}

}