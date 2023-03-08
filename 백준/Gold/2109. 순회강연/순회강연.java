import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		int lastDay = 0; // 마지막 마감일
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][0] = Integer.parseInt(st.nextToken());
			lastDay = Math.max(lastDay, arr[i][0]);
		}
		
		int[] pay = new int[lastDay + 1]; // 인덱스에 해당하는 날에 벌 수 있는 최대 수익
		for (int i = 0; i < n; i++) { // 대학에서 제시한 값을 모두 검사
			for (int j = arr[i][0]; j > 0; j--) { // 마감일부터 첫째날까지 보며
				if(pay[j] < arr[i][1]) { // j날 최대 수익보다 현재 검사 중인 대학에서 제시한 값이 더 크면
					int tmp = pay[j]; // j날에 현재 검사 중인 대학에서 제시한 값을 넣어주고
					pay[j] = arr[i][1];
					int k = j - 1;
					while(k > 0) { // 1 ~ j-1일을 검사해주며 하루씩 강연을 당겼을 때 더 큰 수익을 얻을 수 있으면 당겨준다.
						if(pay[k] < tmp){
							int t = pay[k];
							pay[k] = tmp;
							tmp = t;
						}
						k--;
					}
					break;
				}
			}
		}
		
		int result = 0;
		for (int i = 1; i <= lastDay; i++) {
			result += pay[i];
		}
		
		System.out.println(result);
	}

}