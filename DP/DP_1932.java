/*
dp[i][1]은 dp[i-1][1]일 때만 올 수 있다.
dp[i][i]는 dp[i-1][i-1]일 때만 올 수 있다.
나머지 dp[i][j]는 dp[i-1][j-1]와 dp[i-1][j]일 때 올 수 있다.
더 둘 중 더 큰 값이 온다.
마지막으로 dp[n][1]~dp[n][n] 중 최대값을 출력한다.
 */
 
import java.util.*;

public class DP_1932 {

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