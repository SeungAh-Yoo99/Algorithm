import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int gcd(int a, int b) { // 최대공약수 구하는 메소드
		if(a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		
		return a;
	}
	
	private static int lcm(int a, int b) { // 최소공배수 구하는 메소드
		return a * b / gcd(a, b);
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			// 입력
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// M, N의 최소공배수 구하기
			int mnLCM = lcm(M, N);
			
			// 1부터 M. N의 최소공배수만큼 보며 나머지가 x, y와 같은 수 구하기
			boolean flag = false; // 답을 구했다면 true;
			int num = x;
			while (num <= mnLCM) {
				
				if((num % N == y || (y == N && num % N == 0))) {
					flag = true;
					sb.append(num + "\n");
					break;
				}
				
				num += M;
				
			}
			// 답을 구하지 못했다면 -1 저장
			if(!flag) sb.append("-1\n");
		}
		
		// 출력
		System.out.println(sb);
	}

}