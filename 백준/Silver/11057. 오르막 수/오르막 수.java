import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int dp[][]=new int[n+1][10];
		
		for (int i=0;i<10;i++)
			dp[1][i]=1;
		
		for (int i=2;i<=n;i++)
			for (int j=0;j<10;j++)
				for (int k=j;k<10;k++)
					dp[i][j]+=(dp[i-1][k])%10007;
		
		int cases=0;
		for (int i=0;i<10;i++)
			cases+=dp[n][i];
		cases%=10007;
		System.out.println(cases);
	}

}