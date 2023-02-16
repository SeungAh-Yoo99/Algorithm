import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[][] arr;
	static int result;
	
	private static void nemmo(int x, int y) {
		// 마지막 인덱스인 경우
		if(x == N && y == M) {
			// 현재 인덱스에 넴모를 두지 않는 경우는 일단 배치 가능
			result++;
			
			// 현재 인덱스에 넴모를 두는 경우 없앨 수 있는 넴모가 생겼는지 체크
			arr[x][y] = 1;
			if(!check(x, y)) { // 안생겼다면
				result++;
			}
			arr[x][y] = 0;
			return;
		}
		
		// 현재 인덱스에 넴모를 두지 않는 경우
		// 현재 인덱스에 해당하는 배열 값은 유지한 채 다음 칸으로 넘어감
		if(y == M) nemmo(x + 1, 1);
		else nemmo(x, y + 1);
		
		// 현재 인덱스에 넴모를 두는 경우
		arr[x][y] = 1;
		// 현재 인덱스에 넴모를 둠으로써 없앨 수 있는 넴모가 생겼나 체크
		if(check(x, y)) { // 없앨 수 있는 넴모가 생겼으면 return
			arr[x][y] = 0;
			return;
		}
		else { // 아니라면 다음 인덱스로 넘어감
			if(y == M) nemmo(x + 1, 1);
			else nemmo(x, y + 1);
		}
		arr[x][y] = 0;
	}
	
	private static boolean check(int x, int y) { // 현재 인덱스에 넴모를 둠으로써 없앨 수 있는 넴모가 생겼나 체크
		if(arr[x - 1][y - 1] + arr[x - 1][y] + arr[x][y - 1] + arr[x][y] == 4
				|| arr[x - 1][y] + arr[x - 1][y + 1] + arr[x][y] + arr[x][y + 1] == 4
				|| arr[x][y - 1] + arr[x][y] + arr[x + 1][y - 1] + arr[x + 1][y] == 4
				|| arr[x][y] + arr[x][y + 1] + arr[x + 1][y] + arr[x + 1][y + 1] == 4)
			return true; // 없앨 수 있는 넴모가 생겼다면 true
		return false; // 아니라면 false
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N, M 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// N x M 배열
		arr = new int[N + 2][M + 2];
		
		// 넴모 배치 가짓수 구하기
		nemmo(1, 1);
		
		// 답 출력
		System.out.println(result);
	}

}