import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스 입력
		int t = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= t; test_case++) {
			// n 입력
			int n = Integer.parseInt(br.readLine());
			
			// 0~9까지 모두 확인했을 경우 checking이 bitMarking과 동일해진다.
			int bitMarking = (1 << 10) - 1;
			int checking = 0;
			int cnt = 0;
			// checking이 bitMarking과 동일해질 때까지 반복
			while(bitMarking != checking) {
				cnt++;
				// n * cnt를 string으로 변환 후 char 배열에 각 자릿수를 넣는다.
				char[] arr = String.valueOf(n * cnt).toCharArray();
				// 각 자릿수에 대해 비트 연산자 | 를 통해 checking에 방문 체크를 한다.
				for (char c : arr) {
					checking = checking | 1 << (c - '0');
				}
			}
			// 출력
			System.out.println("#" + test_case + " " + n * cnt);
		}
	}

}