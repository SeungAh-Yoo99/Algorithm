import java.util.*;

public class IO_2775 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int arr[] = new int[t];
		
		for (int i=0; i<t; i++) {
			int k = scan.nextInt(); // 층
			int n = scan.nextInt(); // 호
			int dp[][] = new int[k+1][n+1];
			
			for (int j=1; j<=n; j++)
				dp[0][j] = j;
			
			for (int j=1; j<=k; j++) {
				for (int l=1; l<=n; l++)
					dp[j][l] = dp[j][l-1]+dp[j-1][l];
			}
			arr[i] = dp[k][n];
		}
		
		for (int i=0; i<t; i++)
			System.out.println(arr[i]);
	}

}