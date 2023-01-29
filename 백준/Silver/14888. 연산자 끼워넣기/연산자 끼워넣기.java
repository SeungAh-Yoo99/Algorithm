import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int n;
	static int[] num;
	static int maxNum = (int)-10e9;
	static int minNum = (int)10e9;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// n 입력
		n = Integer.parseInt(br.readLine());
		
		// n개의 수열 입력
		num = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		// 연산자 입력
		int[] operator = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		// 계산
		cul(num[0], 0, operator[0], operator[1], operator[2], operator[3]);
		
		// 출력
		System.out.println(maxNum);
		System.out.println(minNum);
	}

	static void cul(int result, int idx, int sum, int sub, int mul, int div) {
		if(idx < n - 1) {
			// + 연산
			if(sum > 0)
				cul(result + num[idx + 1], idx + 1, sum - 1, sub, mul, div);
			// - 연산
			if(sub > 0)
				cul(result - num[idx + 1], idx + 1, sum, sub - 1, mul, div);
			// - 연산
			if(mul > 0)
				cul(result * num[idx + 1], idx + 1, sum, sub, mul - 1, div);
			// / 연산
			if(div > 0)
				cul(result / num[idx + 1], idx + 1, sum, sub, mul, div - 1);
		}
		
		if(idx == n - 1) {
			maxNum = maxNum > result ? maxNum : result;
			minNum = minNum < result ? minNum : result;
		}
	}
}