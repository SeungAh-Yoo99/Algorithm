import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int L;
	static int[][] arr;
	static int result;
	
	private static void hbg(int idx, int s, int k) {
		if(idx == N) {
			result = result > s ? result : s;
			return;
		}
		
		// 현재 재료 포함 x
		hbg(idx + 1, s, k);
		// 현재 재료 포함 o
		if(k + arr[idx][1] <= L) { // 칼로리 넘지 않을 때만
			hbg(idx + 1, s + arr[idx][0], k + arr[idx][1]);
		}
		
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// T 입력
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			// N, L 입력
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			// N개의 재료 입력
			arr = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// 답 구하기
			result = 0;
			hbg(0, 0, 0);
			
			// 답 자장
			sb.append(result + "\n");
		}
		
		// 출력
		System.out.println(sb);
	}

}