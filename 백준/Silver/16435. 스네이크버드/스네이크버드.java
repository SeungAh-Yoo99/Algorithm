import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N, L 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		// 과일 높이 입력
		PriorityQueue<Integer> h = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			h.add(Integer.parseInt(st.nextToken()));
		}
		
		// 먹을 수 있는 과일이 나오지 않을 때까지 먹기
		while(!h.isEmpty() &&L >= h.poll()) {
			L++;
		}
		
		// 출력
		System.out.println(L);
	}

}