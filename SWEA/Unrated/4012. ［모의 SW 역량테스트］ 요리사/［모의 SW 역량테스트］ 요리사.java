import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] S;
	static int totalS;
	static int[] isA;
	static int result;
	
	private static void cook(int c, int i) {
		isA[c] = i;
		
		if(c == N / 2 - 1) {
			// 시너지 구하기
			int a = 0;
			int b = totalS;
			for (int j = 0; j < N / 2; j++) {
				for (int k = j + 1; k < N / 2; k++) {
					a = a + S[isA[j]][isA[k]] + S[isA[k]][isA[j]];
				}
				b = b - S[isA[j]][N] - S[N][isA[j]];
			}
			b += a;
			
			int tmp = Math.abs(a - b);
			result = result < tmp ? result : tmp;
			return;
		}
		
		for (int j = i + 1; j < N; j++) {
			cook(c + 1, j);
		}
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// T 입력
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			// N 입력
			N = Integer.parseInt(br.readLine());
			// 시너지 값들 입력
			S = new int[N + 1][N + 1];
			totalS = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
					S[N][j] += S[i][j];
					S[i][N] += S[i][j];
					totalS += S[i][j];
				}
			}
			
			// A음식 재료 인덱스
			isA = new int[N / 2];
			
			// 최소 맛의 차이 구하기
			result = (int) 10e9;
			cook(0, 0);
			
			sb.append(result + "\n");
		}
		
		System.out.println(sb);
	}

}