import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int X;
	static int[][] map;
	
	private static boolean getRamp(boolean row, int n) {
		
		boolean[] flag = new boolean[N];
		
		// 가로 확인
		if(row) {
			// 왼쪽에서 오른쪽으로
			for (int i = 1; i < N;) {
				if(map[n][i - 1] > map[n][i]) { // 낮아진 구간 발견
					// 단차가 1일 때만 경사로 설치 가능
					if(map[n][i - 1] - map[n][i] > 1) return false;
					int h = map[n][i];
					int c = 0;
					while(i < N && map[n][i] == h && !flag[i] && c < X) {
						flag[i] = true;
						c++;
						i++;
					}
					// 낮아진 구간의 길이가 X 미만으로 경사로를 짓지 못하면
					if(c != X) {
						return false;
					}
					
				}
				else i++;
			}
			// 오른쪽에서 왼쪽으로
			for (int i = N - 2; i >= 0;) {
				if(map[n][i + 1] > map[n][i]) { // 낮아진 구간 발견
					// 단차가 1일 때만 경사로 설치 가능
					if(map[n][i + 1] - map[n][i] > 1) return false;
					
					int h = map[n][i];
					int c = 0;
					while(i >= 0 && map[n][i] == h && !flag[i] && c < X) {
						flag[i] = true;
						c++;
						i--;
					}
					// 낮아진 구간의 길이가 X 미만으로 경사로를 짓지 못하면
					if(c != X) {
						return false;
					}
				}
				else i--;
			}
			
			// 경사로를 모두 무사히 지었다면
			return true;
		}
		
		// 세로 확인
		else {
			// 위에서 아래로
			for (int i = 1; i < N;) {
				if(map[i - 1][n] > map[i][n]) { // 낮아진 구간 발견
					
					// 단차가 1일 때만 경사로 설치 가능
					if(map[i - 1][n] - map[i][n] > 1) return false;
					int h = map[i][n];
					int c = 0;
					while(i < N && map[i][n] == h && !flag[i] && c < X) {
						flag[i] = true;
						c++;
						i++;
					}
					// 낮아진 구간의 길이가 X 미만으로 경사로를 짓지 못하면
					if(c != X) {
						return false;
					}
				}
				else i++;
			}
			// 아래에서 위로
			for (int i = N - 2; i >= 0;) {
				if(map[i + 1][n] > map[i][n]) { // 낮아진 구간 발견
					// 단차가 1일 때만 경사로 설치 가능
					if(map[i + 1][n] - map[i][n] > 1) return false;
					
					int h = map[i][n];
					int c = 0;
					while(i >= 0 && map[i][n] == h && !flag[i] && c < X) {
						flag[i] = true;
						c++;
						i--;
					}
					// 낮아진 구간의 길이가 X 미만으로 경사로를 짓지 못하면
					if(c != X) {
						return false;
					}
				}
				else i--;
			}
			
			// 경사로를 모두 무사히 지었다면
			return true;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0;
			for (int i = 0; i < N; i++) {
				// 가로 확인
				if(getRamp(true, i)) result++;
				// 세로 확인
				if(getRamp(false, i)) result++;
			}
			
			sb.append("#" + test_case + " " + result + "\n");
		}
		
		System.out.println(sb);
	}

}