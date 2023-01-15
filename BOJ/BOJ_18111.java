import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// n, m, b 입력
		int []nmb = new int[3];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 3; i++)
			nmb[i] = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[257]; // 인덱스에 해당하는 땅의 높이의 갯수를 저장할 배열
		int ans_height = 0, ans_time = (int)10e9; // 시간은 최대값으로 초기화 해둠.
		
		// 땅 높이 입력 받아 높이를 인덱스 삼아 해당 높이의 땅이 몇 개인지 배열에 저장.
		for (int i = 0; i < nmb[0]; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < nmb[1]; j++)
				arr[Integer.parseInt(st.nextToken())] += 1;
		}
		
		// 땅 높이를 0부터 256까지로 만든다고 가정했을 때,
		// 가능하다면(인벤토리에 있는 땅의 갯수가 모자르지 않다면) 걸리는 시간과 높이를 ans에 저장.
		int time, inv;
		for (int i = 0; i < 257; i++) { // 땅의 높이를 i로 만들 때,
			time = 0; inv = nmb[2]; // 현재 걸리는 시간과 인벤토리의 땅의 수를 초기화
			for (int j = 0; j < 257; j ++) { // arr를 돌며 j높이의 땅 arr[j]개를 i높이로 만들 때의 시간 구하기
				if (i == j) continue;
				else if (i < j) { // j가 더 크면 땅을 j-i만큼 깎아주어야함.
					time += arr[j] * 2 * (j - i); // 시간 추가
					inv += arr[j] * (j - i); // 깎은 만큼 인벤토리에 추가
				}
				else if (i > j) { // j가 더 작으면 i-j만큼 땅을 쌓아주어야 함.
					time += arr[j] * (i - j); // 시간 추가
					inv -= arr[j] * (i - j); // 쌓은 만큼 인벤토리에서 빼줌.
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