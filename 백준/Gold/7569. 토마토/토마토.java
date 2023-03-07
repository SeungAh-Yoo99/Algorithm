import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int M;
	static int N;
	static int H;
	static int[][][] box;
	static Queue<int[]> tomato;
	static int day = -1;
	
	private static void bfs() {
		
		// 위, 아래, 앞, 뒤, 앞, 왼쪽, 오른쪽
		int[] dh = {-1, 1, 0, 0, 0, 0};
		int[] dx = {0, 0, -1, 1, 0, 0};
		int[] dy = {0, 0, 0, 0, -1, 1};
		
		while(!tomato.isEmpty()) { // 주위 토마토를 모두 익힐 때까지
			Queue<int[]> next = new LinkedList<>();
			
			while(!tomato.isEmpty()) {
				int[] t = tomato.poll();
				
				for (int i = 0; i < 6; i++) { // 6방 탐색
					int nh = t[0] + dh[i];
					int nx = t[1] + dx[i];
					int ny = t[2] + dy[i];
					
					if(nh >= 0 && nh < H && nx >= 0 && nx < N && ny >= 0 && ny < M) { // 범위 체크
						if(box[nh][nx][ny] == 0) { // 6방에 아직 익지 않은 토마토가 있으면
							box[nh][nx][ny] = 1; // 익혀주고
							next.add(new int[] {nh, nx, ny});
						}
					}
				}
			}
			
			tomato = next;
			day++;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		box = new int[H][N][M];
		tomato = new LinkedList<>(); // 익은 토마토를 넣을 큐
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
					if(box[i][j][k] == 1) { // 익은 토마토면
						tomato.add(new int[] {i, j, k}); // 큐에 넣어줌
					}
				}
			}
		}
		
		// 토마토 익히기
		bfs();

		// 모든 토마토가 익었는지 확인
		boolean isTrue = true;
for1:		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(box[i][j][k] == 0) {
						isTrue = false;
						break for1;
					}
				}
			}
		}
		
		if(isTrue) System.out.println(day);
		else System.out.println(-1);
	}

}