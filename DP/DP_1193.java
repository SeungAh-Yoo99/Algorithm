/*
dp1에는 분자를, dp2에는 분모이다.
dp1은 처음에는 1, 다음에는 1부터 2, 3부터 1, 1부터 4, 5부터 1, 1부터 6 ...과 같은 반복 형태를 보인다.
dp2는 처음에는 1, 다음에는 3-dp1, 4-dp1, 5-dp1, 6-dp1, 7-dp1이다.

위와 같은 규칙으로 부터 구조를 조건문을 사용하여 구조를 잡았다.
우선 dp1[i]가 1이면(이전 반복에서 1로 끝났다면), dp1은 다시 1부터 n까지가 연속으로 저장된다.
반면 dp1[i]가 1이 아닌 다른 수(2, 4, 6 ...)로 끝났다면, dp1은 그 다른 수 +1(2일 때 3, 4일 때 5, 6일 때 7 ...)부터 1까지가 연속으로 저장된다.
 */
import java.util.Scanner;

public class DP_1193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int dp1[] = new int[x+1]; // 분자 저장
		int dp2[] = new int[x+1]; // 분모 저장
		int sum = 2; // 분자와 분모의 수를 합친 수에서 -1
		dp1[1]=1; dp2[1]=1;
		
		for (int i=1; i<=x; i+=sum-1) {
			for (int j=1; j<=sum && i+j<=x; j++) {
				if (dp1[i]==1) {
					if (j==1) {
							dp1[i+j]=1;
							dp2[i+j]=sum+1-dp1[i+j];
					}
					else {
						dp1[i+j]=dp1[i+j-1]+1;
						dp2[i+j]=sum+1-dp1[i+j];
					}
				}
				else {
					if (j==1) {
						dp1[i+j]=sum;
						dp2[i+j]=sum+1-dp1[i+j];
					}
					else {
						dp1[i+j]=dp1[i+j-1]-1;
						dp2[i+j]=sum+1-dp1[i+j];
					}
				}
			}
			sum++;
		}
		System.out.println(dp1[x]+"/"+dp2[x]);
	}

}