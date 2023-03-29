import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int K;
	static int W;
	static int H;
	static int[][][] board;
	
	private static void bfs() {
		
		int[] dx1 = {-1, 1, 0, 0}; // 인접한 네 방향 움직임
		int[] dy1 = {0, 0, -1, 1};
		
		int[] dx2 = {-2, -2, -1, -1, 1, 1, 2, 2}; // 말의 움직임
		int[] dy2 = {-1, 1, -2, 2, -2, 2, -1, 1};
		
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {0, 0, 1, 0});
		
		board[0][0][0] = 1;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			int cost = now[2];
			int flag = now[3];
			
			if(flag < K) { // 아직 말의 움직임을 더 할 수 있는 이동
				// 인접한 이동
				for (int i = 0; i < 4; i++) {
					int nx = x + dx1[i];
					int ny = y + dy1[i];
					if(nx >= 0 && nx < H && ny >= 0 && ny < W && board[nx][ny][0] != -1) { // 범위 체크
						if(board[nx][ny][flag] == 0) { // 아직 한 번도 안왔다면
							board[nx][ny][flag] = cost + 1;
							q.add(new int[] {nx, ny, cost + 1, flag});
						}
						else if(board[nx][ny][flag] > cost + 1) { // 도착한 적은 있지만 더 빠른 경로라면
							board[nx][ny][flag] = cost + 1;
							q.add(new int[] {nx, ny, cost + 1, flag});
						}
					}
				}
				// 말의 이동
				for (int i = 0; i < 8; i++) {
					int nx = x + dx2[i];
					int ny = y + dy2[i];
					if(nx >= 0 && nx < H && ny >= 0 && ny < W && board[nx][ny][0] != -1) { // 범위 체크
						if(board[nx][ny][flag + 1] == 0) { // 아직 한 번도 안왔다면
							board[nx][ny][flag + 1] = cost + 1;
							q.add(new int[] {nx, ny, cost + 1, flag + 1});
						}
						else if(board[nx][ny][flag + 1] > cost + 1) { // 도착한 적은 있지만 더 빠른 경로라면
							board[nx][ny][flag + 1] = cost + 1;
							q.add(new int[] {nx, ny, cost + 1, flag + 1});
						}
					}
				}
			}
			
			else { // 이미 말의 움직임을 다 썼다면
				// 인접한 이동
				for (int i = 0; i < 4; i++) {
					int nx = x + dx1[i];
					int ny = y + dy1[i];
					if(nx >= 0 && nx < H && ny >= 0 && ny < W && board[nx][ny][0] != -1) { // 범위 체크
						if(board[nx][ny][flag] == 0) { // 아직 한 번도 안왔다면
							board[nx][ny][flag] = cost + 1;
							q.add(new int[] {nx, ny, cost + 1, flag});
						}
						else if(board[nx][ny][flag] > cost + 1) { // 도착한 적은 있지만 더 빠른 경로라면
							board[nx][ny][flag] = cost + 1;
							q.add(new int[] {nx, ny, cost + 1, flag});
						}
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		board = new int[H][W][K + 1];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				board[i][j][0] = Integer.parseInt(st.nextToken());
				if(board[i][j][0] == 1) board[i][j][0] = -1; // 장애물 -1로 표시
			}
		}
		
		bfs();
		
		int result = Integer.MAX_VALUE;
		for (int i = 0; i <= K; i++) {
			if(board[H - 1][W - 1][i] != 0) result = Math.min(result, board[H - 1][W - 1][i]);
		}
		
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result - 1);
	}

}