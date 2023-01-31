import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n, m;
	static int[][] arr;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// n, m 입력
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 치즈 위치 입력
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean isEmpty = false;
		int result = 0;
		arr[0][0] = 2;
		
		while(!isEmpty) {
			// 내부 공간 구하기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(arr[i][j] == 2)
						getInner(i, j);
				}
			}
			
			// 치즈가 모두 없어졌는지 체크
			isEmpty = isEmpty();
			
			// 치즈가 모두 없어졌다면 break
			if(isEmpty == true)
				break;
			
			// 치즈 없애기
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(arr[i][j] == 1) {
						delChs(i, j);
					}
				}
			}
			result++;
		}
		
		// 답 출력
		System.out.println(result);
	}
	
	// 치즈가 모두 없어졌는지 채크하는 메소드
	// 배열이 모두 2인지 확인함
	static boolean isEmpty() {
		boolean check = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j] != 2) {
					check = false;
					break;
				}
			}
			if (check == false)
				break;
		}
		if(check == true)
			return true;
		else
			return false;
	}
	
	// 내부 공간 구하는 메소드
	// 외부 공간이라면 0 -> 2로 바꿔준다
	// 내부 공간은 그대로 0으로 남는다.
	static void getInner(int x, int y) {

		arr[x][y] = 2;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 범위체크 && 해당 인덱스의 arr가 0이라면 재귀
			if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0) {
				getInner(nx, ny);
			}
		}
	}
	
	// 치즈를 없애주는 메소드
	// 배열에 담긴 수가 1인 곳의 상하좌우에 2가 두개 이상 있으면 0으로 바꿔준다.
	static void delChs(int x, int y) {
		
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 범위체크 && 2변 이상 접촉되었는지 체크
			if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 2) {
				cnt++;
			}
			
		}
		// 2변 이상 접촉되었다면 0으로 바꿔줌
		if(cnt >= 2)
			arr[x][y] = 0;
	}

}