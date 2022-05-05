import java.util.*;

public class DP_1149 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner (System.in);
		int n=scan.nextInt();
		int color[][]=new int[n+1][3];
		int dp[][]=new int[n+1][3];
		
		for (int i=1; i<=n;i++) {
			color[i][0]=scan.nextInt();
			color[i][1]=scan.nextInt();
			color[i][2]=scan.nextInt();
		}
		
		for (int i=1;i<=n;i++) {
			dp[i][0]=color[i][0]+dp[i-1][1];
			if (dp[i][0]>color[i][0]+dp[i-1][2])
				dp[i][0]=color[i][0]+dp[i-1][2];
			dp[i][1]=color[i][1]+dp[i-1][0];
			if (dp[i][1]>color[i][1]+dp[i-1][2])
				dp[i][1]=color[i][1]+dp[i-1][2];
			dp[i][2]=color[i][2]+dp[i-1][0];
			if (dp[i][2]>color[i][2]+dp[i-1][1])
				dp[i][2]=color[i][2]+dp[i-1][1];
		}
		
		int min=dp[n][0];
		for (int i=1;i<3;i++)
			if (dp[n][i]<min)
				min=dp[n][i];
		
		System.out.println(min);
	}

}