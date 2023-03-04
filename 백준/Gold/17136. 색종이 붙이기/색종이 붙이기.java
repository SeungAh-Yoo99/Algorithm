import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr; // 10 x 10 종이
	static int[] numOfPaper = new int[] {0, 5, 5, 5, 5, 5}; // 각 색종이는 5개씩
	static int result = Integer.MAX_VALUE; // 답
	static int count;
	
	private static void pasting(int x, int y) { // 색종이 붙이는 메소드
		
		if(x >= 10 || y >= 10) { // 색종이를 가능한 다 붙였다면
			for (int i = 0; i < 10; i++) { // 못 붙인 곳이 있는지 검사
				for (int j = 0; j < arr.length; j++) {
					if(arr[i][j] == 1) return; // 못 붙인 곳 있다면 리턴
				}
			}
			result = Math.min(result, count); // 최소값 저장
			return;
		}
		
		if(arr[x][y] == 0) { // 현재 위치가 0이라면
			while(x < 10 && y < 10 && arr[x][y] == 0) { // 1인 곳을 찾아서
				if(y < 9) y++;
				else {
					x++;
					y = 0;
				}
			}
			pasting(x, y); // 재귀
			return;
		}
		
		for (int i = 5; i > 0; i--) { // 붙일 수 있는 모든 사이즈의 색종이를 붙여본다
			if(numOfPaper[i] > 0 && coloredPaper(i, x, y)) { // 현재 사이즈의 색종이를 붙일 수 있다면
				numOfPaper[i]--; // 색종이 개수 줄여주고
				count++; // 붙인 색종이 개수 늘려주고
				if(y == 9) pasting(x + 1, 0); // 재귀
				else pasting(x, y + 1);
				numOfPaper[i]++; // 다음 색종이를 확인하기 위해 다시 색종이 개수 늘려주고
				count--; // 붙인 색종이 개수 줄여주고
				return1(i, x, y); // 색종이 다시 붙여줌
			}
		}
	}
	
	private static boolean coloredPaper(int size, int x, int y) { // size 크기의 색종이 붙이는 메소드
		// 범위를 벗어나면 false 리턴
		if(x + size - 1 >= 10 || y + size - 1 >= 10) return false;
		
		boolean check = true; // size 크기의 색종이를 붙일 수 있는지 체크
for1:	for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if(arr[i][j] == 0) { // size 크기 안에 0이 있다면
					check = false;
					break for1;
				}
			}
		}

		if(!check) return false; // 붙일 수 없으면 false 리턴
		else { // 붙일 수 있다면
			for (int i = x; i < x + size; i++) { // 붙이고
				for (int j = y; j < y + size; j++) {
					arr[i][j] = 0;
				}
			}
			return true; // true 리턴
		}
	}
	
	static void return1(int size, int x, int y) { // size 크기의 색종이 붙인 것을 다시 되돌리는 메소드
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				arr[i][j] = 1;
			}
		}

	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		arr = new int[10][10];
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 색종이 붙이기
		pasting(0, 0);
		
		// 출력
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	}

}