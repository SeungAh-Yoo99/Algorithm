/*
큰 정수의 합을 출력하기 위해서 Math의 BigInteger를 사용해주었다.
*/

import java.util.Scanner;
import java.math.BigInteger;

public class BOJ_10757 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		String str1 = scan.next();
		String str2 = scan.next();
		
		BigInteger num1 = new BigInteger(str1); 
		BigInteger num2 = new BigInteger(str2);
		
		System.out.println(num1.add(num2));
	}

}
