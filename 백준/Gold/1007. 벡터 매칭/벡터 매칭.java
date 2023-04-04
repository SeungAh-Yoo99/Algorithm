import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] arr;
	static boolean[] startPoint;
	static double result;
	
	private static void subset(int idx, int count) { // 벡터의 시작 점을 고르는 메소드
		
		if(idx == N) {
			if(count == N / 2) { // 딱 절반 골랐을 경우에만 벡터를 구해줌
				double r = getVector();
				result = Math.min(result, r);
			}
			return;
		}
		
		// idx가 시작점인 경우
		startPoint[idx] = true;
		subset(idx + 1, count + 1);
		// idx가 끝점인 경우
		startPoint[idx] = false;
		subset(idx + 1, count);
	}
	
	private static double getVector() {
		
		int x = 0;
		int y = 0;
		
		for (int i = 0; i < N; i++) {
			if(startPoint[i]) { // 시작점이면 빼줌
				x -= arr[i][0];
				y -= arr[i][1];
			}
			else { // 끝점이면 더해줌
				x += arr[i][0];
				y += arr[i][1];
			}
		}
		
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			startPoint = new boolean[N];
			result = Double.MAX_VALUE;
			
			subset(0, 0);
			
			sb.append(result + "\n");
		}
		
		System.out.println(sb);
	}

}