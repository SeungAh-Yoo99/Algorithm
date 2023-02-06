import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static char[][] arr;
	static int m;
	static int n;
	
	public static int getStrength(int x, int y, char team, int count) {
		visited[x][y] = true;
		
		int[] bx = {1, -1, 0, 0};
		int[] by = {0, 0, -1, 1};
		
		for (int i = 0; i < 4; i++) {
			int nx = x + bx[i];
			int ny = y + by[i];
			// 범위 체크 && 해당 좌표의 상하좌우에 방문하기 전인 같은 팀의 병사가 있다면,
			if(nx >= 0 && nx < m && ny >= 0 && ny < n && visited[nx][ny] == false && arr[nx][ny] == team) {
				count = getStrength(nx, ny, team, count);
			}
		}
		
		return count + 1;
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// n, m 입력
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// m x n 크기의 배열 생성
		arr = new char[m][n];
		
		// 병사들의 옷색 입력
		for (int i = 0; i < m; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		// 방문 체크 배열 생성
		visited = new boolean[m][n];
		
		// 구역의 위력 구하기
		int white = 0;
		int blue = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				// 아직 방문한 적 없다면 방문 처리하며 위력을 구한다.
				if(!visited[i][j]) {
					int cnt = getStrength(i, j, arr[i][j], 0);
					
					if(arr[i][j] =='W') // 흰색 팀일 경우
						white += Math.pow(cnt, 2);
					else // 파란색 팀일 경우
						blue += Math.pow(cnt, 2);
				}
			}
		}
		System.out.println(white + " " + blue);
	}

}