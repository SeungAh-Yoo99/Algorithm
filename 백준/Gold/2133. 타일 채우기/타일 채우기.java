import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int dp[]=new int[31];
		
		dp[0]=1;
		dp[2]=3;
		int mul=0;
		for (int i=4;i<=30;i+=2) {
			dp[i]+=dp[i-2]*dp[2];
			mul+=dp[i-4]*2;
			dp[i]+=mul;
		}
		int n=scan.nextInt();
		System.out.println(dp[n]);
	}

}