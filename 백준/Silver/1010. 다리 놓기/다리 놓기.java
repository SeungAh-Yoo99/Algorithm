import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	
	static BigInteger[] fac = new BigInteger[30];
	
	private static void factorial() {
		
		fac[0] = new BigInteger("1");
		for (int i = 1; i < 30; i++) {
			fac[i] = new BigInteger(String.valueOf(i)).multiply(fac[i - 1]);
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		factorial();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(fac[M].divide(fac[N].multiply(fac[M - N])) + "\n");
		}
		System.out.println(sb);
	}

}