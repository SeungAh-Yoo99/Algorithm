import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] negative = new int[10001]; // -1 ~ -10000이 몇 개 있는지 나타내는 배열
		int[] positive = new int[10001]; // 0 ~ 10000이 몇 개 있는지 나타내는 배열
		
for1:		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp >= 0) positive[tmp]++;
			else negative[-tmp]++;
			
			int count = -1;
			for (int j = 10000; j > 0; j--) { // 음수값부터
				count += negative[j];
				if(count >= i / 2) { // 가운데 값 찾았다면
					sb.append(-j + "\n");
					continue for1;
				}
			}
			for (int j = 0; j <= 10000; j++) { // 양수값 확인
				count += positive[j];
				if(count >= i / 2) { // 가운데 값 찾았다면
					sb.append(j + "\n");
					continue for1;
				}
			}
		}
		
		System.out.println(sb);
	}

}