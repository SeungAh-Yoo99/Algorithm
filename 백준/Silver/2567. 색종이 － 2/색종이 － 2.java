import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 100 x 100 크기의 흰색 천 배열(네 모서리에 1 씩 패딩)
		boolean[][] arr = new boolean[102][102];
		
		// 검은 스카프의 영역 입력
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 10; j++) { // 입력 받은 스카프의 영역을 true로 바꿔줌
				for (int k = 0; k < 10; k++) {
					arr[x + j][y + k] = true;
				}
			}
		}
		
		int result = 0; // 스카프의 둘레를 담을 변수
		
		// 현재 보고 있는 위치의 상하좌우를 확인하기 위한 배열
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		
		// 현재 확인하고 있는 부분이 검은색(true)일 때, 주변에 흰색(false)부분이 있다면 테두리다.
		for (int x = 1; x <= 100; x++) { // 배열을 모두 확인하며
			for (int y = 1; y <= 100; y++) {
				if(arr[x][y]) { // 검은색 부분일 때
					int w = 0; // 상하좌우에 인접한 흰색 부분 개수
					for (int i = 0; i < 4; i++) { // 현재 위치의 상하좌우를 확인
						int nx = x + dx[i];
						int ny = y + dy[i];
						
						// 상하좌우로 arr 배열에 패딩을 주었기 때문에 인덱스 범위를 따로 체크해주지 않아도 되며
						// 흰 색 천 모서리에 위치한 검은색 스카프의 테두리를 구할 수 있다.
						if(!arr[nx][ny]) w++; // 상하좌우에 인접한 흰색의 개수를 세준다.
					}
					if(w >= 1) { 
						result += w; // 인접한 흰색 면이 하나라면 +1, 두개라면 +2
					}
				}
			}
		}
		
		// 모든 경우를 다 구했다면 출력
		System.out.println(result);
	}

}