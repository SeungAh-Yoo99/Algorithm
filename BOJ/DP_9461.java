/*
험난한 DP 문제들을 풀던 중 만난 단비 같은 문제ㅎ
처음 문제 딱 들어가자마자 도형이 나와서 당황했지만, 문제에 은근히 발견하기 쉬운 패턴이 있어서 다행이었다.
우선 dp[0]=0, dp[1]=1, dp[2]=1는 주어졌고
dp[3]부터는 dp[i]=dp[i-3]+dp[i-2]라는 규칙이 있는 것을 알 수 있다.
따라서 이 식을 사용하여 문제를 풀면 됨.
==>> dp와 arr의 자료형이 long인것에 주의!!
(int형은 크기가 작아서 안됨.)
*/
import java.util.Scanner;
public class DP_9461 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int turn=scan.nextInt();
		long ans[]=new long[turn];
		int n;
		long dp[]=new long[101];
		
		dp[1]=1; dp[2]=1; dp[3]=1;
		for (int i=3;i<=100;i++)
			dp[i]=dp[i-3]+dp[i-2];
		
		for (int t=0;t<turn;t++) {
			n=scan.nextInt();
			ans[t]=dp[n];			
		}
		
		for (int t=0;t<turn;t++)
			System.out.println(ans[t]);
	}

}