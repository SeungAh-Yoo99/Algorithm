import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			int n = Integer.parseInt(br.readLine());
			
			if (n == 0) {
				// 배열이 비어있다면 0 출력
				if (pq.isEmpty())
					System.out.println(0);
				// 비어있지 않다면 가장 작은 값 출력
				else
					System.out.println(pq.poll());
			}
			else
				pq.add(n);
		}
	}

}