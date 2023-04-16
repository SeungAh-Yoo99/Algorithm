import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] result = new int[2];
		int minSum = Integer.MAX_VALUE;
		int start = 0;
		int end = N - 1;
		
		while(start < end) {
			
			// 특성값이 0에 더 가까운 값을 찾았다면 저장
			if(Math.abs(arr[start] + arr[end]) < minSum) {
				minSum = Math.abs(arr[start] + arr[end]);
				result[0] = arr[start];
				result[1] = arr[end];
			}
			
			if(arr[start] + arr[end] > 0) end--;
			else start++;
		}

		System.out.println(result[0] + " " + result[1]);
	}

}