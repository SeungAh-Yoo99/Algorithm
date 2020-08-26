public class DP_4673 {
	static int dp[]=new int[10001];
	
	static void d(int n) {
			int num=n;
			for (int i=1;i<=n;i*=10)
				num+=n%(i*10)/i;
			if (num<=10000)
				if (dp[num]==0) {
					dp[num]++;
					d(num);
				}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=1;i<=10000;i++)
			if (dp[i]==0)
				d(i);
		
		for (int i=1;i<=10000;i++)
			if (dp[i]==0)
				System.out.println(i);
	}

}