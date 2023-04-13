import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static ArrayList<Integer> prime;
	
	private static boolean isPrime(int num) {
		
		for (int i = 2; i <= Math.sqrt(num) + 1; i++) {
			if(num % i == 0) return false;
		}
		
		return true;
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// N 이하의 소수 구하기
		prime = new ArrayList<>();
		prime.add(2);
		for (int i = 3; i <= N; i++) {
			if(isPrime(i)) prime.add(i);
		}
		
		int start = prime.size() - 1;
		int end = prime.size() - 1;
		int sum = 0;
		
		int result = 0;
		while(start >= 0) {
			
			if(sum >= N) sum -= prime.get(end--);
			else sum += prime.get(start--);
			
			if(sum == N) result++;
		}
		
		System.out.println(result);
	}

}