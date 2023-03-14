import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] board;
	static int L;
	static int[] turnTime;
	static String[] direction;
	static int[] dx = {-1, 0, 1, 0}; // 위쪽, 오른쪽, 아래쪽, 왼쪽
	static int[] dy = {0, 1, 0, -1};
	static int d; // 뱀이 바라보는 방향
	static Deque<int[]> snake; // 뱀이 차지하는 칸을 담는 deque
	
	private static int play() {
		
		d = 1; // 뱀이 바라보는 방향, 처음엔 오른쪽을 향한다.
		snake.addFirst(new int[] {1, 1}); // 뱀의 시작 위치
		
		for (int i = 1; i <= L; i++) {
			for (int j = turnTime[i - 1] + 1; j <= turnTime[i]; j++) { // 방향 변환
				if(!go()) return j; // 게임이 끝났다면 끝난 시간 리턴
			}
			// 방향 변환
			if(direction[i].equals("L")) d = d == 0 ? 3 : d - 1;
			else d = d == 3 ? 0 : d + 1;
		}
		// 마지막 방향 전환까지 게임이 끝나지 않은 경우
		int time = turnTime[L] + 1;
		while(true) {
			if(!go()) return time;
			time++;
		}
	}
	
	private static boolean go() { // false를 리턴 했다면 게임이 끝난 것
		
		int nx = snake.peekFirst()[0] + dx[d];
		int ny = snake.peekFirst()[1] + dy[d];
		
		if(nx >= 1 && nx <= N && ny >= 1 && ny <= N) { // 범위 체크
			if(board[nx][ny] == 0) { // 빈 칸이라면
				board[nx][ny] = 2; // 뱀의 몸으로 바꿔주고
				snake.addFirst(new int[] {nx, ny}); // 머리를 추가해주고
				
				int[] tail = snake.pollLast(); // 꼬리 정보를 빼주고
				board[tail[0]][tail[1]] = 0; // 꼬리를 비워준다
				
				return true; 
			}
			else if(board[nx][ny] == 1) { // 사과라면
				board[nx][ny] = 2; // 뱀의 몸으로 바꿔주고
				snake.addFirst(new int[] {nx, ny}); // 머리를 추가해주고, 꼬리는 빼주지 않음
				
				return true;
			}
			else { // 뱀의 몸이라면
				return false;
			}
		}
		else { // 범위 벗어났다면 벽에 부딫힌 것
			return false;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		board = new int[N + 1][N + 1];
		board[1][1] = 2; // 맨 위 맨 좌측은 뱀, 뱀은 2
		
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1; // 1이 사과
		}
		
		L = Integer.parseInt(br.readLine());
		turnTime = new int[L + 1]; // 방향 변환 시간
		direction = new String[L + 1]; // 방향 변환 정보
		for (int i = 1; i <= L; i++) {
			st = new StringTokenizer(br.readLine());
			turnTime[i] = Integer.parseInt(st.nextToken());
			direction[i] = st.nextToken();
		}
		
		snake = new ArrayDeque<>(); // 뱀이 차지하는 칸을 담는 deque, first는 머리, last는 꼬리
		
		// 게임 시작
		int result = play();
		
		// 출력
		System.out.println(result);
	}

}