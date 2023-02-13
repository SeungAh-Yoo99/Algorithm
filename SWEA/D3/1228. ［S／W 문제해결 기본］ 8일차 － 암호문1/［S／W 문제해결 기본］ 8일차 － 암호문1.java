import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Solution {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> list = new LinkedList<>();
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			sb.append("#" + test_case + " ");
			
			// 배열 초기화
			list.clear();
			
			// 암호문의 길이 N 입력
			int N = Integer.parseInt(br.readLine());
			
			// 원본 암호문 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			// 명령어의 개수 M 입력
			int M = Integer.parseInt(br.readLine());
			
			// 명령 수행
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				String c = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				// y개의 숫자 삽입
				for (int j = 0; j < y; j++) {
					int s = Integer.parseInt(st.nextToken());
					list.add(x + j, s);
				}
			}
			
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i));
				if(i == 9) sb.append("\n");
				else sb.append(" ");
			}
		}
		
		System.out.println(sb);
	}

}