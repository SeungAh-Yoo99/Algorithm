import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// n과 수열 A 입력, result 배열 초기화
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] result = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int card1 = 0, card2 = 1, card3 = n - 1;
		for(int i = 0, j = n; i < n; i++, j--) {
			if(arr[i] == 1) {
				result[card1] = j;
				card2++;
				card1 = card2 - 1;
			}
			else if(arr[i] == 2) {
				result[card2++] = j;
			}
			else {
				result[card3--] = j;
			}
		}
		
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(result[i] + " ");
		}
		System.out.println(sb);
	}

}