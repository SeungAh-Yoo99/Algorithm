import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int []nmb = new int[3];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++)
			nmb[i] = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[257];
		int ans_height = 0, ans_time = (int)10e9;
		int time, inv;
		
		for (int i = 0; i < nmb[0]; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < nmb[1]; j++)
			arr[Integer.parseInt(st.nextToken())] += 1;
		}
		
		// 높이가 0부터 256까지로 만든다고 가정했을 때,
		// 가능하다면 걸리는 시간과 높이를 ans에 저장.
		for (int i = 0; i < 257; i++) {
			time = 0; inv = nmb[2];
			for (int j = 0; j < 257; j ++) {
				if (i == j) continue;
				else if (i < j) {
					time += arr[j] * 2 * (j - i);
					inv += arr[j] * (j - i);
				}
				else if (i > j) {
					time += arr[j] * (i - j);
					inv -= arr[j] * (i - j);
				}
			}
			// 인벤토리가 음수가 아니며
			// 현재까지 시간이 가장 적게 걸렸다면, ans 갱신
			if (inv >= 0)
				if (time <= ans_time) {
					ans_time = time;
					ans_height = i;
				}
		}
		System.out.println(ans_time + " " + ans_height);
	}

}