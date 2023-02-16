import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N; // 배열의 크기
	static int M; // 배열의 크기
	static int K; // 회전 연산의 개수
	static int[][] arr; // 배열
	static int[][] turn; // 돌리기 연산에 대한 정보
	static boolean[] done; // 배열 돌리기를 실행했는지 확인하는 배열
	static int[] order; // 배열 돌리기 실행 순서
	static int result = Integer.MAX_VALUE;
	
	// 배열 돌리기
	private static void turnArr(int[][] tmpArr, int r, int c, int s) {
		for (int i = 1; i <= s; i++) { // 안쪽부터 바깥까지 한 겹씩 총 s겹 배열 돌리기
			int tmp = tmpArr[r - i][c - i]; // 맨 앞의 수 기억
			for (int j = 0; j < 2 * i; j++) { // 왼쪽
				tmpArr[r - i + j][c - i] = tmpArr[r - i + j + 1][c - i];
			}
			for (int j = 0; j < 2 * i; j++) { // 밑
				tmpArr[r + i][c - i + j] = tmpArr[r + i][c - i + j + 1];
			}
			for (int j = 0; j < 2 * i; j++) { // 오른쪽
				tmpArr[r + i - j][c + i] = tmpArr[r + i - j - 1][c + i];
			}
			for (int j = 0; j < 2 * i; j++) { // 위
				tmpArr[r - i][c + i - j] = tmpArr[r - i][c + i - j - 1];
			}
			tmpArr[r - i][c - i + 1] = tmp; // 기억해 둔 수 저장
		}
	}
	
	private static void perm(int c) { // 순열 돌리기
		if(c == K) {
			// 배열 복사
			int[][] tmpArr = new int[N + 1][M + 1];
			for (int i = 0; i <= N; i++) {
				tmpArr[i] = arr[i].clone();
			}
			// 순서대로 배열 돌리기
			for (int i = 0; i < K; i++) {
				turnArr(tmpArr, turn[order[i]][0], turn[order[i]][1], turn[order[i]][2]);
			}
			// 배열의 최솟값 구하기
			int tmp = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				int sum = 0;
				for (int j = 1; j <= M; j++) {
					sum += tmpArr[i][j];
				}
				tmp = tmp < sum ? tmp : sum;
			}
			result = result < tmp ? result : tmp;
			return;
		}
		
		for (int i = 0; i < K; i++) {
			if(!done[i]) {
				order[c] = i;
				done[i] = true;
				perm(c + 1);
				done[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N, M, K 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// N x M 크기 배열 선언
		arr = new int[N + 1][M + 1];
		
		// 배열 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 배열 돌리기
		turn = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			turn[i][0] = Integer.parseInt(st.nextToken());
			turn[i][1] = Integer.parseInt(st.nextToken());
			turn[i][2] = Integer.parseInt(st.nextToken());
		}
		
		done = new boolean[K];
		order = new int[K];
		
		// 가능한 배열 돌리기 순서 모두 구하여 돌리기(순열)
		perm(0);
		
		// 출력
		System.out.println(result);
	}

}
