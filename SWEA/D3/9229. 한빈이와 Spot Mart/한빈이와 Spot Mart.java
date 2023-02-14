import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			sb.append("#" + test_case + " ");
			
			// N, M 입력
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// N 크기의 배열 선언 & 과자 무게 입력
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 최대합 구하기
			int result = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i != j) { // 동일한 과자가 아닐때
						if(arr[i] + arr[j] <= M) { // 무게를 초과하지 않으면서
							result = result > arr[i] + arr[j] ? result : arr[i] + arr[j]; // 최대 합을 구함
						}
					}
				}
			}
			if(result == 0)
                sb.append(-1 + "\n");
            else
				sb.append(result + "\n");
		}
		
		// 출력
		System.out.println(sb);
	}

}