import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static final long MOD = 1_000_000_007;
	
	private static long pow(long a, long n) {
		if(n == 0 || n == 1) {
			return a;
		}
		
		long tmp = pow(a, n / 2);
		
		long result = (tmp * tmp) % MOD;
		if((n & 1) == 1) result = (result * a) % MOD;
		
		return result;
	}

	public static void main(String[] args) throws Exception {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long K = Long.parseLong(st.nextToken());
		
		// (N! / (N - k)!) % MOD 구하기
		long result = 1;
		for (long i = N; i > N - K; i--) {
			result = (result * i) % MOD;
		}
		
		// K! 역원 구하기
		long tmp = 1;
		for (long i = 2; i <= K; i++) {
			tmp = (tmp * i) % MOD;
		}
		tmp = pow(tmp, MOD - 2);
		result = (result * tmp) % MOD;
		
		System.out.println(result);
	}

}