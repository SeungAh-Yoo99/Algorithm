import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int arr[]=new int[n+1];
		int dp[][]=new int [2][n+1];
		
		for (int i=1;i<=n;i++)
			arr[i]=scan.nextInt();
		
		for (int i=1;i<=n;i++) {//dp[0]엔 오른쪽만을 기준으로 한 증가 수열
			for (int j=1;j<i;j++) {
				if (arr[i]>arr[j]) //앞에 오는 수보다 더 큰데
					if (dp[0][i]<=dp[0][j]) //dp 값이 더 작다면
						dp[0][i]=dp[0][j]+1;
			}
			if (dp[0][i]==0) //i를 포함한 앞에 오는 수들 중에서 가장 작다면
				dp[0][i]=1;
		}
		
		for (int i=n;i>0;i--) { //dp[1]엔 왼쪽만을 기준으로 한 감소 수열
			for (int j=n;j>i;j--) {
				if (arr[i]>arr[j]) //뒤에 오는 수보다 더 큰,
					if (dp[1][i]<=dp[1][j]) //dp 값이 더 작다면
						dp[1][i]=dp[1][j]+1;
			}
			if (dp[1][i]==0) //i를 포함한 뒤에 오는 수들 중에서 가장 작다면
				dp[1][i]=1;
		}
		
		int max=0;
		for (int i=1;i<=n;i++) { //가장 큰 dp 값 찾아서 출력
			if (max<dp[0][i]+dp[1][i]-1)
				max=dp[0][i]+dp[1][i]-1;
		}
		System.out.println(max);
	}

}