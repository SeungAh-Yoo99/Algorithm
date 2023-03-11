import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int N;
	static char[][] map;
	static int numOfGroup;
	
	private static int bfs(int x, int y) {
		
		numOfGroup++;
		
		// 상하좌우
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		map[x][y] = '0'; // 시작점 방문 체크
		int c = 1; // 집의 수
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			
			for (int i = 0; i < 4; i++) { // 사방 탐색
				int nx = p[0] + dx[i];
				int ny = p[1] + dy[i];
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 체크
					if(map[nx][ny] == '1') { // 아직 탐색하지 않은 집이면
						map[nx][ny] = '0'; // 방문 체크
						c++; // 집의 개수 세주고
						q.add(new int[] {nx, ny});
					}
				}
			}
		}
		
		return c;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 입력
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		ArrayList<Integer> count = new ArrayList<>(); // 단지에 속하는 집의 수를 담을 배열
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 집 발견하면 bfs
				if(map[i][j] == '1') count.add(bfs(i, j));
			}
		}
		
		// 답 담기
		sb.append(numOfGroup + "\n");
		Object[] result = count.toArray(); // 배열에 담아서
		Arrays.sort(result); // 정렬
		for (Object o : result) {
			sb.append(o + "\n");
		}
		
		// 출력
		System.out.println(sb);
	}

}