import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int blueCount;
	static int whiteCount;
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j =0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 메소드 호출
		countColor(n, 0, 0);
		System.out.println(whiteCount);
		System.out.println(blueCount);
		
	}

	// 파라미터로 나눈 사분면의 변의 길이 num, 시작 좌표 x, y를 넣는다.
	static void countColor(int num, int x, int y) {
		// 가장 작은 크기까지 색종이를 잘랐을 경우
		if (num == 1) {
			// 파란색
			if (arr[x][y] == 1)
				blueCount++;
			// 흰색
			else
				whiteCount++;
			
			return;
		}
		
		// 현재 색종이의 색이 모두 같은지 확인
		int color = 0;
		for (int i = x; i < x + num; i++) {
			for (int j = y; j < y + num; j++) {
				// 제일 처음 색 기준으로 확인
				if(i == x && j == y)
					color = arr[i][j];
				
				// 다른 색이 나오면 재귀호출하여 색종이를 다시 나눔
				if (arr[i][j] != color) {
					countColor(num / 2, x, y);
					countColor(num / 2, x, y + num / 2);
					countColor(num / 2, x + num / 2, y);
					countColor(num / 2, x + num / 2, y + num / 2);
					return;
				}
				
			}
		}
		
		// 만약 다 같은 색이라면 count 업
		if (color == 1)
			blueCount++;
		else
			whiteCount++;
	}
}