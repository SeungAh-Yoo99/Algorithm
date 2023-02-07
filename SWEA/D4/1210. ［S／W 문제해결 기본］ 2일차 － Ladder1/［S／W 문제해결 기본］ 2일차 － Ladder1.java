import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] arr;
	
	public static int ladder(int x, int y) {
		// x가 0이라면
		if(x == 0)
			return y;
		
		// 오른쪽에 길이 있는지 체크
		if(y + 1 < 100 && arr[x][y + 1] == 1) {
			while(true) {
				if(y + 1 < 100 && arr[x][y + 1] == 1) {
					y++;
					continue;
				}
				break;
			}
		}
		else if(y - 1 >= 0 && arr[x][y - 1] == 1) {
			// 왼쪽에 길이 있는지 체크
			while(true) {
				if(y - 1 >= 0 && arr[x][y - 1] == 1) {
					y--;
					continue;
				}
				break;
			}
		}
		
		return ladder(x - 1, y);
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 테스트케이스 10번 반복
		for (int t = 0; t < 10; t++) {
			int test_case = Integer.parseInt(br.readLine());
			sb.append("#" + test_case + " ");
			
			// 사다리 정보를 넣을 배열 선언 & 입력
			arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 2 지점의  좌표에서 시작하여, 사다리를 타고 올라가다가 x좌표가 0일 때의 y좌표를 구한다.
			int result = 0;
			for (int i = 0; i < 100; i++) {
				if(arr[99][i] == 2) {
					result = ladder(99, i);
					break;
				}
			}
			sb.append(result + "\n");
		}
		
		// 출력
		System.out.println(sb);
	}

}