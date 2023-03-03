import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R;
	static int C;
	static int T;
	static int[][] map;
	static int airCleaner; // 공기 청정기 밑 행값
	static int result;
	
	private static void spread() { // 미세먼지 확산 메소드
		int[][] tmpMap = new int[R][C]; // 퍼진 미세먼지 양을 담을 임시 배열
		
		// 상하좌우
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		for (int i = 0; i < R; i++) { // 미세먼지 퍼트리기
			for (int j = 0; j < C; j++) {
				if(map[i][j] > 4) { // 미세먼지가 있다면(5보다 작은 미세먼지는 확산이 일어나지 않음
					int n = map[i][j] / 5; // 퍼지는 양
					for (int k = 0; k < 4; k++) { // 4방을 검사
						int nx = i + dx[k];
						int ny = j + dy[k];
						if(nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] > -1) { // 범위 체크 & 공기청정기가 아니라면
							tmpMap[nx][ny] += n; // 퍼진 양을 임시 배열에 담고
							map[i][j] -= n; // 퍼진만큼 양을 줄여줌
						}
					}
				}
			}
		}
		
		for (int i = 0; i < R; i++) { // 퍼진 양 더해주기
			for (int j = 0; j < C; j++) {
				if(map[i][j] > -1) { // 공기청정기의 -1 값을 서로 더해주지 않기 위해
					map[i][j] += tmpMap[i][j];
				}
			}
		}
	}
	
	private static void airCleanerOperation() { // 공기 청정기 작동
		// 공기 청정기 위쪽
		int top = airCleaner - 1;
		for (int i = top - 1; i > 0; i--) { // 왼쪽
			map[i][0] = map[i - 1][0];
		}
		for (int i = 0; i < C - 1; i++) { // 위쪽
			map[0][i] = map[0][i + 1];
		}
		for (int i = 0; i < top; i++) { // 오른쪽
			map[i][C - 1] = map[i + 1][C - 1];
		}
		for (int i = C - 1; i > 1; i--) { // 아래쪽
			map[top][i] = map[top][i - 1];
		}
		map[top][1] = 0; // 공기청정기에서 나온 바람 곳은 미세먼지가 없음
		
		// 공기청정기 아래쪽
		int bottom = airCleaner;
		for (int i = bottom + 1; i < R - 1; i++) { // 왼쪽
			map[i][0] = map[i + 1][0];
		}
		for (int i = 0; i < C - 1; i++) { // 아래쪽
			map[R - 1][i] = map[R - 1][i + 1];
		}
		for (int i = R - 1; i > bottom; i--) { // 오른쪽
			map[i][C - 1] = map[i - 1][C - 1];
		}
		for (int i = C - 1; i > 1; i--) { // 위쪽
			map[bottom][i] = map[bottom][i - 1];
		}
		map[bottom][1] = 0; // 공기청정기에서 나온 바람 곳은 미세먼지가 없음
	}
	
	private static void getCount() { // 미세먼지 양 구하는 메소드
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] > 0) result += map[i][j];
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) airCleaner = i;
			}
		}
		
		for (int i = 0; i < T; i++) {
			spread(); // 미세먼지 확산
			airCleanerOperation(); // 공기청정기 작동
		}
		getCount(); // 남아있는 미세먼지 양 구하기
		
		// 출력
		System.out.println(result);
	}

}