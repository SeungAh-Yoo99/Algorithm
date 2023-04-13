import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// N 이하의 소수 구하기
		ArrayList<Integer> prime = new ArrayList<>();
		boolean[] isPrime = new boolean[N + 1];
		Arrays.fill(isPrime, true);
		
		for (int i = 2; i <= N; i++) {
			if(isPrime[i]) {
				prime.add(i);
				for (int j = 2 * i; j <= N; j += i) {
					isPrime[j] = false;
				}
			}
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