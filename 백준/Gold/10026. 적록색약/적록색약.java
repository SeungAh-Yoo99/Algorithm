import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static char[][] painting;
	static boolean[][] visited;
	
	private static void zoneRgm(int x, int y, char color) { // 적록색양 구역 구하기
		visited[x][y] = true;
		
		// 상하좌우
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		for (int i = 0; i < 4; i++) { // 상하좌우에 인접해 있는 곳에 같은 색이 있으면 같은 구역으로 본다
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(color == 'R' || color == 'G') { // 적록색약은 RG를 같은 색으로 본다
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && (painting[nx][ny] == 'R' || painting[nx][ny] == 'G')) {
					zoneRgm(nx, ny, painting[nx][ny]);
				}
			}
			else {
				if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && painting[nx][ny] == color) {
					zoneRgm(nx, ny, color);
				}
			}
		}
	}
	
	private static void zoneNotRgm(int x, int y, char color) {  // 적록색약이 아닌 사람의 구역 구하기
		visited[x][y] = true;
		
		// 상하좌우
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		for (int i = 0; i < 4; i++) { // 상하좌우에 인접해 있는 곳에 같은 색이 있으면 같은 구역으로 본다
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && painting[nx][ny] == color) {
				zoneNotRgm(nx, ny, color);
			}
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N 입력
		N = Integer.parseInt(br.readLine());
		
		// 그림 입력
		painting = new char[N][N];
		for (int i = 0; i < N; i++) {
			painting[i] = br.readLine().toCharArray();
		}
		
		int rgm = 0; // 적록색약이 봤을 때의 구역 수
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) { // 이미 검사해준 구역이 아니라면 검사해줌
					rgm++;
					zoneRgm(i, j, painting[i][j]);
				}
			}
		}
		
		int notRgm = 0; // 적록색약이 봤을 때의 구역 수
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) { // 이미 검사해준 구역이 아니라면 검사해줌
					notRgm++;
					zoneNotRgm(i, j, painting[i][j]);
				}
			}
		}
		
		System.out.println(notRgm + " " + rgm);
	}

}