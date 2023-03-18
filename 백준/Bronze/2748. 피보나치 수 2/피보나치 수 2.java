import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		BigInteger first = new BigInteger("0");
		BigInteger second = new BigInteger("1");
		
		BigInteger result = new BigInteger("1");
		for (int i = 2; i <= n; i++) {
			result = first.add(second);
			first =  second;
			second = result;
		}
		
		// 출력
		System.out.println(result);
	}

}