import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 테스트 데이터 개수 T 입력
		int T = Integer.parseInt(br.readLine());
		
		// T만큼 반복
		for (int t = 0; t < T; t++) {
			// 소설 장의 수 K 입력
			int K = Integer.parseInt(br.readLine());
			
			// 파일의 크키를 담을 우선 순위 큐 선언
			PriorityQueue<Long> pq = new PriorityQueue<>();
			
			// K개 만큼의 파일 크기 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				pq.add(Long.parseLong(st.nextToken()));
			}
			
			// 큰 비용이 드는 파일일수록 되도록 합치는 연산을 하지 않는 것이 좋다.
			// 우선순위 큐에 비용을 넣어두고
			// 계속 적은 비용이 드는 것들끼리만 합쳐준다.
			
			long cost = 0; // 최소 비용을 담는다.
			while(pq.size() != 1) { // 장이 하나가 될 때까지
				long tmp = pq.poll() + pq.poll(); // 가장 비용이 적은 값 두 개를 꺼내 더하고
				cost += tmp; // 비용을 추가해주고
				pq.add(tmp); // 다시 큐에 넣는다
			}
			
			
			// 답 저장
			sb.append(cost + "\n");
		}
		
		// 출력
		System.out.println(sb);
	}

}