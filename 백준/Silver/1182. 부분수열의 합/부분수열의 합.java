import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int S;
	static int[] arr;
	static int count;
	static int result;
	
	private static void subSet(int c, int subSum) {
		if(c == N) {
			if(subSum == S && count != 0) result++;
			return;
		}
		
		subSet(c + 1, subSum); // 포함 x
		count++;
		subSet(c + 1, subSum + arr[c]); // 포함 o
		count--;
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N, S 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		// 정수 입력
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 부분 수열 구하기
		subSet(0, 0);
		
		// 출력
		System.out.println(result);
	}

}