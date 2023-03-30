import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	final static long MOD = 1_000_000_007;
	
	private static long power(long n, long b) {
		if(n == 0 || n == 1) {
			return b;
		}
		
		long tmp = power(n / 2, b);
		long result = multiply(tmp, tmp);
		if((n & 1) == 1) result = multiply(result, b);
		
		return result;
	}
	
	private static long multiply(long a, long b) {
		return a * b % MOD;
	}

	public static void main(String[] args) throws Exception {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int M = Integer.parseInt(br.readLine()); // 주사위의 수
		
		int[][] dice = new int[M][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			dice[i][0] = Integer.parseInt(st.nextToken());
			dice[i][1] = Integer.parseInt(st.nextToken());
		}
		
		long result = 0;
		for (int i = 0; i < M; i++) {
			long tmp = power(MOD - 2, dice[i][0]) % MOD;
			result += dice[i][1] * tmp % MOD;
			result %= MOD;
		}
		
		System.out.println(result);
	}

}