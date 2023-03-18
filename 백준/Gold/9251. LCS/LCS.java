import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] first = br.readLine().toCharArray(); // 첫 번째 문자열
		char[] second = br.readLine().toCharArray(); // 두 번째 문자열
		
		int[][] lcs = new int[first.length + 1][second.length + 1];
		
		// lcs 알고리즘으로 최장 공통 부분 수열의 길이 구하기
		int result = 0;
		for (int i = 1; i <= first.length; i++) {
			for (int j = 1; j <= second.length; j++) {
				if(first[i - 1] == second[j - 1]) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
					result = Math.max(result, lcs[i][j]);
				}
				else lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
			}
		}
		
		System.out.println(result);
	}

}