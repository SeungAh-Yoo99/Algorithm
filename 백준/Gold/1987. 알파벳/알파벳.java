import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R;
	static int C;
	static char[][] board;
	static boolean[] visited;
	static int result;
	
	private static void go(int x, int y, int count) {
		
		result = Math.max(result, count); // 현재 최대로 많이 왔다면 result 갱신
		visited[board[x][y] - 'A'] = true; // 현재 알파벳 방문했다고 체크
		
		// 상하좌우
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		for (int i = 0; i < 4; i++) { // 상하좌우를 검사해서 갈 수 있으면 가기
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 인덱스 범위 체크 & 지나간 적 없는 알파벳이라면
			if(nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[board[nx][ny] - 'A']) {
				go(nx, ny, count + 1);
			}
		}
		
		visited[board[x][y] - 'A'] = false; // 나갈 때 방문체크 풀어줌
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// R, C 입력
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		// 보드 입력
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}
		
		// 알파벳 방문체크
		visited = new boolean[26];
		
		// 좌측 상단에서 시작
		go(0, 0, 1);
		
		// 답 출력
		System.out.println(result);
	}

}