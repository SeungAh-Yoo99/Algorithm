import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder[][] star = new StringBuilder[N][3];
		for (int i = 0; i < N; i++) {
			star[i][0] = new StringBuilder(); 
			star[i][1] = new StringBuilder(); 
			star[i][2] = new StringBuilder(); 
		}
		star[0][1].append("*");
		star[1][1].append("* *");
		star[2][1].append("*****");
		
		int blank = 5 * (N / 6) + (N / 6 - 1); // 앞 빈 칸의 수
		
		// 앞 빈 칸 추가
		if(N == 3) {
			star[0][0].append("  ");
			star[0][2].append("  ");
			star[1][0].append(" ");
			star[1][2].append(" ");
		}
		for (int i = 0; i < N; i ++) {
			for (int j = 0; j < blank - i; j++) {
				star[i][0].append(" ");
				star[i][2].append(" ");
			}
		}
		
		// 별 추가
		for (int i = 3; i < N; i += i) {
			for (int j = 0; j < i; j++) {
				star[i + j][1].append(star[j][1]);
				for (int k = 0; k < star[i - 1 - j][1].length(); k++) {
					star[i + j][1].append(" ");
				}
				star[i + j][1].append(star[j][1]);
			}
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(star[i][0]);
			sb.append(star[i][1]);
			sb.append(star[i][2] + "\n");
		}
		System.out.println(sb);
	}

}