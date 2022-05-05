import java.util.*;

public class DP_11052 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int dp[]=new int[n+1];
		for (int i=1;i<=n;i++)
			dp[i]=scan.nextInt();
		
		for (int i=2;i<=n;i++) {
			for (int j=0;j<=i/2;j++) {
				if (dp[i]<(dp[i-j]+dp[j]))
						dp[i]=dp[i-j]+dp[j];
			}
		}
		System.out.println(dp[n]);
	}

}