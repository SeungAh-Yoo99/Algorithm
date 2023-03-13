import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] board;
	static int result;
	
	private static void bfs() {
		
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[101];
		
		q.add(new int[] {1, 0});
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			
			for (int i = 1; i <= 6; i++) {
				int next = p[0] + i;
				if(next == 100) { // 100번 칸에 도착했다면
					result = p[1] + 1;
					return;
				}
				if(next <= 100 && !visited[next]) {
					visited[next] = true;
					if(board[next] == 0) { // 사다리나 뱀이 없는 경우
						q.add(new int[] {next, p[1] + 1});
					}
					else { // 사다리나 뱀이 있는 경우
						q.add(new int[] {board[next], p[1] + 1});
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		board = new int[101]; // 사다리나 뱀이 있다면, 해당 칸에서 이동할 수 있는 칸이 적혀 있는 보드판
		
		// 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N + M; i++) {
			st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		// bfs로 최소 경우 구하기
		bfs();
		
		// 출력
		System.out.println(result);
	}

}