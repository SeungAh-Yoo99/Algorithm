/*
dp[i]에는 arr[i]가 저장되어 있다.
만약 dp[i-1]이 음수라면 dp[i]은 그대로 나두고,
dp[i-1]이 양수라면 dp[i]에 dp[i-1]을 더해준다.
 */
import java.util.Scanner;

public class DP_1912 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int arr[]=new int[n+1];
		long dp[]=new long[n+1];
		
		for (int i=1;i<=n;i++) {//n개의 정수 입력, arr,dp 배열 초기화
			arr[i]=scan.nextInt();
			dp[i]=arr[i];
		}
		
		for (int i=2;i<=n;i++) //연속된 수들이 가장 큰 합을 구하는 과정
			if (dp[i-1]>=0)
				dp[i]+=dp[i-1];
		
		long max=dp[1];
		for (int i=1;i<=n;i++) //가장 큰 dp 값 찾기
			if (max<dp[i])
				max=dp[i];
		System.out.println(max);
	}

}