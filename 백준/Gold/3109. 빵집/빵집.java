import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R;
	static int C;
	static char[][] graph;
	
	private static boolean pipe(int x, int y) {
		
		graph[x][y] = '='; // 현재 위치는 파이프 설치 가능한 위치이므로 파이프 설치
		
		if(y == C - 1) { // 마지막 열까지 왔다면 파이프 설치 성공한 것이므로
			return true; // true 리턴
		}
		
		boolean check = false;
		if(x - 1 >= 0 && graph[x - 1][y + 1] == '.') { // 오른쪽 위 대각선에 파이프 놓을 수 있는 위치면
			check = pipe(x - 1, y + 1); // 오른쪽 위 대각선 위치로 재귀
		}
		
		if(!check && graph[x][y + 1] == '.') { // 오른쪽 위치에 파이프 놓을 수 있다면
			check = pipe(x, y + 1); // 오른쪽 위치로 재귀
		}
		
		if(!check && x + 1 < R && graph[x + 1][y + 1] == '.') { // 오른쪽 아래 대각선 위치로 파이프 놓을 수 있다면
			check = pipe(x + 1, y + 1); // 오른쪽 아래 대각선 위치로 재귀
		}
		
		if(!check) graph[x][y] = 'x'; // 위 조건을 모두 만족하지 못하므로 현재 위치에는 파이프 설치 불가
		return check; // 설치 여부 리턴
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// R, C 입력
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		// 빵집 근처의 모습 입력
		graph = new char[R][C];
		for (int i = 0; i < R; i++) {
			graph[i] = br.readLine().toCharArray();
		}
		
		// 0 ~ R - 1 행부터 시작
		for (int i = 0; i < R; i++) {
			pipe(i, 0);
		}
		
		// 마지막 열의 파이프 개수 확인
		int result = 0;
		for (int i = 0; i < R; i++) {
			if(graph[i][C - 1] == '=') result++;
		}

		// 출력
		System.out.println(result);
	}

}
