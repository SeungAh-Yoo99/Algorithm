/*
우선 3kg 봉지보다 5kg 봉지가 더 많을 수록 좋다.
하지만 3kg 봉지를 가져가야만 nkg을 맞출 수 있는 경우가 있다.
그래서 남은 kg이 5의 배수가 될 때까지 3을 빼준다.
하지만 3을 계속 빼도 5의 배수가 되지 않고 음수가 되는 경우에는 5와 3으로 n을 만들 수 없는 경우이다.
이럴 경우에는 -1을 출력해준다.
 */
import java.util.*;

public class IO_2839 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int count=0;
		
		while (n%5!=0) {
			n-=3;
			if (n<0) {
				count=-1;
				break;
			}
			else
				count++;
		}
		
		if (n>0)
			count+=n/5;
		
		System.out.println(count);
	}

}