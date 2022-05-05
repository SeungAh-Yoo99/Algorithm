/*
 i-1일까지 일한 돈은 i날에 받는다고 가정한다.
 dp[i]에는 i-1일까지 일한 돈을 저장한다.
 i일에 T_i일 만큼 걸리는 일을 하면
 i+t_i일 부터는 아무일도 안해도 이미 dp[i]+P_i 만큼 번 상태이다.
 따라서 1~n일까지 i일에 T_i일 만큼 일한 금액을 dp[i+T_i]~dp[n+1]까지 저장한다.
 이때 n+1일은 퇴사하는 날로, n일까지 일한 돈을 dp[n+1]에 받는다고 생각한다.
 */
import java.util.*;

public class DP_14501 {

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