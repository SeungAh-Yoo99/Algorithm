import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static char[][] video; 
	
	private static String compress(int n, int x, int y) {
		if(n == 1) {
			return String.valueOf(video[x][y]);
		}
		
		String[] v = new String[4];
		v[0] = compress(n / 2, x, y); // 왼쪽 위
		v[1] = compress(n / 2, x, y + n / 2); // 오른쪽 위
		v[2] = compress(n / 2, x + n / 2, y); // 왼쪽 아래
		v[3] = compress(n / 2, x + n / 2, y + n / 2); // 오른쪽 아래
		
		// 값의 길이가 1이고 모두 같으면
		if(v[0].length() == 1 && v[0].equals(v[1]) && v[1].equals(v[2]) && v[2].equals(v[3])) {
			return v[0]; // 하나로 압축해서 리턴
		}
		else // 압축 불가능하면 괄호로 묶어서 리턴
			return "(" + v[0] + v[1] + v[2] + v[3] + ")";
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 영상 크기 입력
		int N = Integer.parseInt(br.readLine());
		// 영상 배열 입력
		video = new char[N][N];
		for (int i = 0; i < N; i++) {
			video[i] = br.readLine().toCharArray();
		}
		
		String result = compress(N, 0, 0);
		
		// 출력
		System.out.println(result);
	}

}
