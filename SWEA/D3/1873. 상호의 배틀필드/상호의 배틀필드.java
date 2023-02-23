import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int H;
	static int W;
	static char[][] map;
	static int playerX;
	static int playerY;
	
	private static void getPlayerLocation() {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
					playerX = i;
					playerY = j;
				}
			}
		}
	}
	
	private static void up(){
		// 위 칸이 평지라면 그 칸으로 이동
		int nx = playerX - 1;
		if(nx >= 0 && map[nx][playerY] == '.') {
			map[playerX][playerY] = '.'; // 플레이어가 원래 있던 곳은 평지로 바꿔주고
			playerX = nx; // 플레이어 위치 바꿔주기
		}
		// 플레이어 바라보는 방향을 위쪽으로 바꾸기
		map[playerX][playerY] = '^';
	}
	
	private static void down() {
		// 아래 칸이 평지라면 그 칸으로 이동
		int nx = playerX + 1;
		if(nx < H && map[nx][playerY] == '.') {
			map[playerX][playerY] = '.'; // 플레이어가 원래 있던 곳은 평지로 바꿔주고
			playerX = nx; // 플레이어 위치 바꿔주기
		}
		// 플레이어 바라보는 방향을 아래쪽으로 바꾸기
		map[playerX][playerY] = 'v';
	}
	
	private static void left() {
		// 왼쪽 칸이 평지라면 그 칸으로 이동
		int ny = playerY - 1;
		if(ny >= 0 && map[playerX][ny] == '.') {
			map[playerX][playerY] = '.'; // 플레이어가 원래 있던 곳은 평지로 바꿔주고
			playerY = ny; // 플레이어 위치 바꿔주기
		}
		// 플레이어 바라보는 방향을 왼쪽으로 바꾸기
		map[playerX][playerY] = '<';
	}
	
	private static void right() {
		// 오른쪽 칸이 평지라면 그 칸으로 이동
		int ny = playerY + 1;
		if(ny < W && map[playerX][ny] == '.') {
			map[playerX][playerY] = '.'; // 플레이어가 원래 있던 곳은 평지로 바꿔주고
			playerY = ny; // 플레이어 위치 바꿔주기
		}
		// 플레이어 바라보는 방향을 오른쪽으로 바꾸기
		map[playerX][playerY] = '>';
	}
	
	private static void shoot() {
		switch (map[playerX][playerY]) {
		case '^': // 플레이어가 위쪽을 바라보고 있었을 경우
			for (int nx = playerX - 1; nx >= 0; nx--) { // 위쪽으로 포탄 직진
				if(map[nx][playerY] == '*') { // 벽돌로 만든 벽을 만났다면
					map[nx][playerY] = '.'; // 벽은 평지가 되고
					break; // 포탄 소멸
				}
				else if(map[nx][playerY] == '#') { // 강철로 만들어진 벽을 만났다면
					break; // 포탄 소멸
				}
			}
			break;
		case 'v': // 플레이어가 아래쪽을 바라보고 있었을 경우
			for (int nx = playerX + 1; nx < H; nx++) { // 아래쪽으로 포탄 직진
				if(map[nx][playerY] == '*') { // 벽돌로 만든 벽을 만났다면
					map[nx][playerY] = '.'; // 벽은 평지가 되고
					break; // 포탄 소멸
				}
				else if(map[nx][playerY] == '#') { // 강철로 만들어진 벽을 만났다면
					break; // 포탄 소멸
				}
			}
			break;
		case '<': // 플레이어가 왼쪽을 바라보고 있었을 경우
			for (int ny = playerY - 1; ny >= 0; ny--) { // 왼쪽으로 포탄 직진
				if(map[playerX][ny] == '*') { // 벽돌로 만든 벽을 만났다면
					map[playerX][ny] = '.'; // 벽은 평지가 되고
					break; // 포탄 소멸
				}
				else if(map[playerX][ny] == '#') { // 강철로 만들어진 벽을 만났다면
					break; // 포탄 소멸
				}
			}
			break;
		case '>': // 플레이어가 오른쪽을 바라보고 있었을 경우
			for (int ny = playerY + 1; ny < W; ny++) { // 오른쪽으로 포탄 직진
				if(map[playerX][ny] == '*') { // 벽돌로 만든 벽을 만났다면
					map[playerX][ny] = '.'; // 벽은 평지가 되고
					break; // 포탄 소멸
				}
				else if(map[playerX][ny] == '#') { // 강철로 만들어진 벽을 만났다면
					break; // 포탄 소멸
				}
			}
			break;
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스의 수 T 입력
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			// 게임 맵 높이 H, 너비 W 입력
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			// 게임 맵
			map = new char[H][W];
			
			// 게임 맵 구성 요소 입력
			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
			}
			
			// 입력 개수 N 입력
			int N = Integer.parseInt(br.readLine());
			// 입력 문자 입력
			char[] input = br.readLine().toCharArray();
			
			// 플레이어 위치 검색
			getPlayerLocation();
			
			// 플레이어 입력
			for (int i = 0; i < N; i++) {
				switch (input[i]) {
				case 'U':
					up();
					break;
				case 'D':
					down();
					break;
				case 'L':
					left();
					break;
				case 'R':
					right();
					break;
				case 'S':
					shoot();
					break;
				}
			}
			
			// 맵의 상태 저장
			for (int i = 0; i < H; i++) {
				sb.append(String.valueOf(map[i]) + "\n");
			}
		}
		
		// 출력
		System.out.println(sb);
	}

}