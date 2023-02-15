import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 색종이의 수 N 입력
		int N = Integer.parseInt(br.readLine());
		
		// 도화지
		boolean[][] p = new boolean[100][100];
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					if(!p[x + j][y + k]) {
						p[x + j][y + k] = true;
						count++;
					}
				}
			}
		}
		
		// 출력
		System.out.println(count);
	}

}