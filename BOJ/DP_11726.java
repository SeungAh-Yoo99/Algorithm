import java.util.Scanner;

public class DP_11726 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();

		int dp[]=new int[n+1];
		dp[0]=1;
		dp[1]=1;
		for (int i=2;i<=n;i++) {
			dp[i]=dp[i-1]+dp[i-2];
			dp[i]%=10007; //int타입의 데이터 범위가 벗어나는 것을 방지
		}
		System.out.println(dp[n]);
	}

}