/*
dp[0]은 몇자리수로 나타내건 1가지는 꼭 가능하다.
dp[n][k]는 패턴을 분석해보면 알겠지만
dp[n][k]=dp[n][k-1]+dp[n-1][k-1]+dp[n-2][k-1]+...+d[1][k-1]+dp[0][k-1]이다.
이 식만 알아내면 쉽게 풀 수 있다.
 */
import java.util.Scanner;

public class DP_2225 {

	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int k=scan.nextInt();
		long dp[][]=new long[n+1][k+1];
		
		for (int i=0;i<=k;i++)
			dp[0][i]=1;
		for (int i=1;i<=n;i++) {
			dp[i][1]=1;
			for (int j=2;j<=k;j++) //
				for (int m=i;m>=0;m--)
						dp[i][j]=(dp[i][j]+dp[m][j-1])%1000000000;
		}
		System.out.println(dp[n][k]%1000000000);
	}
}