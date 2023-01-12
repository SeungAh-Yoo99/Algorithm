public class BOJ_2004 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		int nm = n - m;
		
		int cnt2 = get(n, 2) - get(m, 2) - get(nm, 2);
		int cnt5 = get(n, 5) - get(m, 5) - get(nm, 5);
		
		int ans = cnt2 < cnt5 ? cnt2 : cnt5;
		
		System.out.println(ans);
	}
	
	static int get(int num, int k) {
		int cnt = 0;
		
		while(num >= k) {
			cnt += num / k;
			num /= k;
		}
		
		return cnt;
	}

}