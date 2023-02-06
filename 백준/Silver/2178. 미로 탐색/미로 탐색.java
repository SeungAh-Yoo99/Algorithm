import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static char[][] arr;
	static int[][] visited;
	
	public static void findNM(int x, int y, int count) {
		visited[x][y] = count + 1;
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			// 범위 체크 && 상하좌우 칸이 길인지 확인 && 상하좌우의 최소 거리가 현재 칸의 최소거리보다 작으면 방문하지 않음
			if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == '1' && visited[x][y] + 1 < visited[nx][ny])
				findNM(nx, ny, visited[x][y]);
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// n, m 입력
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// n x m 크기의 배열 생성
		arr = new char[n][m];
		// 해당 칸에 가기 위해 걸리는 최소 거리를 담는 배열 생성 & 최대값으로 초기화
		visited = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = (int)10e9;
			}
		}
		
		// 미로 입력
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		// (1, 1)에서 (N, M) 위치로 이동할 때 최소 거리 구하기
		findNM(0, 0, 0);
		
		// 출력
		System.out.println(visited[n - 1][m - 1]);
	}

}