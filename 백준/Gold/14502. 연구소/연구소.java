import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[][] map;
	static int[][] tmpMap;
	static ArrayList<int[]> emptyList;
	static ArrayList<int[]> virusList;
	static int[][] pick;
	static int result;
	
	private static void pick3(int n, int last) {
		
		if(n == 3) { // 3개 다 고른 경우 시뮬 돌리기
			simulation();
			return;
		}
		
		
		for (int i = last + 1; i < emptyList.size(); i++) {
			pick[n][0] = emptyList.get(i)[0];
			pick[n][1] = emptyList.get(i)[1];
			pick3(n + 1, i);
		}
	}
	
	private static void simulation() {
		
		// 맵 딥카피
		for (int i = 0; i < N; i++) {
			tmpMap[i] = map[i].clone();
		}
		
		// 고른 3개의 벽을 1로 바꿔주기
		for (int i = 0; i < 3; i++) {
			tmpMap[pick[i][0]][pick[i][1]] = 1;
		}
		
		// 바이러스 퍼뜨리기
		int spreadCount = 0;
		for (int i = 0; i < virusList.size(); i++) {
			spreadCount += bfs(virusList.get(i));
		}
		
		result = Math.max(result, emptyList.size() - spreadCount - 3);
	}
	
	private static int bfs(int[] p) {
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		Queue<int[]> q = new LinkedList<>();
		q.add(p);
		
		int count = 0; // 바이러스 퍼트린 개수
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(tmpMap[nx][ny] == 0) {
						tmpMap[nx][ny] = 2;
						count++;
						q.add(new int[] {nx, ny});
					}
				}
			}
		}
		
		return count;
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		tmpMap = new int[N][M];
		emptyList = new ArrayList<>(); // 빈 칸 리스트
		virusList = new ArrayList<>(); // 바이러스 리스트
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) emptyList.add(new int[] {i, j});
				else if(map[i][j] == 2) virusList.add(new int[] {i, j});
			}
		}
		
		// 벽 3개를 세울 수 있는 모든 경우에 대해 시뮬 돌려보고 최대값 찾기
		pick = new int[3][2];
		pick3(0, -1);
		
		// 출력
		System.out.println(result);
	}
}