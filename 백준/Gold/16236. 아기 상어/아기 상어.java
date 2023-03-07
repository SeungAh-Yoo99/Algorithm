import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] map;
	static int[][] tmpMap;
	static ArrayList<ArrayList<int[]>> fishList;
	static ArrayList<int[]> canEatFishList;
	static int[] shark;
	static int sharkSize;
	static int eating;
	static int time;
	
	private static boolean play() { // 상어가 물고기를 먹으러 가는 매소드
		
		// 상어가 먹을 수 있는 물고기 개수 구하기
		canEatFishList = new ArrayList<>(); // 상어가 먹을 수 있는 물고기 리스트
		int bound = Math.min(7, sharkSize);
		for (int i = 1; i < bound; i++) { // 상어 크기보다 작은 크기의 물고기 리스트 중에서
			for (int j = 0; j < fishList.get(i).size(); j++) {
				int[] fish = fishList.get(i).get(j);
				if(map[fish[0]][fish[1]] == i) { // 아직 살아 있다면 상어가 먹을 수 있는 물고기 리스트에 담아줌
					canEatFishList.add(fish); // [x좌표, y좌표]
				}
			}
		}
		
		if(canEatFishList.size() == 0) { // 더 이상 먹을 수 있는 물고기가 없는 경우
			return false;
		}
		else { // 먹을 수 있는 물고기가 있는 경우
			return eatFish();
		}

	}
	
	private static boolean eatFish() { // 어느 물고기를 먹을 건지 고르고 잡아먹기
		
		// 현재 상어 위치에서 갈 수 있는 각 자리 별 거리 구하기
		getDistance();
		
		int minDis = N * N; // 현재 상어가 잡아 먹으러 갈 수 있는 물고기 중 가장 가까운 거리
		int[] eatfishInfo = {-1, -1}; // 상어가 잡아 먹을 물고기 정보
		
		for (int i = 0; i < canEatFishList.size(); i++) {
			int[] fish = canEatFishList.get(i);
			
			if(tmpMap[fish[0]][fish[1]] > 1) {
				if(tmpMap[fish[0]][fish[1]] == minDis) { // 최소 거리가 같으면
					if(eatfishInfo[0] == fish[0]) { // 같은 row에 있으면
						if(eatfishInfo[1] > fish[1]) { // 가장 왼쪽에 있는 물고기를 골라준다.
							eatfishInfo = fish;
						}
					}
					else if(eatfishInfo[0] > fish[0]) { // 더 위에 있다면
						eatfishInfo = fish;
					}
				}
				else if(tmpMap[fish[0]][fish[1]] < minDis) { // 거리가 더 짧은 경우
					minDis = tmpMap[fish[0]][fish[1]];
					eatfishInfo = fish;
				}
			}
		}
		
		
		if(eatfishInfo[0] != -1) { // 물고기를 먹으러 갈 수 있다면
			map[eatfishInfo[0]][eatfishInfo[1]] = 9; // 원래 물고기가 있던 곳은 상어가 오게 되고
			map[shark[0]][shark[1]] = 0; // 원래 상어가 있던 곳은 빈칸이 됨
			shark = eatfishInfo; // 상어 위치 수정
			time += minDis -1; // 시간 추가해주고
			eating++; // 먹은 물고기 수 추가
			
			if(eating == sharkSize) { // 상어 크기와 같은 수의 물고기를 먹으면 크기 증가
				eating = 0;
				sharkSize++;
			}
			return true;
		}
		else return false;
	}
	
	private static void getDistance() { // 상어 위치에서 각 인덱스에 가기 위해 걸리는 거리 구하기
		
		tmpMap = new int[N][N];
		tmpMap[shark[0]][shark[1]] = 1;

		Queue<int[]> q = new LinkedList<>();
		q.add(shark);
		
		// 상하좌우
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		while(!q.isEmpty()) {
			int[] point = q.poll();
			
			for (int i = 0; i < 4; i++) { // 사방탐색
				int nx = point[0] + dx[i];
				int ny = point[1] + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 체크
					if(tmpMap[nx][ny] == 0 && map[nx][ny] <= sharkSize) { // 아직 방문한 적 없고, 상어가 지나갈 수 있는 길일 때만
						tmpMap[nx][ny] = tmpMap[point[0]][point[1]] + 1;
						q.add(new int[] {nx, ny});
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N]; // 공간의 상태
		fishList = new ArrayList<>(); // 물고기 정보
		shark = new int[2]; // 상어 정보
		
		for (int i = 0; i <= 6; i++) { // 1~6 크기의 물고기 정보를 넣기 위한 ArrayList 선언
			fishList.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] >= 1 && map[i][j] <= 6) { // 물고기라면
					fishList.get(map[i][j]).add(new int[] {i, j}); // [x좌표, y좌표]
				}
				else if(map[i][j] == 9) { // 상어라면
					shark[0] = i;
					shark[1] = j;
				}
			}
		}
		
		sharkSize = 2; // 처음 아기 상어의 크기는 2
		
		// 더 이상 먹을 수 있는 물고기가 없을 때까지 물고기 먹기
		while(play());
		
		// 출력
		System.out.println(time);
	}

}