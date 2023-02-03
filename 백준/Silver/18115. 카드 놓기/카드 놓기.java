import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		LinkedList<Integer> result = new LinkedList<>();
		
		// n과 수열 A 입력, card 배열 초기화
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 수행했던 기술을 반대로 보면서 카드를 가져가면 된다.
		for (int i = n - 1, j = 1; i >= 0; i--, j++) {
			// 맨 위에 카드를 둠
			if(arr[i] == 1) {
				result.add(0, j);
			}
			// 맨 앞에서 두 번째에 카드를 둠
			else if(arr[i] == 2) {
				result.add(1, j);
			}
			// 마지막에 카드를 둠
			else if(arr[i] == 3) {
				result.add(j);
			}
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i : result) {
			sb.append(i + " ");
		}
		System.out.println(sb);
	}

}
