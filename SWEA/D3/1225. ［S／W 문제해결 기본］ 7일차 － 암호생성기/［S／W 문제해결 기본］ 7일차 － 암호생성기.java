import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			int T = Integer.parseInt(br.readLine());
			sb.append("#" + T + " ");
			
			// 8개의 데이터 넣을 Queue 선언 & 입력
			Queue<Integer> q = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			int count = 1;
			while(true) {
				int tmp = q.poll();
				tmp -= count;
				// tmp가 0이거나 음수면 0을 q에 add
				if(tmp <= 0) {
					q.add(0);
					break;
				}
				// 아니라면 다시 tmp를 q에 넣고 count++, while 다시 반복
				q.add(tmp);
				count  = count + 1 > 5 ? 1 : count + 1;
			}
			
			for (int i = 0; i < 8; i++) {
				if(i == 7)
					sb.append(q.poll() + "\n");
				else
					sb.append(q.poll() + " ");
			}
		}
		
		// 출력
		System.out.println(sb);
	}

}