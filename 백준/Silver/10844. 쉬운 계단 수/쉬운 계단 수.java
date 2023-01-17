import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		long dp[][]=new long[n+1][10];
		long cases=0;
				
		for (int i=1;i<10;i++)
			dp[1][i]=1;
		
		for (int i=2;i<=n;i++) {
			dp[i][0]=dp[i-1][1]%1000000000;
			for (int j=1;j<9;j++)
				dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
			dp[i][9]=dp[i-1][8]%1000000000;
		}
		for (int i=0;i<10;i++)
			cases+=dp[n][i];
		cases%=1000000000;
		System.out.println(cases);
	}

}