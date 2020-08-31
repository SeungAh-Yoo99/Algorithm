/*
[그림 1]
그림의 1번에서 출발할 경우 7, 8번으로 밖에 가지 못한다.
물론 2, 6번 외의 모든 곳으로 갈 수 있지만,
7, 8번을 통해서 갈 수 있는 곳들이다.
7, 8번을 통해서 갈 수 있는 곳들은 굳이 저기로 바로 가지 않고 통해서 가는 것이 더 큰 합을 가질 수 있다.

위의 내용을 통해 아래의 결과가 나온다.
arr[0][i]에서 출발할 경우, arr[1][i+1], arr[1][i+2]로 갈 수 있다.
arr[1][i]에서 출발할 경우, arr[0][i+1], arr[0][i+2]로 갈 수 있다.
arr[0][1]~arr[0][n-1]까지 dp[0][i]에서 출발하여 dp[1][i+1]나 dp[1][i+2]에 도착했을 때,
현재 dp[1][i+1]나 dp[1][i+2]의 값이 dp[0][i]+arr[1][i+1 or i+2]의 값보다 작으면
dp[1][i+1 or i+2]=dp[0][i]+arr[1][i+1 or i+2]해준다. 
dp[1]도 dp[0]와 같은 연산을 해준다.
 */
import java.util.Scanner;

public class DP_9465 {

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