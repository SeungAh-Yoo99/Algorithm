import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] arr;
	static int count = 1;
	
	public static void robot(int r, int c, int d) {
		arr[r][c] = 2;
		
		// 북, 동, 남, 서
		int[] bx = {-1, 0, 1, 0};
		int[] by = {0, 1, 0, -1};
		
		for (int i = 1; i <= 4; i++) {
			// 왼쪽을 바라보게 함
			int tmp = d - i;
			if(tmp < 0)
				tmp += 4;
			int nx = r + bx[tmp];
			int ny = c + by[tmp];
			
			// 범위체크 && 가려는 방향이 0인지 확인
			if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0) {
				count++;
				robot(nx, ny, tmp);
				return;
			}
		}
		
		// 네 방향에 모두 청소할 곳이 없을 때
		// 후진할 수 있다면 후진
		int nx = r - bx[d];
		int ny = c - by[d];
		if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 2)
			robot(nx, ny, d);
		// 벽이라면 그만
		else
			return;
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// n, m 입력
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// r, c, d 입력
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		// 장소 입력
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 청소
		robot(r, c, d);
		
		// 답 출력
		System.out.println(count);
	}

}