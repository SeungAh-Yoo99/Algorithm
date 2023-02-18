import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 9개의 수 입력
		int[] arr = new int[9];
		int sum = 0; // 수 총합
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		// 포함되지 않는 2개 구하기
		int i = 0, j = 0;
for1:	for (i = 0; i < 8; i++) {
			for (j = i + 1; j < 9; j++) {
				if(sum - arr[i] - arr[j] == 100)
					break for1;
			}
		}

		// 출력
		for (int k = 0; k < 9; k++) {
			if(k != i && k != j)
				sb.append(arr[k] + "\n");
		}
		System.out.println(sb);
	}

}