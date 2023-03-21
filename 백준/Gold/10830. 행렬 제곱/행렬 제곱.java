import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] matrix;
	static final int MOD = 1000;
	
	private static int[][] pow(long p) {
		if(p == 0 || p == 1) {
			return matrix;
		}
		
		int[][] tmp = pow(p / 2);
		int[][] result = multiply(tmp, tmp);
		
		if((p & 1) == 1) result = multiply(result, matrix);
		
		return result;
	}
	
	private static int[][] multiply(int[][] mt1, int[][] mt2) {
		
		int[][] result = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					result[i][j] += mt1[i][k] * mt2[k][j];
				}
				result[i][j] %= MOD;
			}
		}
		
		return result;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 행렬 제곱 구하기
		int[][] result = pow(B);
		
		// 답 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result[i][j] %= MOD;
				sb.append(result[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}