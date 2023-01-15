import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_15829 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int l = scan.nextInt();
		String s = scan.next();
		BigInteger result = new BigInteger("0");
		
		// 시그마
		for(int i = 0; i < l; i++) {
			result = result.add(BigInteger.valueOf(s.charAt(i) - 96).multiply(BigInteger.valueOf(31).pow(i)));
		}
		
		// mod
		result = result.remainder(BigInteger.valueOf(1234567891));
		
		System.out.println(result);
	}

}