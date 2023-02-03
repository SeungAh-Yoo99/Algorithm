import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// n 입력, result 배열 초기화
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new LinkedList<>();

		// 카드 기술 입력
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = n - 1, j = 1; i >= 0; i--, j++) {
			if(arr[i] == 1) {
				dq.addLast(j);
			}
			else if(arr[i] == 2) {
				int tmp = dq.removeLast();
				dq.addLast(j);
				dq.addLast(tmp);
			}
			else { // arr[i] == 3
				dq.addFirst(j);
			}
		}
		
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = n - 1; i >= 0; i--) {
			sb.append(dq.removeLast() + " ");
		}
		System.out.println(sb);
	}

}