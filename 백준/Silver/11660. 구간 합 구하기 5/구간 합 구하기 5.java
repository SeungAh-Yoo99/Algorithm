import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// n, m 입력
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		// 수의 합을 담을 배열 선언 & 입력
		// (arr[i][j]에는 arr[i][1]~arr[i][j]까지의 합이 담겨 있음)
		int[][] arr = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j++) {
				arr[i][j] = arr[i][j - 1] + Integer.parseInt(st.nextToken());
			}
		}
		
		// 구간 합을 m번만큼 구해줌
		StringBuilder sb = new StringBuilder(); // 답을 넣어줌
		for (int i = 0; i < m; i++) {
			// x1, y1, x2, y2 입력
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int sum = 0;
			for(int j = x1; j <= x2; j++) {
				sum += arr[j][y2] - arr[j][y1 - 1];
			}
			sb.append(sum + "\n");
		}
		
		// 출력
		System.out.println(sb);
	}

}