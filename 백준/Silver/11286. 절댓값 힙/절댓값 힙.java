import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// N 입력
		int N = Integer.parseInt(br.readLine());
		// 절대값 힙
		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];// 절대값이 같다면 더 작은 수 기준으로 오름차순 정렬
				return o1[0] - o2[0]; // 절댓값 작은 순 1순위로 오름차순 정렬
			}
		});
		
		// N만큼 연산
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) {// 0이면 값 출력 & 제거
				if(q.isEmpty()) sb.append(0 + "\n"); // 비어있으면 0
				else sb.append(q.poll()[1] + "\n");
			}
			else // 0이 아니면 절대값, 원래 수 배열에 담아 큐에 넣기
				q.add(new int[] {Math.abs(x), x});
		}
		
		// 출력
		System.out.println(sb);
	}

}