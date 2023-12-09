import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[][] visited = new boolean[52][52];
		
		// 입력
		int N = Integer.parseInt(br.readLine());
		char[] input;
		char a, b;
		for (int i = 0; i < N; i++) {
			input = br.readLine().toCharArray();
			a = input[0];
			b = input[input.length - 1];
			if(a >= 'A' && a <= 'Z') {
				if(b >= 'A' && b <= 'Z') {
					visited[a - 'A'][b - 'A'] = true;
				}
				else {
					visited[a - 'A'][b - 'a' + 26] = true;
				}
			}
			else {
				if(b >= 'A' && b <= 'Z') {
					visited[a - 'a' + 26][b - 'A'] = true;
				}
				else {
					visited[a - 'a' + 26][b - 'a' + 26] = true;
				}
			}
		}
		
		for (int i = 0; i < 52; i++) {
			for (int j = 0; j < 52; j++) {
				for (int k = 0; k < 52; k++) {
					if(visited[j][i] && visited[i][k]) visited[j][k] = true;
				}
			}
		}
		
		int X = 0;
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				if(i != j && visited[i][j]) {
					X++;
					sb.append((char)(i + 'A') + " => " + (char)(j + 'A') + "\n");
				}
			}
			for (int j = 26; j < 52; j++) {
				if(visited[i][j]) {
					X++;
					sb.append((char)(i + 'A') + " => " + (char)(j - 26 + 'a') + "\n");
				}
			}
		}
		for (int i = 26; i < 52; i++) {
			for (int j = 0; j < 26; j++) {
				if(visited[i][j]) {
					X++;
					sb.append((char)(i - 26 + 'a') + " => " + (char)(j + 'A') + "\n");
				}
			}
			for (int j = 26; j < 52; j++) {
				if(i != j && visited[i][j]) {
					X++;
					sb.append((char)(i - 26 + 'a') + " => " + (char)(j - 26 + 'a') + "\n");
				}
			}
		}
		
		System.out.println(X);
		System.out.println(sb);
	}

}