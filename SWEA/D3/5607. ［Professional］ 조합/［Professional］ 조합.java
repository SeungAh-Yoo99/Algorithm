import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static final long MOD = 1_234_567_891;
	
	private static long fact(long start, long end) {
		
		long result = 1;
		
		for (long i = start; i <= end; i++) {
			result = (result * i) % MOD;
		}
		
		return result;
	}
	
	private static long pow(long num, long e) {
		if(e == 0 || e == 1) {
			return num;
		}
		
		long tmp = pow(num, e / 2);
		
		long result = (tmp * tmp) % MOD;
		if((e & 1) == 1) result = (result * num) % MOD;
		
		return result;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			long N = Long.parseLong(st.nextToken());
			long R = Long.parseLong(st.nextToken());
			
			// (N! / (N - R)!) % MOD 구하기
			long result = fact(N - R + 1, N);
			
			// R! % MOD의 역원 구하기
			long div = pow(fact(2, R), MOD - 2);
			
			// 두 연산 곱
			result = (result * div) % MOD;
			sb.append("#" + tc + " " + result + "\n");
		}
		
		System.out.println(sb);
	}

}