import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[][] tmpMap;
	static int[][] map;
	static int num;
	static ArrayList<ArrayList<Integer>> bridgeList;
	static int visited;
	static int[] parent;
	static int result = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tmpMap = new int[N][M]; // 땅의 정보를 tmpMap에 저장한다
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tmpMap[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 각 섬을 찾아 번호 매기기
		map = new int[N][M];
		findIsland();
		num--; // num은 섬의 개수
		
		// 각 섬에서 다른 섬으로 갈 수 있는 다리 구하기
		bridgeList = new ArrayList<>();
		for (int i = 0; i <= num; i++) {
			bridgeList.add(new ArrayList<>());
			for (int j = 0; j <= num; j++) {
				bridgeList.get(i).add(10);
			}
		}
		getBridge();
		
		// 각 섬에서 놓을 수 있는 다리 중 최소 길이 구하기
		visited = 0;
		getMin();
		
		// 출력
		for (int i = 1; i <= num; i++) find(i);
		boolean isTrue = true;
		for (int i = 1; i <= num; i++) {
			if(parent[i] != 1) {
				isTrue = false;
				break;
			}
		}
		if(!isTrue) System.out.println(-1);
		else System.out.println(result);
	}
	
	private static void findIsland() { // 섬을 찾아 각 섬에 번호를 메겨줌
		num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tmpMap[i][j] == 1) {
					dfs(i, j);
					num++;
				}
			}
		}
	}
	
	private static void dfs(int x, int y) { // 섬에 번호를 매길 때 사용할 dfs
		
		tmpMap[x][y] = 0; // 방문했다고 체크
		map[x][y] = num; // 번호 매김
		
		// 상하좌우
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		for (int i = 0; i < 4; i++) { // 사방탐색
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < M) { // 범위 체크
				if(tmpMap[nx][ny] == 1) dfs(nx, ny); // 사방에 이어진 땅이 있다면 dfs
			}
		}
	}

	private static void getBridge() { // 다리 구하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] != 0) { // 해당 칸이 섬이라면
					makeBirdge(i, j); // 해당 칸에서 다른 섬에 다리를 놓을 수 있는지 체크
				}
			}
		}
	}
	
	private static void makeBirdge(int x, int y) { // 해당 칸에서 다른 섬에 다리를 놓을 수 있는지 체크하는 메소드
		
		int numberOfIsland = map[x][y]; // 섬의 번호
		
		// 상하좌우
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		for (int i = 0; i < 4; i++) { // 사방탐색
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < M) { // 범위 체크
				if(map[nx][ny] == 0) { // map[x][y]가 섬의 가장자리 부분이었다면
					
					if(i == 0 || i == 1) { // 위, 아래쪽으로 놓을 수 있는 다리가 있는지 체크
						int tmpX = nx;
						while(tmpX >= 0 && tmpX < N && map[tmpX][y] == 0) tmpX += dx[i];
						if(tmpX >= 0 && tmpX < N && Math.abs(x - tmpX) - 1 >= 2 && map[tmpX][y] != numberOfIsland) { // 놓을 수 있는 경우
							int number = map[tmpX][y]; // 다리를 놓을 섬의 번호
							ArrayList<Integer> tmpList = bridgeList.get(numberOfIsland); // 현재 섬에서 놓을 수 있는 다리 정보 리스트 가져오기
							tmpList.set(number, Math.min(tmpList.get(number), Math.abs(x - tmpX) - 1)); // 현재 섬에서 tmpX에 해당하는 섬까지 놓을 수 있는 다리 길이 중 최소값 저장
						}
					}
					
					else { // 왼쪽, 오른쪽으로 놓을 수 있는 다리가 있는지 체크
						int tmpY = ny;
						while(tmpY >= 0 && tmpY < M && map[x][tmpY] == 0) tmpY += dy[i];
						if(tmpY >= 0 && tmpY < M && Math.abs(y - tmpY) - 1 >= 2 && map[x][tmpY] != numberOfIsland) { // 놓을 수 있는 경우
							int number = map[x][tmpY]; // 다리를 놓을 섬의 번호
							ArrayList<Integer> tmpList = bridgeList.get(numberOfIsland); // 현재 섬에서 놓을 수 있는 다리 정보 리스트 가져오기
							tmpList.set(number, Math.min(tmpList.get(number), Math.abs(y - tmpY) - 1)); // 현재 섬에서 tmpY에 해당하는 섬까지 놓을 수 있는 다리 길이 중 최소값 저장
						}
					}
				}
			}
		}
	}
	
	private static void getMin() { // 가능한 다리의 최소값 구하는 메소드
		
		parent = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			parent[i] = i;
		}
		
		int dis = 2;
		while(dis <= 8) {
			for (int i = 1; i <= num; i++) {
				ArrayList<Integer> list = bridgeList.get(i);
				for (int j = 1; j <= num; j++) {
					// i, j 섬이 연결되지 않았다면
					if(list.get(j) == dis && !union(i, j)) {
						result += dis;
					}
				}
			}
			dis++;
		}
	}
	
	private static boolean union(int p1, int p2) {
		p1 = find(p1);
		p2 = find(p2);
		
		if(p1 == p2) return true;
		else {
			if(p1 < p2) parent[p2] = p1;
			else parent[p1] = p2;
			return false;
		}
	}
	
	private static int find(int p) {
		if(parent[p] == p) return p;
		else return parent[p] = find(parent[p]);
	}
}