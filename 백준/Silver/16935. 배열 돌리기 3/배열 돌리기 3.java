import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[][] arr;
	
	static void turn(int c) {
		// 1번 연산
		if(c == 1) { // 상하 반전
			for (int i = 0; i < N / 2; i++) {
				int[] tmp = arr[i];
				arr[i] = arr[N - 1 - i];
				arr[N - 1 - i] = tmp;
			}
		}
		
		// 2번 연산
		else if(c == 2) { // 좌우 반전
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M / 2; j++) {
					int tmp = arr[i][j];
					arr[i][j] = arr[i][M - 1 - j];
					arr[i][M - 1 - j] = tmp;
				}
			}
		}
		
		// 3번 연산
		else if(c == 3) {
			int[][] tmpArr = new int[M][N]; // 임시 배열
			for (int i = 0; i < N; i++) { // 오른쪽으로 회전
				for (int j = 0; j < M; j++) {
					tmpArr[j][N - 1 - i] = arr[i][j];
				}
			}
			int tmp = N; // 가로 세로 길이 바꿔주기
			N = M;
			M = tmp;
			arr = tmpArr;
		}
		
		// 4번 연산
		else if(c == 4) {
			int[][] tmpArr = new int[M][N]; // 임시 배열
			for (int i = 0; i < N; i++) { //왼쪽으로 회전
				for (int j = 0; j < tmpArr.length; j++) {
					tmpArr[M - 1 - j][i] = arr[i][j];
				}
			}
			int tmp = N; // 가로 세로 길이 바꿔주기
			N = M;
			M = tmp;
			arr = tmpArr;
		}
		
		// 5번 연산
		else if(c == 5) {
			int[][] tmpArr = new int[N][M]; // 임시 배열
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) { 
					tmpArr[i][M / 2 + j] = arr[i][j]; // 1번 그룹 -> 2번 그룹
					tmpArr[N / 2 + i][M / 2 + j] = arr[i][M / 2 + j]; // 2번 그룹 -> 3번 그룹
					tmpArr[N / 2 + i][j] = arr[N / 2 + i][M / 2 + j]; // 3번 그룹 -> 4번 그룹
					tmpArr[i][j] = arr[N / 2 + i][j]; // 4번 그룹 -> 1번 그룹
				}
			}
			arr = tmpArr;
		}
		
		// 6번 연산
		else {
			int[][] tmpArr = new int[N][M]; // 임시 배열
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M / 2; j++) { 
					tmpArr[N / 2 + i][j] = arr[i][j]; // 1번 그룹 -> 4번 그룹
					tmpArr[N / 2 + i][M / 2 + j] = arr[N / 2 + i][j]; // 4번 그룹 -> 3번 그룹
					tmpArr[i][M / 2 + j] = arr[N / 2 + i][M / 2 + j]; // 3번 그룹 -> 2번 그룹
					tmpArr[i][j] = arr[i][M / 2 + j]; // 2번 그룹 -> 1번 그룹
				}
			}
			arr = tmpArr;
		}
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// N, M, R 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		// 배열 입력
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 연산 번호 입력
		int[] r = new int[R];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			r[i] = Integer.parseInt(st.nextToken());
		}

		// 연산 시작
		for (int i = 0; i < R; i++) {
			if(i + 1 < R && r[i] == 1 && r[i + 1] == 1) { // 1번 연산이 2번 연속으로 나오면 안하는 것과 똑같음
				i++;
			}
			else if(i + 1 < R && r[i] == 2 && r[i + 1] == 2) { // 2번 연산이 2번 연속으로 나오면 안하는 것과 똑같음
				i++;
			}
			else if(i + 1 < R && r[i] == 3 && r[i + 1] == 4) { // 3번 연산 다음 4번 연산 나오면 안하는 것과 똑같음
				i++;
			}
			else if(i + 1 < R && r[i] == 4 && r[i + 1] == 3) { // 4번 연산 다음 3번 연산 나오면 안하는 것과 똑같음
				i++;
			}
			else if(i + 1 < R && r[i] == 5 && r[i + 1] == 6) { // 5번 연산 다음 6번 연산 나오면 안하는 것과 똑같음
				i++;
			}
			else if(i + 1 < R && r[i] == 6 && r[i + 1] == 5) { // 6번 연산 다음 5번 연산 나오면 안하는 것과 똑같음
				i++;
			}
			else { // 위의 조건이 모두 해당되지 않을 때만 실행
				turn(r[i]);
			}
		}

		// 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]);
				if(j != M - 1) sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}