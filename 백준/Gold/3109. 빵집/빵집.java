import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R;
	static int C;
	static char[][] graph;
	
	private static boolean pipe(int x, int y) {
		
		graph[x][y] = '=';
		
		if(y == C - 1) {
			return true;
		}
		
		boolean check = false;
		if(x - 1 >= 0 && graph[x - 1][y + 1] == '.') {
			check = pipe(x - 1, y + 1);
		}
		
		if(!check && graph[x][y + 1] == '.') {
			check = pipe(x, y + 1);
		}
		
		if(!check && x + 1 < R && graph[x + 1][y + 1] == '.') {
			check = pipe(x + 1, y + 1);
		}
		
		if(!check) graph[x][y] = 'x'; // 현재 위치로는 파이프 설치 불가
		return check;
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
		
		for (int i = 0; i < R; i++) {
			pipe(i, 0);
		}
		
		int result = 0;
		for (int i = 0; i < R; i++) {
			if(graph[i][C - 1] == '=') result++;
		}

		// 출력
		System.out.println(result);
	}

}