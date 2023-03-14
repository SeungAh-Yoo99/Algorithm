import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minQueue = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(maxQueue.size() == minQueue.size()) maxQueue.add(tmp);
			else minQueue.add(tmp);
			
			if(minQueue.size() > 0 && maxQueue.peek() > minQueue.peek()) {
				int t1 = maxQueue.poll();
				int t2 = minQueue.poll();
				maxQueue.add(t2);
				minQueue.add(t1);
			}
			
			sb.append(maxQueue.peek() + "\n");
		}
		
		System.out.println(sb);
	}

}
