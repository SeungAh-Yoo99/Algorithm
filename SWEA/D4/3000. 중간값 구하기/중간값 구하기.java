import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		final int MOD = 20_171_109;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			
			// 중간값을 기준으로 한 최소 힙 -> 항상 왼쪽에 수가 하나 더 많게 유지
			PriorityQueue<Integer> leftPq = new PriorityQueue<>(Collections.reverseOrder());
			PriorityQueue<Integer> rightPq = new PriorityQueue<>();
			leftPq.add(A);
			
			int result = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				
				// X, Y 둘 다 중간값보다 작은 경우
				if(X < leftPq.peek() && Y < leftPq.peek()) {
					// X, Y를 leftPq에 넣어준다.
					leftPq.add(X);
					leftPq.add(Y);
					// 중간 값인 leftPq의 루트를 rightPq로 옮겨준다.
					rightPq.add(leftPq.poll());
				}
				// X, Y 둘 다 중간값보다 큰 경우
				else if(X > leftPq.peek() && Y > leftPq.peek()) {
					// X, Y를 rigthPq에 넣어준다.
					rightPq.add(X);
					rightPq.add(Y);
					// rightPq의 루트를 leftPq로 옮겨준다.
					leftPq.add(rightPq.poll());
				}
				else {
					if(X < Y) {
						leftPq.add(X);
						rightPq.add(Y);
					}
					else {
						leftPq.add(Y);
						rightPq.add(X);
					}
				}
				
				// 중간값 구하기
				result = (result + leftPq.peek()) % MOD;
			}
			
			sb.append("#" + tc + " " + result + "\n");
		}
		System.out.println(sb);
	}

}