import java.util.*;
public class Main {

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