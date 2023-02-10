import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N 입력
		int N = Integer.parseInt(br.readLine());
		
		// 카드를 넣을 Dequeue 정의
		Deque<Integer> dq = new LinkedList<Integer>();
		
		// 카드를 1부터 N까지 순서대로 dq에 넣는다.
		for (int i = 1; i <= N; i++) {
			dq.add(i);
		}
		
		// 동작을 반복하며 마지막 카드 구하기
		int card = 0, i = 0;
		while(!dq.isEmpty()) {
			// 한 장 버리기
			if(i % 2 == 0)
				card = dq.pollFirst();
			
			// 맨 앞 카드 맨 뒤로 옮기기
			else {
				card = dq.pollFirst();
				dq.add(card);
			}
			
			i++;
			
		}
		
		// 출력
		System.out.println(card);
	}

}