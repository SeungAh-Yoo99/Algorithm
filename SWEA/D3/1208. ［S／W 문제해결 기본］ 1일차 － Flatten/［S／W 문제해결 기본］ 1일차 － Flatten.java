import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 테스트 케이스만큼 반복
		for (int test_case = 1; test_case <= 10; test_case++) {
			// 덤프 횟수 입력
			int n = Integer.parseInt(br.readLine());
			
			// 상자의 높이값 입력
			int[] box = new int[100];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}
			
			// n만큼 덤프 진행
			for (int i = 0; i < n; i++) {
				Arrays.sort(box);
				box[0] += 1;
				box[99] -= 1;
			}
			
			// 출력
			Arrays.sort(box);
			System.out.printf("#%d %d\n", test_case, box[99] - box[0]);
		}
	}

}