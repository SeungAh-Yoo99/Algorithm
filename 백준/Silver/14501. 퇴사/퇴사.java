import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int t[]=new int[n+1];
		int p[]=new int[n+1];
		int dp[]=new int[n+2]; //dp[n+1]에는 최종으로 받는 최대 금액이 저장된다.
		
		for (int i=1;i<=n;i++) {
			t[i]=scan.nextInt();
			p[i]=scan.nextInt();
		}
		
		int index;
		for (int i=1;i<=n;i++) {
			index=i+t[i];
			if (index<=n+1) //n+1보다 크다면 n일 안에 다 못끝내는 일.
				for (int j=n+1;j>=index;j--)
					if (dp[j]<p[i]+dp[i])
						dp[j]=p[i]+dp[i];
		}
		
		System.out.println(dp[n+1]);
	}

}