import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int turn=scan.nextInt();
		long ans[]=new long[turn];
		int n;
		long dp[]=new long[101];
		
		dp[1]=1; dp[2]=1; dp[3]=1;
		for (int i=3;i<=100;i++)
			dp[i]=dp[i-3]+dp[i-2];
		
		for (int t=0;t<turn;t++) {
			n=scan.nextInt();
			ans[t]=dp[n];			
		}
		
		for (int t=0;t<turn;t++)
			System.out.println(ans[t]);
	}

}