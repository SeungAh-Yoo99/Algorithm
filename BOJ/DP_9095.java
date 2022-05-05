import java.util.Scanner;

public class DP_9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner (System.in);
		int numberOfTestCase=scan.nextInt();
		int n;
		int dp[]=new int [11];
		
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		
		for (int i=4;i<=10;i++)
			dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
		
		for (int i=0;i<numberOfTestCase;i++) {
			n=scan.nextInt();
			System.out.println(dp[n]);
		}
	}

}