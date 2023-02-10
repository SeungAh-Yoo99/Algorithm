import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스 수 입력
		int TC = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= TC; test_case++) {
			sb.append("#" + test_case + " ");
			
			// N, M 입력
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 비트마스킹
			int bit = (1 << N) - 1;
			// 마지막 N 비트가 모두 1로 켜져 있을 경우
			if((M & bit) == bit) sb.append("ON" + "\n");
			// 켜져 있지 않을 경우
			else sb.append("OFF" + "\n");
		}
		
		System.out.println(sb);
	}

}