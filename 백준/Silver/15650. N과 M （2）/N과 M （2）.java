import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	private static void combi(int idx, int num) {
		if(idx == m - 1) { // 수열의 마지막이라면
			arr[idx] = num;
			stringBuilderAppend();
			return;
		}
		
		for (int i = num + 1; i <= n; i++) {
			arr[idx] = num;
			combi(idx + 1, i);
		}
		
	}
	
	private static void stringBuilderAppend() {
		for (int i = 0; i < m; i++) {
			sb.append(arr[i]);
			if(i != m - 1)
				sb.append(" ");
		}
		sb.append("\n");
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// n, m 입력
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// m 크기의 배열 선언
		arr = new int[m];
		
		// 수열 구하기
		for (int i = 1; i <= n - m + 1; i++) {
			combi(0, i);
		}
		
		// 출력
		System.out.println(sb);
	}

}