import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 세로 길이 H, 가로 길이 W
		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		// 블럭의 높이 입력
		int[] arr = new int[W];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 빗물이 고이는 구간 찾기
		int result = 0;
		int start = 0, end = 0;
		for (start = 0; start < W - 1;) {
			if (arr[start] == 0) {
				start++;
				continue;
			}
			
			int max_length = arr[start];
w1:			while(max_length >= 1) {
				for (end = start + 1; end < W; end++) {
					if(arr[end] >= max_length) {
						int max = arr[start] < arr[end] ? arr[start] : arr[end];
						for (int i = start + 1; i < end; i++) {
							result += max - arr[i];
						}
						break w1;
					}
				}
			max_length--;
			}
			
			start = end;
		}
		
		System.out.println(result);
	}

}