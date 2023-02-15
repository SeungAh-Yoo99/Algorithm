import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// R, C, Q 입력
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		// 밝기를 입력 받으며 누적 합을 바로 구하기
		int[][] arr = new int[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) + arr[i][j - 1] + arr[i - 1][j] - arr[i - 1][j - 1];
			}
		}
		
		// Q만큼 밝기 평균 출력
		for (int i = 0; i < Q; i++) {
			// r1, c1, r2, c2 입력
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			// (r1, c1) ~ (r2, c2)에 해당하는 부분합 구하기
			int sum = arr[r2][c2] - arr[r2][c1 - 1] - arr[r1 - 1][c2] + arr[r1 - 1][c1 - 1];
			// 평균 구하기
			int avg = sum / ((r2 - r1 + 1) * (c2 - c1 + 1));
			// 답 저장
			sb.append(avg + "\n");
		}
		
		// 답 출력
		System.out.println(sb);
	}

}