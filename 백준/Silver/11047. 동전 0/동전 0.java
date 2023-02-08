import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// n, k 입력
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// n 크기 배열 생성 & 동전의 가치 입력
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 가치가 큰 동전부터 몇 개가 필요한지 구하기
		int result = 0;
		for (int i = n - 1; i >= 0; i--) {
			if(arr[i] <= k) {
				result += k / arr[i];
				k %= arr[i];
			}
			// k이가 0이 되면 반복문 탈출
			if(k == 0)
				break;
		}
		
		// 출력
		System.out.println(result);
	}

}