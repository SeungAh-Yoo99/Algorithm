import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 테스트 케이스 입력
		int t = Integer.parseInt(br.readLine());
		// 테스트 케이스만큼 반복
		for (int testCase = 0; testCase < t; testCase++) {
			// m, n, k 입력
			int []mnk = new int[3];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 3; i ++)
				mnk[i] = Integer.parseInt(st.nextToken());
			
			// 배추 위치 입력
			int [][]arr = new int[mnk[0]][mnk[1]];
			for ( int i = 0; i < mnk[2]; i ++) {
				st = new StringTokenizer(br.readLine());
				arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			// 배추가 심어져 있는 구역의 수 구하기
			int count = 0;
			for (int i = 0; i < mnk[0]; i ++) {
				for (int j = 0; j < mnk[1]; j++) {
					if (arr[i][j] == 1) {
						arr = turnOneToZero(arr, i, j);
						count += 1;
					}
				}
			}
			
			System.out.println(count);
		}
		
	}
	
	static int[][] turnOneToZero(int [][]arr, int x, int y) {
		int []nx = {-1, 1, 0, 0};
		int []ny = {0, 0, -1, 1};
		// 현재 위치 0으로 바꿔줌
		arr[x][y] = 0;
		
		for (int i = 0; i < 4; i++) {
			// 인덱스 범위 체크
			if (x + nx[i] >= 0 && x + nx[i] < arr.length && y + ny[i] >= 0 && y + ny[i] < arr[i].length)
				// 상하좌우에 1인 곳이 있다면
				if (arr[x + nx[i]][y + ny[i]] == 1)
					// 재귀호출
					arr = turnOneToZero(arr, x + nx[i], y + ny[i]);
		}
		
		return arr;
	}

}