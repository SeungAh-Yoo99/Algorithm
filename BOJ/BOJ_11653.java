/*
처음에는 소수를 구해야 한다고 생각했다.
그런데 따로 소수를 구해주지 않아도 된다.
2로 나눌 수 있을 때까지 나눠주고, 그다음 3을 나눠주면 4를 나눌 차례가 되었을 때 어차피 2로 나눌 수 있을 때까지 나눠주었기 때문에 더 이상 나눌 수 없어 5로 넘어가게 된다.
이렇게 2부터 순서대로 나눠주면 따로 소수를 구할 필요 없이 소인수분해를 할 수 있다. 
*/

import java.util.Scanner;

public class BOJ_11653 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int i = 2;
		
		while(i <= n) {
			if (n%i == 0) {
				System.out.println(i);
				n = n/i;
			}
			else
				i++;
		}
	}

}
