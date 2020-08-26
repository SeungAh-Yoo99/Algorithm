/*
 1~99까지는 무조건 한수이다.
 100부터는 123, 135, 321과 같이 각 자리수의 차가 동일한 수가 한수이다.
 */
import java.util.*;

public class IO_1065 {
	
	static boolean han(int n) {
		int sub1=n/100-(n%100/10); // 셋째 자리수와 둘째 자리수의 차
		int sub2=(n%100/10)-n%10; // 둘째 자리수와 첫째 자리수의 차
		if (sub1==sub2)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		if (n<100) // 1~99까지는 무조건 한수
			System.out.println(n);
		else {
			int count=99;
			for (int i=100;i<=n;i++) {
				if (han(i)==true)
					count++;
			}
			System.out.println(count);
		}
	}

}