import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();
		
		int tLength = T.length;
		int pLength = P.length;
		
		int[] pi = new int[pLength];
		for (int i = 1, j = 0; i < pLength; i++) {
			while(j > 0 && P[i] != P[j]) j = pi[j - 1];
			
			if(P[i] == P[j]) {
				pi[i] = ++j;
			}
		}
		
		int count = 0; // P가 나타나는 횟수
		StringBuilder sb = new StringBuilder(); // P가 나타나는 위치
		
		for (int i = 0, j = 0; i < tLength; i++) {
			while(j > 0 && T[i] != P[j]) j = pi[j - 1];
			
			if(T[i] == P[j]) {
				if(j == pLength - 1) {
					count++;
					sb.append((i - j + 1) + " ");
					j = pi[j];
				}
				else j++;
			}
		}
		System.out.println(count);
		if(count > 0) System.out.println(sb);
	}

}