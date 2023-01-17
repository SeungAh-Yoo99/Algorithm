import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int k=scan.nextInt();
		long dp[][]=new long[n+1][k+1];
		
		for (int i=0;i<=k;i++) //dp[0]는 다 1로 초기화
			dp[0][i]=1;
		for (int i=1;i<=n;i++) { //모든 수는 자기 자신만이 유일한 1를 더해서 자신이 나오는 수다.
			dp[i][1]=1;
			for (int j=2;j<=k;j++) //
				for (int m=i;m>=0;m--)
						dp[i][j]=(dp[i][j]+dp[m][j-1])%1000000000;
		}
		System.out.println(dp[n][k]%1000000000);
	}
}