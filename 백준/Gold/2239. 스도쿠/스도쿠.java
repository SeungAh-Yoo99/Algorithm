import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static int[][] board = new int[9][9];
	// 빈 칸인 곳의 인덱스를 담은 리스트
	static ArrayList<int[]> empty = new ArrayList<>();
	
	private static void fill(int idx) { // 빈 칸을 채우는 메소드
		
		if(idx == empty.size()) { // 모든 빈 칸을 다 채웠다면 출력 후 종료
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(board[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
			System.exit(0);
		}
		
		// idx번째 빈 칸
		int x = empty.get(idx)[0];
		int y = empty.get(idx)[1];
		
		// 가능한 수 구하기
		boolean[] visited = new boolean[10];
		for (int i = 0; i < 9; i++) {
			visited[board[x][i]] = true; // 가로 체크
			visited[board[i][y]] = true; // 세로 체크
		}
		for (int i = 0; i < 3; i++) { // 그룹 체크
			for (int j = 0; j < 3; j++) {
				visited[board[3 * (x / 3) + i][3 * (y / 3) + j]] = true;
			}
		}
		
		// 가능한 수 넣어보기
		for (int i = 1; i <= 9; i++) {
			if(!visited[i]) {
				board[x][y] = i;
				fill(idx + 1); // 다음 빈 칸으로 재귀
				board[x][y] = 0;
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 9; i++) {
			char[] tmp = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				board[i][j] = tmp[j] - '0';
				if(board[i][j] == 0) empty.add(new int[] {i, j});
			}
		}
		
		fill(0);
	}

}