import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int[][] arr;
	static int[][] cases;
	
	private static int move(int x, int y) {
		if(cases[x][y] != 0) // 이미 구한 적이 있으면 바로 리턴
			return cases[x][y];
		
		// 상, 하, 좌, 우
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			// 인덱스 체크 && 주변에 1 큰 수가 있는지 체크
			if(nx >= 0 && nx < N && ny >= 0 && ny < N && arr[x][y] + 1 == arr[nx][ny]) {
				cases[x][y] += move(nx, ny) + 1; // 주변에 1 큰 방이 있으므로 +
				return cases[x][y];
			}
		}
		
		cases[x][y] = 1; // 주변에 1 큰 방이 없다면, 더 이상 못나아가므로 1
		return cases[x][y];
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// T 입력
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			// N 입력
			N = Integer.parseInt(br.readLine());
			// 배열 입력
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 경우의 수를 담을 배열
			cases = new int[N][N];
			
			// 답 구하기
			int result = 0;
			int tmpX = 0;
			int tmpY = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < arr.length; j++) {
					int tmp = move(i, j); // 방 이동
					if(result < tmp) { // 가장 큰 이동 가능한 방 개수 저장
						result = tmp;
						tmpX = i; // 가장 많이 이동할 수 있는 방의 인덱스 저장
						tmpY = j;
					}
					// 최대인 방이 여럿이면 그 중 적힌 수가 가장 작은 것이 답
					if(result == tmp && arr[tmpX][tmpY] > arr[i][j]) {
						tmpX = i;
						tmpY = j;
					}
				}
			}
			
			// 답 저장
			sb.append(arr[tmpX][tmpY] + " " + result + "\n");
		}
		
		// 출력
		System.out.println(sb);
	}

}