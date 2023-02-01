import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		LinkedList<Integer[]> list = new LinkedList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		// 테스트 케이스 입력
		int test_case = Integer.parseInt(br.readLine());
		for (int t = 0; t < test_case; t++) {
			// 리스트, 큐 초기화
			list = new LinkedList<>();
			pq = new PriorityQueue<>(Collections.reverseOrder());
			// n, m 입력
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			// 중요도 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				Integer[] tmpArr = {tmp, i};
				list.add(tmpArr);
				pq.add(tmp); // 우선순위 큐에도 넣어두어 최대값인지 확인
			}
			
			// 문서 출력 시작
			int result = 0;
			while(!pq.isEmpty()) {
				int num = pq.peek();
				int tmp1;
				int tmp2;
				// 현재 문서가 중요도가 가장 높은 경우
				if(num == list.get(0)[0]) {
					tmp2 = list.get(0)[1];
					list.remove(0);
					result++;
					pq.poll();
					// 답을 찾았다면 break
					if (tmp2 == m)
						break;
				}
				// 현재 문서가 중요도가 가장 높지 않은 경우
				else {
					tmp1 = list.get(0)[0];
					tmp2 = list.get(0)[1];
					// 앞에서 제거 후 다시 맨 뒤에 넣어줌
					list.remove(0);
					Integer[] tmpArr = {tmp1, tmp2};
					list.add(tmpArr);
				}
			}
			
			// 답 출력
			System.out.println(result);
		}
	}

}