import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class Fish {
		
		int num;
		int x;
		int y;
		int dis;
		
		Fish(int num, int x, int y, int dis) {
			this.num = num;
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}
	
	static class Shark {
		
		int x;
		int y;
		int dis;
		int count;
		
		Shark() {
			this.x = 0;
			this.y = 0;
			this.dis = 0;
			this.count = 0;
		}
	}
	
	static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	
	static int result;
	
	private static void play(int[][] map, Fish[] fishInfo) {
		
		// 상어 생성
		Shark shark = new Shark();
		
		// 먼저 (0, 0)의 물고기를 먹음
		eat(0, 0, map, fishInfo, shark);
		
		// 모든 경우를 확인한 후, 최대값 가져오기
		moveAndEat(0, 0, map, fishInfo, shark);
	}
	
	private static void moveAndEat(int x, int y, int[][] map, Fish[] fishInfo, Shark shark) {
		
		boolean flag = false; // 현재 위치와 방향에서 이동할 수 없는 경우 false
		
		// 물고기 이동
		move(map, fishInfo);
		
		// 최대 3칸 멀리 있는 칸까지 이동 가능
		for (int i = 1; i <= 3; i++) {
			int nx = x + dx[shark.dis] * i;
			int ny = y + dy[shark.dis] * i;
			
			// 이동할 수 있는지 확인
			if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map[nx][ny] != 0) {
				flag = true;
				
				// 상어 이동 전 맵, 물고기 정보, 상어 정보 복제
				int[][] tmpMap = new int[4][];
				for (int j = 0; j < 4; j++) {
					tmpMap[j] = map[j].clone();
				}
				Fish[] tmpFishInfo = fishInfoDeepCopy(fishInfo);
				Shark tmpShark = sharkDeepCopy(shark);
				
				// 해당 위치로 물고기 먹기
				eat(nx, ny, tmpMap, tmpFishInfo, tmpShark);
				
				// 다시 한 번 반복
				moveAndEat(nx, ny, tmpMap, tmpFishInfo, tmpShark);
			}
		}
		
		// 더 이상 갈 수 있는 방향이 없으면 돌아감
		if(!flag) {
			result = Math.max(result, shark.count);
		}
	}
	
	private static void move(int[][] tmpMap, Fish[] tmpFishInfo) {
		
		
		// 1번 물고기부터 16번 물고기까지 이동
		for (int i = 1; i <= 16; i++) {
			// 이미 먹힌 물고기라면 넘어가기
			if(tmpFishInfo[i] == null) continue;
			
			// 8 방향 중 갈 수 있는 방향으로 이동
			for (int j = 0; j < 8; j++) {
				int dis = tmpFishInfo[i].dis + j > 8 ?  tmpFishInfo[i].dis + j - 8 : tmpFishInfo[i].dis + j;
				
				int nx = tmpFishInfo[i].x + dx[dis];
				int ny = tmpFishInfo[i].y + dy[dis];
				
				// 현재 방향으로 갈 수 있는지 확인
				if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && tmpMap[nx][ny] != -1) {
					// 이동할 칸에 다른 물고기가 있다면 그 물고기를 원래 칸으로 이동
					if(tmpMap[nx][ny] != 0) {
						int num = tmpMap[nx][ny];
						tmpMap[tmpFishInfo[i].x][tmpFishInfo[i].y] = num;
						tmpFishInfo[num].x = tmpFishInfo[i].x;
						tmpFishInfo[num].y = tmpFishInfo[i].y;
					}
					// 이동할 칸에 다른 물고기가 없었다면, 원래 칸을 빈 칸으로 바꿔줌
					else {
						tmpMap[tmpFishInfo[i].x][tmpFishInfo[i].y] = 0;
					}
					
					// 이동한 물고기 위치 변경
					tmpMap[nx][ny] = i;
					tmpFishInfo[i].x = nx;
					tmpFishInfo[i].y = ny;
					tmpFishInfo[i].dis = dis;
					
					// 이동했으면 댜음 물고기 이동하러
					break;
				}
			}
		}
	}
	
	private static void eat(int x, int y, int[][] tmpMap, Fish[] tmpFishInfo, Shark shark) {

		// (x, y) 위치의 물고기 번호
		int num = tmpMap[x][y];
		
		// (x, y) 위치의 물고기 방향으로 상어의 방향을 바꿔줌
		shark.dis = tmpFishInfo[num].dis;
		
		// (x, y) 위치의 물고기 번호를 상어 count에 더해줌
		shark.count += num;
		
		// (x, y) 위치의 물고기 정보를 지워줌
		tmpFishInfo[num] = null;
		
		// 원래 상어가 있던 곳을 빈 칸으로 바꿔줌
		tmpMap[shark.x][shark.y] = 0;
		
		// 맵에서 (x, y) 위치를 상어로 바꿔줌
		tmpMap[x][y] = -1;
		shark.x = x;
		shark.y = y;
	}
	
	private static Fish[] fishInfoDeepCopy(Fish[] fishInfo) {
		Fish[] tmpFishInfo = new Fish[17];
		
		for (int i = 1; i <= 16; i++) {
			Fish origin = fishInfo[i];
			if(origin != null) tmpFishInfo[i] = new Fish(i, origin.x, origin.y, origin.dis);
		}
		
		return tmpFishInfo;
	}
	
	private static Shark sharkDeepCopy(Shark shark) {
		
		Shark tmpShark = new Shark();
		
		tmpShark.x = shark.x;
		tmpShark.y = shark.y;
		tmpShark.dis = shark.dis;
		tmpShark.count = shark.count;
		
		return tmpShark;
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 맵
		int[][] map = new int[4][4];
		// 물고기 정보
		Fish[] fishInfo = new Fish[17];
		
		// 물고기 정보 입력
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int num = Integer.parseInt(st.nextToken());
				int dis = Integer.parseInt(st.nextToken());
				
				map[i][j] = num;
				fishInfo[num] = new Fish(num, i, j, dis);
			}
		}
		
		// 물고기 먹기 시작
		play(map, fishInfo);
		
		// 출력
		System.out.println(result);
	}

}