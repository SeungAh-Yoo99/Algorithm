import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int D;
	static int[][] graph;
	static int[][] copyGraph;
	static int[] archer = new int[3];
	static int result = 0;
	
	private static void down() { // 적들이 아래로 한 칸 씩 이동하는 메소드
		for (int i = N - 1; i > 0; i--) {
			copyGraph[i] = copyGraph[i - 1];
		}
		copyGraph[0] = new int[M];
	}
	
	private static int[] attack(int y) { // y 위치에 있는 궁수가 공격할 적의 인덱스를 반환하는 메소드
		for (int i = 1; i <= D; i++) { // 가장 가까운 적부터
			for (int j = -i; j <= i; j++) { // 거리가 같다면 왼쪽부터
				int ny = y + j;
				int nx = N - i + Math.abs(j);
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && copyGraph[nx][ny] == 1) {
					return new int[] {nx, ny};
				}
			}
		}
		return null;
	}
	
	private static void play() { // 궁수 3명이 N턴의 게임을 진행한다.
		int[][] enemy = new int[3][2]; // 공격할 적의 위치
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) { // 궁수 3명이 공격할 적들의 위치를 구한다.
				enemy[j] = attack(archer[j]);
			}
			for (int j = 0; j < 3; j++) { // 한 명씩 공격
				if(enemy[j] != null && copyGraph[enemy[j][0]][enemy[j][1]] == 1) { // 공격할 적이 없거나 이미 적이 죽은 경우가 아니면
					copyGraph[enemy[j][0]][enemy[j][1]] = 0; // 적을 죽이고
					count++; // 죽인 적의 수 카운트
				}
			} // 궁수 공격 끝
			down(); // 적들 한 칸 이동
		} // 적들이 N번 아래로 내려오면 게임 끝남
		
		result = Math.max(result, count); // 현재 궁수의 위치가 가장 많은 적을 죽였다면 result 갱신
	}
	
	private static void pick(int n, int i) { // 궁수 3명의 자리를 고르는 메소드
		if(n == 3) { // 궁수 3명 다 골랐다면
			// graph deep copy
			copyGraph = new int[N][M];
			for (int j = 0; j < N; j++) {
				copyGraph[j] = graph[j].clone();
			}
			play(); // 게임 시작
			return;
		}
		
		for (int j = i; j < M; j++) {
			archer[n] = j;
			pick(n + 1, j + 1);
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 행의 수 N, 열의 수 M, 공격 거리 제한 D 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		// 격자판 상태 입력
		graph = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 궁수 3명 골라서 게임해본 뒤 최대값 구하기
		pick(0, 0);
		
		// 출력
		System.out.println(result);
	}

}