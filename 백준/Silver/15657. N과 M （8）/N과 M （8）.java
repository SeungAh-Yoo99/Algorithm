import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb;
	static int N;
	static int M;
	static int[] arr;
	static int[] subArr;
	
	private static void sub(int n, int now) {
		
		if(n == M) {
			for (int i = 0; i < M; i++) {
				sb.append(subArr[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = now; i < N; i++) {
			subArr[n] = arr[i];
			sub(n + 1, i);
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		subArr = new int[M];
		sub(0, 0);
		
		System.out.println(sb);
	}
}