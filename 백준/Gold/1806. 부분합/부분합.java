import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N, S 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		// N개의 수열 입력
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;
		int sum = 0;
		int result = (int) 10e9;
		for (int end = 0; end < N; end++) {
			sum += arr[end];
			if(sum < S) // arr[start + 1]부터 arr[end]의 합이 S보다 크거나 같아야 함.
				continue;
			
			for(int j = start; j < end; j++) {
				if(sum - arr[j] >= S) {// 만약 start + 1을 빼줘도 S보다 크거나 같다면
					start++; // start + 1을 해준다.
					sum -= arr[j];
				}
				else // 아니라면 반복문 탈출
					break;
			}
			
			// 현재의 end - start의 값이 현재 최소값(result)보다 작다면 갱신해줌
			result = result < end - start + 1 ? result : end - start + 1;
		}
		if(result != (int) 10e9)
			System.out.println(result);
		else
			System.out.println(0);
	}

}