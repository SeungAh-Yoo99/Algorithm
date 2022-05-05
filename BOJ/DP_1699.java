/*
이거 진짜 왜 계속 틀렸다고 뜨는지 몰라서 개빡쳤었던 문제..
내가 처음 푼 방식은 n이 12라면 12보다 작으면서 가장 큰 제곱수인 9를 빼고 dp에 dp[9]을 더해준뒤,
나머지12에서 9를 뺀 나머지 3의 dp를 더해줬다. dp[12]=dp[9](=1)+dp[3](=3)=4
하지만 12는 dp[12]=dp[4]+dp[4]+dp[4]=3 이렇게 구해줘야 최소값이 나온다....
이거 모르고 계속 왜 틀렸는지 몰라서 혼자 머리 쥐어뜯음.
그래서 해결한 방법이 제곱수 j를 1부터 2, 3, ..., 가장 큰 제곱수까지
dp[i]=dp[i-j*j]+dp[j*j]를 비교해보며 가장 작은 수를 저장해주었다.
이렇게 하면 12를 넣었을 때 정상적으로 3이 나오고
드디어 "맞았습니다!!"가 뜬다.
*/
import java.util.Scanner;

public class DP_1699 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int dp[]=new int[n+1];
		
		for (int i=1;i<=n;i++) {
			dp[i]=i;
			for (int j=1;j*j<=i;j++)
				if (dp[i]>dp[i-j*j]+1)
					dp[i]=dp[i-j*j]+1;
		}
		System.out.println(dp[n]);
	}

}