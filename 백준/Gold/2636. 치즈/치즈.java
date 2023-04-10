import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static final int[] dx = {-1, 1, 0, 0};
	static final int[] dy = {0, 0, -1, 1};
	
	static int r;
	static int c;
	static int[][] board;
	
	private static void air() { // 빈 칸 0에 공기 2가 맞닿아 있으면 2로 바뀌게 하는 메소드
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(board[i][j] == 2) bfs(i, j);
			}
		}
	}
	
	private static void bfs(int x, int y) {
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				if(nx >= 0 && nx < r && ny >= 0 && ny < c) {
					if(board[nx][ny] == 0) {
						board[nx][ny] = 2;
						q.add(new int[] {nx, ny});
					}
				}
			}
		}
	}
	
	private static int cheese() {
		
		int count = 0;
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(board[i][j] == 2) { // 공기일 때
					for (int d = 0; d < 4; d++) { // 사방에 치즈가 있다면
						int nx = i + dx[d];
						int ny = j + dy[d];
						
						if(nx >= 0 && nx < r && ny >= 0 && ny < c) {
							if(board[nx][ny] == 1) {
								board[nx][ny] = 0;
								count++;
							}
						}
					}
				}
			}
		}
		
		return count;
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 입력
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		board = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int hour = 0; // 치즈를 모두 없애는데 걸리는 시간
		int last = 0; // 마지막 남은 치즈조각 수
		
		// 공기 2에 맞닿아 있는 치즈 1은 빈칸으로 바뀜
		board[0][0] = 2;
		int count = 0;
		while(true) {
			air(); // 치즈 속 구멍은 0으로 유지, 공기는 2로 바꿔줌
			count = cheese(); // 공기 2에 맞닿아 있는 치즈 1은 빈칸 0으로 바뀜
			if(count == 0) break; // 치즈가 없었다면 while문 탈출
			last = count; // 이 시간에 없앤 치즈의 양을 저장. 마지막 남은 치즈양이 저장됨.
			hour++;
		}
		
		sb.append(hour + "\n" + last);
		System.out.println(sb);
	}

}