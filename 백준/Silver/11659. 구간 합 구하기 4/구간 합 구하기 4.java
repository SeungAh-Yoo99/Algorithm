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
		
		// n개의 수의 합 배열에 저장(i번째 배열에는 1~i의 합이 들어있다.
		int[] arr = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			arr[i] = arr[i -1] + Integer.parseInt(st.nextToken());
		}
		
		// m만큼 수의 구간 합 구하기
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(arr[e] - arr[s - 1] + "\n");
		}
		
		// 출력
		System.out.println(sb);
	}

}