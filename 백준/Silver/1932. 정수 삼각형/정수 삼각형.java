import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int dp[][]=new int[n+1][n+1];
		
		for (int i=1;i<=n;i++)
			for (int j=1;j<=i;j++)
				dp[i][j]=scan.nextInt();
		
		for (int i=2; i<=n;i++) {
			dp[i][1]+=dp[i-1][1];
			for (int j=2;j<i;j++) {
				if (dp[i-1][j-1]>dp[i-1][j])
					dp[i][j]+=dp[i-1][j-1];
				else
					dp[i][j]+=dp[i-1][j];
			}
			dp[i][i]+=dp[i-1][i-1];
		}
		
		int max=0;
		for (int i=1;i<=n;i++)
			if (max<dp[n][i])
				max=dp[n][i];
		
		System.out.println(max);
	}

}