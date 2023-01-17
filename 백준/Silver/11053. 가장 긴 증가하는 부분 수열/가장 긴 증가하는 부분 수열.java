import java.util.Scanner;

public class Main {

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
				if (arr[i]>arr[j])
					if(dp[i]<=dp[j])
						dp[i]=dp[j]+1;
				if (dp[i]==0)
					dp[i]=1;
			}
		
		int max=0;
		for (int i=1;i<=n;i++)
			if (max<=dp[i])
				max=dp[i];
		
		System.out.println(max);
	}

}