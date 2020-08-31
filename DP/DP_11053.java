import java.util.Scanner;

public class DP_11053 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int arr[]=new int [n+1];
		int dp[]=new int [n+1];
		
		for (int i=1;i<=n;i++)
			arr[i]=scan.nextInt();
		
		dp[1]=1;
		for (int i=1;i<=n;i++)
			for (int j=1;j<i;j++) { 
				if (arr[i]>arr[j]) //앞에 오는 수보다 더 큰데,
					if(dp[i]<=dp[j]) //dp 값이 더 작으면
						dp[i]=dp[j]+1;
				if (dp[i]==0) //i를 포함한 앞에 오는 수들 중에 가장 작다면
					dp[i]=1;
			}
		
		int max=0;
		for (int i=1;i<=n;i++) //가장 큰 dp 값 찾아서 출력
			if (max<=dp[i])
				max=dp[i];
		
		System.out.println(max);
	}

}