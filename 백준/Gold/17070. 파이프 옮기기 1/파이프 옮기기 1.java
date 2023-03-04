import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map;
	static int result;
	
	private static void dfs(int x1, int y1, int x2, int y2) { // 항상 오른쪽에 있는 끝점을 x2, y2로 입력 받는다
		if(x2 == N && y2 == N) { // 이동 완료 했다면
			result++;
			return;
		}
		
		if(x1 == x2) { // 현재 파이프가 가로일 경우
			int nx = x2 + 1; // ↘ 방향으로 이동할 때 사용
			int ny = y2 + 1; // →, ↘ 방향으로 이동할 때 사용
			
			// → 방향으로 움직일 수 있다면
			if(ny <= N && map[x2][ny] == 0) dfs(x2, y2, x2, ny);
			// ↘ 방향으로 움직일 수 있다면
			if(nx <= N && ny <= N && map[x2][ny] == 0 && map[nx][y2] == 0 && map[nx][ny] == 0)
				dfs(x2, y2, nx, ny);
		}
		
		else if(y1 == y2) { // 현재 파이프가 세로일 경우
			int nx = x2 + 1; // ↓, ↘ 방향으로 이동할 때 사용
			int ny = y2 + 1; // ↘ 방향으로 이동할 때 사용
			
			// ↓ 방향으로 움직일 수 있다면
			if(nx <= N && map[nx][y2] == 0) dfs(x2, y2, nx, y2);
			// ↘ 방향으로 움직일 수 있다면
			if(nx <= N && ny <= N && map[x2][ny] == 0 && map[nx][y2] == 0 && map[nx][ny] == 0)
				dfs(x2, y2, nx, ny);
		}
		
		else { // 현재 파이프가 대각선일 경우
			int nx = x2 + 1; // ↓, ↘ 방향으로 이동할 때 사용
			int ny = y2 + 1; // →, ↘ 방향으로 이동할 때 사용
			
			// → 방향으로 움직일 수 있다면
			if(ny <= N && map[x2][ny] == 0) dfs(x2, y2, x2, ny);
			// ↓ 방향으로 움직일 수 있다면
			if(nx <= N && map[nx][y2] == 0) dfs(x2, y2, nx, y2);
			// ↘ 방향으로 움직일 수 있다면
			if(nx <= N && ny <= N && map[x2][ny] == 0 && map[nx][y2] == 0 && map[nx][ny] == 0)
				dfs(x2, y2, nx, ny);
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// dfs로 가능한 방법의 수 구하기
		dfs(1, 1, 1, 2);
		
		// 출력
		System.out.println(result);
	}

}