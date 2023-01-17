import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		String n=scan.next();
		int c[]=new int[n.length()+1];
		int dp[]=new int[n.length()+1];
		int ans=-1; //일단 ans은 -1로 초기화 해둔다.
		dp[0]=1;
		
		for (int i=1;i<=n.length();i++)
			c[i]=n.charAt(i-1)-'0';
		
		if (c[1]==0) //처음이 0이면 암호 해석 불가능.
			ans=0;
		else {
			dp[1]=1;
			for (int i=2;i<=n.length();i++) {
				if (c[i]==0) { //i번째 숫자가 0이라면,
					if((c[i-1]>0)&&(c[i-1]<3)) //i-1번째 숫자가 1,2일때만 암호 해석 가능. (10, 20일 때)
						dp[i]=dp[i-2];
					else { //i-1번째 숫자가 1,2가 아니면,
						ans=0; //암호 해석 불가능.
						break;
					}
				}
				else { //i번째 수가 1~9일 때,
					if (c[i-1]==1) //i-1번째 수가 1이면 (11~19일 때)
						dp[i]=(dp[i-1]+dp[i-2])%1000000;
					else if ((c[i-1]==2)&&(c[i]>=1)&&(c[i]<=6)) //(21~26일 때)
						dp[i]=(dp[i-1]+dp[i-2])%1000000;
					else //i-1번째 수와 i번째 수가 합쳐서 11~26이 안될때
						dp[i]=dp[i-1];
				}
			}
		}
		if (ans!=0) //ans가 이미 0이라면 암호 해석 불가능.
			ans=dp[n.length()];
		System.out.println(ans);
	}

}