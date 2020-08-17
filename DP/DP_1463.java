import java.util.Scanner;

public class DP_1463 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int dp[]=new int[n+1]; //index 1~n까지 사용 (index 0은 무시)
		
		for (int i=1;i<=n;i++) { //i가 1부터 n까지 1씩 증가하며 반복
			if (i+1<=n) { // +1을 하는 경우 (n을 넘어가면 안된다.)
				if (dp[i+1]==0) //i+1한 곳에 아직 한 번도 접근하지 않았다면
					dp[i+1]=dp[i]+1; //dp[i]에서 +1
				else //이미 이곳에 접근한 적이 있다면
					if (dp[i+1]>=dp[i]+1) //더 최단거리로 접근했을 때의 수를 저장
						dp[i+1]=dp[i]+1;
			}
			if (i*2<=n) { //*2를 하는 경우 (n을 넘어가면 안된다.)
				if (dp[i*2]==0)
					dp[i*2]=dp[i]+1;
				else
					if (dp[i*2]>=dp[i]+1)
						dp[i*2]=dp[i]+1;
			}
			if (i*3<=n) { //*3을 하는 경우 (n을 넘어가면 안된다.)
				if (dp[i*3]==0)
					dp[i*3]=dp[i]+1;
				else
					if (dp[i*3]>=dp[i]+1)
						dp[i*3]=dp[i]+1;
			}
		}
		System.out.println(dp[n]);
	}

}
