import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n + 1];
		arr[0] = (int)10e9;
		for(int i = 1; i < n + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// ans에 레이저 수신 탑의 인덱스를 넣어둠
		int[] ans = new int[n + 1];
		// 먼저 바로 왼쪽 탑(a)의 높이를 확인한다.
		// a탑이 더 작다면, 적어도 a탑보다는 큰 탑들을 찾아야 한다.
		// 왼쪽 탑들 중 가장 먼저 등장하는 a탑보다 큰 탑은
		// a탑의 레이저 신호를 수신한 탑(b)이다.
		// b탑 마저도 현재 탑보다 작다면
		// b탑의 레이저 신호를 수신한 탑을 찾으면 된다.
		for(int i = 1; i < n + 1; i++) {
			// 바로 왼쪽 탑이 더 크다면
			if(arr[i - 1] >= arr[i])
				ans[i] = i - 1;
			// 아닐 경우, 현재 탑보다 큰 레이저 신호 수신탑을 탐색
			else {
				int idx = i - 1;
				while(idx > 0) {
					if(arr[ans[idx]] < arr[i]) {
						idx = ans[idx];
					}
					else {
						ans[i] = ans[idx];
						break;
					}
				}
			}
		}
		
		for(int i = 1; i < n + 1; i++)
			System.out.print(ans[i] + " ");
	}

}