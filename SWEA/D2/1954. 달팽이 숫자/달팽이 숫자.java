import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	static int[][] arr;
	static int N;
	
	private static void snail(int x, int y, int d, int count) {
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		arr[x][y] = count;
		if(count == N * N) return;
		
		int nx = x + dx[d];
		int ny = y + dy[d];
		
		if(nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] == 0) {
			snail(nx, ny, d, count + 1);
		}
		else {
			d++;
			if(d > 3) d %= 4;
			snail(x, y, d, count);
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스 입력
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case < T + 1; test_case++) {
			sb.append("#" + test_case + "\n");
			// N 입력
			N = Integer.parseInt(br.readLine());
			// N * N 배열
			arr = new int[N][N];
			
			// 배열 채우기
			snail(0, 0, 0, 1);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j]);
					if(j != N - 1) sb.append(" ");
					else sb.append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}

}