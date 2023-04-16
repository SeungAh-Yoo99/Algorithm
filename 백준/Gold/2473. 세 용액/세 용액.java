import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr); // 오름차순으로 정렬
		
		long minSum = Long.MAX_VALUE;
		long[] result = new long[3];
		
		for (int i = 0; i < N - 2; i++) { // 처음 값 선택
			int start = i + 1; // 두번째 값
			int end = N - 1; // 세번째 값
			
			while(start < end) {
				
				// 특성값이 0에 더 가까운 용액 발견
				if(Math.abs(arr[i] + arr[start] + arr[end]) < minSum) {
					minSum = Math.abs(arr[i] + arr[start] + arr[end]);
					result[0] = arr[i];
					result[1] = arr[start];
					result[2] = arr[end];
				}
				
				if(arr[i] + arr[start] + arr[end] > 0) end--;
				else start++;
			}
		}
		
		System.out.println(result[0] + " " + result[1] + " "+ result[2]);
	}

}