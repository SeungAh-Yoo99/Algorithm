import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static StringBuilder sb;
	static int N;
	static int[] pn = {2, 3, 5, 7}; // 한자리 소수
	
	private static void prime(int num, int count) { // 소수 num, num의 자릿수 count
		if(count == N) { // N자리수까지 찾았다면
			sb.append(num + "\n"); // 답 담아주고
			return; // 리턴
		}
		
		for (int i = 0; i <= 9; i++) {
			int nextNum = num * 10 + i; // 인자로 받은 수에 다른 수를 결합하고
			if(primeNumber(nextNum)) prime(nextNum, count + 1); // 결합한 수가 소수라면 재귀호출
		}
	}
	
	private static boolean primeNumber(int num) { // 2자리 이상 수가 소수인지 판별하는 메소드
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) return false;
		}
		return  true;
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		// N 입력
		N = Integer.parseInt(br.readLine());
		
		// 한자리 소수들 pn에 대하여 prime 메소드 호출
		for (int i = 0; i < pn.length; i++) {
			prime(pn[i], 1);
		}
		
		// 출력
		System.out.println(sb);
	}

}