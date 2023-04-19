import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dp;
	
	// dp에서 num보다 작은 수 중 제일 큰 수의 인덱스 반환
	private static int search(int start, int end, int num) {
		
		if(start == end) return start;
		
		int mid = (start + end) / 2;
		if(dp[mid] <= num) return search(start, mid, num);
		else return search(mid + 1, end, num);
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// A전봇대에 연결된 전깃줄 기준으로 올림차순 정렬
		Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
		
		// 최장 감소하는 부분수열 구하기
		dp = new int[N + 1];
		int[] index = new int[N];
		int length = 1;
		dp[1] = arr[N - 1][1];
		index[N - 1] = 1;
		for (int i = N - 2; i >= 0; i--) {
			if(arr[i][1] < dp[length]) {
				dp[++length] = arr[i][1];
				index[i] = length;
			}
			else {
				int idx = search(1, length, arr[i][1]);
				dp[idx] = arr[i][1];
				index[i] = idx;
			}
		}
		
		// 없애야 하는 전깃줄의 A위치 구하기 & 출력
		sb.append((N - length) + "\n");
		int idx = length;
		for (int i = 0; i < N; i++) {
			if(index[i] == idx) idx--;
			else sb.append(arr[i][0] + "\n");
		}
		System.out.println(sb);
	}

}
