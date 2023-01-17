import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int turn=scan.nextInt();
		int ans[]=new int[turn+1];
		for (int t=1;t<=turn;t++) {
			int n=scan.nextInt();
			int arr[][]=new int[2][n+1];
			int dp[][]=new int[2][n+1];
			
			for (int i=0;i<2;i++)
				for (int j=1;j<=n;j++)
					arr[i][j]=scan.nextInt();
			
			dp[0][1]=arr[0][1];
			dp[1][1]=arr[1][1];
			for (int i=1;i<=n-1;i++) {
				if (i+1<=n)
					if (dp[1][i+1]<arr[1][i+1]+dp[0][i])
						dp[1][i+1]=arr[1][i+1]+dp[0][i];
				if (i+2<=n)
					if (dp[1][i+2]<arr[1][i+2]+dp[0][i])
						dp[1][i+2]=arr[1][i+2]+dp[0][i];
				if (i+1<=n)
					if (dp[0][i+1]<arr[0][i+1]+dp[1][i])
						dp[0][i+1]=arr[0][i+1]+dp[1][i];
				if (i+2<=n)
					if (dp[0][i+2]<arr[0][i+2]+dp[1][i])
						dp[0][i+2]=arr[0][i+2]+dp[1][i];
			}
			
			int max=0;
			for (int i=1;i<=n;i++) {
				if (max<dp[0][i])
					max=dp[0][i];
				if (max<dp[1][i])
					max=dp[1][i];
			}
			ans[t]=max;
		}
		for (int t=1;t<=turn;t++)
			System.out.println(ans[t]);
	}

}