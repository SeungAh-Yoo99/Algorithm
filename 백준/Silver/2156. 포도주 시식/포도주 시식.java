import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int arr[]=new int[10001];
		int dp[]=new int[10001];
		
		for (int i=1;i<=n;i++)
			arr[i]=scan.nextInt();
		
		dp[1]=arr[1];
		dp[2]=dp[1]+arr[2];
		for (int i=3;i<=n;i++) {
			dp[i]=Math.max(dp[i-3]+arr[i-1]+arr[i],dp[i-2]+arr[i]);
			dp[i]=Math.max(dp[i-1], dp[i]);
		}
		
		int max=0;
		for (int i=n;i>0;i--)
			max=Math.max(max, dp[i]);
		System.out.println(max);
	}

}