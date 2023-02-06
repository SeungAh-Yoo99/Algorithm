import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int m;
	static int[][] arr;
	static int[][] result;


	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// n, m 입력
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// n x m 배열 생성 후 입력
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 방문 체크 할 visited 배열 생성
		result = new int[n][m];
		
		// 방문한 칸을 넣을 큐
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0});
		
		// 방문한 칸을 하나씩 큐에서 빼서 해당 칸에서 갈 수 있는 칸들을 모두 큐에 넣어 검사
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			// 오른쪽으로
			for (int i = 1; i <= arr[x][y]; i++) {
				int ny = y + i;
				// 범위 체크 && visited가 0이거나, 현재 + 1보다 더 클 때만
				if(ny < m && (result[x][ny] == 0 || result[x][ny] > result[x][y] + 1)) {
					result[x][ny] = result[x][y] + 1;
					q.add(new int[] {x, ny});
				}
			}
			
			// 아래쪽으로
			for (int i = 1; i <= arr[x][y]; i++) {
				int nx = x + i;
				// 범위 체크 && visited가 0이거나, 현재 + 1보다 더 클 때만
				if(nx < n && (result[nx][y] == 0 || result[nx][y] > result[x][y] + 1)) {
					result[nx][y] = result[x][y] + 1;
					q.add(new int[] {nx, y});
				}
			}
		}
		
		
		// 출력
		System.out.println(result[n - 1][m - 1]);
	}

}