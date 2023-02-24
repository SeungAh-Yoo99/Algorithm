import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int L;
	static int C;
	static char[] alph;
	static char[] pick;
	
	private static void codeword(int n, int i) {
		if(n == L) { // L개의 문자를 다 골랐다면
			int vowel = 0; // 모음 개수
			int consonant = 0; // 자음 개수
			// 모음이 최소 한 개, 자음이 최소 두 개가 포함되었는지 확인
			for (int j = 0; j < L; j++) {
				if(pick[j] == 'a' || pick[j] == 'e' || pick[j] == 'i'
						|| pick[j] == 'o' || pick[j] == 'u')
					vowel++;
				else consonant++;
			}
			
			// 포함되었다면 출력에 담음
			if(vowel >= 1 && consonant >= 2)
				sb.append(String.valueOf(pick) + "\n");
			
			return;
		}
		
		for (int j = i; j < C; j++) {
			pick[n] = alph[j];
			codeword(n + 1, j + 1);
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// L, C 입력
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		// 문자들 입력 & 정렬
		alph = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alph[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(alph);
		
		// 암호어 L개 고르기
		pick = new char[L];
		codeword(0, 0);
		
		// 출력
		System.out.println(sb);
	}
}