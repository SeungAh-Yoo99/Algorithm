import java.util.Scanner;

public class DP_2193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		long dp[][]=new long[n+1][2];
		long cases=0;
		
		dp[1][0]=0;
		dp[1][1]=1;
		
		for (int i=2;i<=n;i++) {
			dp[i][0]=dp[i-1][0]+dp[i-1][1];
			dp[i][1]=dp[i-1][0];
		}
		
		cases=dp[n][0]+dp[n][1];
		System.out.println(cases);
	}

}