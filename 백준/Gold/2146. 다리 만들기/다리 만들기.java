import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] m; // 1과 0으로만 되어있는 맵
	static int[][] map; // 섬의 정보가 섬의 번호로 되어있는 맵
	static int numOfIsland; // 섬의 개수
	static LinkedList<LinkedList<int[]>> edgeLists; // 섬의 테두리 땅 정보를 담아둔 리스트
	static int[] dx = {-1, 1, 0, 0}; // 상하좌우
	static int[] dy = {0, 0, -1, 1};
	static int result = Integer.MAX_VALUE;

	
	private static void numbering() { // 섬에 번호 매기는 메소드
		
		numOfIsland = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == -1) { // 땅이면 bfs
					numOfIsland++;
					edgeLists.add(new LinkedList<>());
					bfs(i, j);
				}
			}
		}
	}
	
	private static void bfs(int x, int y) { // 연결되어 있는 땅을 하나의 섬으로 넘버링 해주는 메소드
		
		map[x][y] = numOfIsland;
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		
		while(!q.isEmpty()) {
			
			int[] p = q.poll();
			
			// 사방탐색 중 처음으로 현재 땅이 테두리라는 것을 알게 되면 true로 바꿔줌
			boolean flag = false;
			
			for (int i = 0; i < 4; i++) { // 사방탐색
				
				int nx = p[0] + dx[i];
				int ny = p[1] + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 체크
					if(map[nx][ny] == -1) { // 땅으로 연결되어 있으면
						map[nx][ny] = numOfIsland; // 같은 번호로 넘버링 해줌
						q.add(new int[] {nx, ny});
					}
					else if(map[nx][ny] == 0 && !flag) { // 현재 땅이 섬의 테두리 부분이라면
						edgeLists.get(numOfIsland).add(p);
						flag = true;
					}
				}
			}
		}
	}
	
	private static void findShortestPath(int num) { // num번 섬의 테두리부터 다른 섬에 가는 길 중 가장 짧은 길 찾기
		
		Queue<int[]> edgeQueue = new LinkedList<>(); // num번 섬의 테두리 리스트
		edgeQueue.addAll(edgeLists.get(num));
		
		int[][] tmpMap = new int[N][N];
		
		int shortestPath = Integer.MAX_VALUE;
		
		/*
		 * 섬의 테두리부터 bfs 시작
		 * 다른 섬의 테두리를 만나는 가장 짧은 길 찾기
		 */
		
		while(!edgeQueue.isEmpty()) {
			int[] p = edgeQueue.poll();
			
			for (int i = 0; i < 4; i++) { // 사방 탐색
				int nx = p[0] + dx[i];
				int ny = p[1] + dy[i];
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 체크
					if(map[nx][ny] > 0 && map[nx][ny] != num) { // p가 섬에 맞닿아 있는 바다면
						shortestPath = Math.min(shortestPath, tmpMap[p[0]][p[1]]);
					}
					else if(m[nx][ny] == 0 && tmpMap[nx][ny] == 0) { // 다음 칸도 바다면
						tmpMap[nx][ny] = tmpMap[p[0]][p[1]] + 1; // 앞으로 나가고
						edgeQueue.add(new int[] {nx, ny});
					}
				}
			}
		}
		
		result = Math.min(result, shortestPath);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		N = Integer.parseInt(br.readLine());
		m = new int[N][N];
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				m[i][j] = Integer.parseInt(st.nextToken());
				if(m[i][j] == 1) map[i][j] = -1; // 섬이라면 섬에 번호를 부여하기 위해 일단 -1로 설정
			}
		}
		
		// 각 섬의 테두리를 담을 리스트
		edgeLists = new LinkedList<>();
		edgeLists.add(null); // 섬의 번호는 1번부터 시작이므로 인덱스 0은 null로
		
		// 섬에 번호 부여
		numbering();
		
		// 각 섬에서 다른 섬으로 가는 최소 길이를 구하고
		// 그 중에서 제일 작은 값을 result에 저장
		for (int i = 1; i <= numOfIsland; i++) {
			findShortestPath(i);
		}
		
		System.out.println(result);
	}

}