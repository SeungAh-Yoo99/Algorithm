/*
 2579번과 유사
dp[i-3]+arr[i-1]+arr[i]와 dp[i-2]+arr[i] 중에 큰 것을 비교
둘 중 큰 것을 dp[i]에 넣는다.
그리고 dp[i-1]과 dp[i]을 비교.
만약에 dp[i-1]이 더 크다면 dp[i]을 거치지 않는 것이 더 큰 합일 경우이다.
==>> 처음에 마지막 max 구할 때 for(int i=1;i<=n;i++)로 max를 구했다.
그런데 런타임 에러 뜸 ㅜㅜ
그래서 어차피 전달받는 수들은 다 양수니까 n부터 1까지 max를 찾는게 더 빠를거 같아서 바꿔줌.
잘 돌아간다.
 */
import java.util.*;
public class DP_2156 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int arr[]=new int[10001];
		int dp[]=new int[10001];
		
		for (int i=1;i<=n;i++)
			arr[i]=scan.nextInt();
		
		dp[1]=arr[1];
		dp[2]=dp[1]+arr[2];
		for (int i=3;i<=n;i++) {
			dp[i]=Math.max(dp[i-3]+arr[i-1]+arr[i],dp[i-2]+arr[i]);
			dp[i]=Math.max(dp[i-1], dp[i]);
		}
		
		int max=0;
		for (int i=n;i>0;i--)
			max=Math.max(max, dp[i]);
		System.out.println(max);
	}

}