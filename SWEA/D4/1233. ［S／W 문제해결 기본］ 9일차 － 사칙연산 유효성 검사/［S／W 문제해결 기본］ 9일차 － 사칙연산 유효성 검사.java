import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	// 완전 이진 트리 이므로 리프노드일 경우에만 정수가 오고 자식 노드가 있다면 연산자가 와야 한다.
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			sb.append("#" + test_case + " ");
			
			// N 입력
			int N = Integer.parseInt(br.readLine());
			
			int result = 1;
			for (int i = 0; i < N; i++) {
				// 정점 정보 입력
				st = new StringTokenizer(br.readLine());
				// 정점 번호
				int number = Integer.parseInt(st.nextToken());
				// 연산자 or 숫자
				String s = st.nextToken();
				
				// 자식 노드 정보가 있다면 s는 연산자, 자식 노드 정보가 없다면 s는 숫자여야 함.
				if(st.hasMoreTokens()) { // 자식 노드 정보가 있는데
					// 사칙 연산자가 아니라면
					if(!s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/"))
						result = 0;// 적절한 식이 아님
				}
				else { // 자식 노드 정보가 없는데
					// 사칙 연산자라면
					if(s.equals("+") && s.equals("-") && s.equals("*") && s.equals("/"))
						result = 0;// 적절한 식이 아님
				}
			}
			
			sb.append(result + "\n");
		}
		
		System.out.println(sb);
	}

}