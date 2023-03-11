import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] arr;
	static int[] result = new int[3];
	
	private static int cutting(int n, int startX, int startY) {
		
		// 마지막까지 잘랐다면
		if(n == 1) return arr[startX][startY];
		
		// 9등분으로 자른 결과 배열에 넣기
		int[] r = new int[9];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				r[3 * i + j] = cutting(n / 3, startX + (n / 3) * i, startY + (n / 3) * j);
			}
		}
		
		for (int i = 1; i < 9; i++) {
			if(r[i] != r[i - 1]) { // 다른 결과가 나왔다면
				for (int j = 0; j < 9; j++) {
					if(r[j] == -1) result[0]++;
					else if(r[j] == 0) result[1]++;
					else if(r[j] == 1) result[2]++;
				}
				return 2; // 다른 숫자가 채워졌다는 의미로 2 리턴
			}
		}
		// 리턴하지 않고 for문을 나온 것은 종이가 같은 수로 채워졌다는 뜻
		return r[0]; // 종이가 어떤 수로 채워졌는지 리턴
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 입력
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int r = cutting(N, 0, 0);
		if(r == -1) result[0]++;
		else if(r == 0) result[1]++;
		else if(r == 1) result[2]++;
		
		// 답 담기
		for (int i : result) {
			sb.append(i + "\n");
		}
		
		// 출력
		System.out.println(sb);
	}

}