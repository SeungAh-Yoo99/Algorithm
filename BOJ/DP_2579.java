import java.util.*;

public class DP_2579 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int arr[]=new int[n+1];
		long dp[]=new long[n+1];
		
		for (int i=1;i<=n;i++)
			arr[i]=scan.nextInt();
		
		dp[1]=arr[1];
		if (n>=2)
			dp[2]=dp[1]+arr[2];
		for (int i=3;i<=n;i++) {
			dp[i]=Math.max(dp[i-2]+arr[i],dp[i-3]+arr[i-1]+arr[i]);
		}
		System.out.println(dp[n]);
	}

}