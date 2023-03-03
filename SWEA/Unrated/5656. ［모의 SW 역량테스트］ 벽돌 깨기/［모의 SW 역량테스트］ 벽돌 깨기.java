import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int N; // 구슬 떨어트릴 횟수
	static int W; // 넓이
	static int H; // 높이
	static int[][] graph; // 벽돌 정보
	static int[][] tmpGraph; // 딥카피한 벽돌 정보
	static int[] bead; // 구슬 떨어트릴 위치
	static int countOfBrick; // 벽돌의 개수
	static int result; // 모든 경우의 수 중 제거 할 수 있는 벽돌의 최대값
	static int count; // 해당 경우에서 제거할 수 있는 벽돌 수
	
	private static void location(int idx) { // 구슬 위치 고르는 메소드
		if(idx == N) { // 구슬 위치 다 골랐을 경우
			dropBead(); // 구슬 떨어트리기
			return;
		}
		
		for (int i = 0; i < W; i++) {
			bead[idx] = i;
			location(idx + 1);
		}
	}
	
	private static void dropBead() { // 구슬 떨어트리기
		tmpGraph = new int[H][W]; // 벽돌 정보 딥카피
		for (int i = 0; i < H; i++) {
			tmpGraph[i] = graph[i].clone();
		}
		
		count = 0;
		for (int i = 0; i < N; i++) { // 정해진 인덱스로 구슬 떨어트리기
			for (int j = 0; j < H; j++) {
				if(tmpGraph[j][bead[i]] != 0) { // 가장 위에 있는벽돌이 구슬에 깨진다
					breaking(j, bead[i]);
					break;
				}
			}
			dropBrick(); // 위에 떠있는 벽돌 밑으로 떨어진다.
		}
		
		// 구슬 떨어트리기가 끝났다면, 다른 경우와 비교하여 더 많이 구슬을 떨어트린 결과 저장
		result = Math.max(result, count);
	}
	
	private static void breaking(int x, int y) { // 구슬이 벽돌에 맞았을 때, 벽돌을 깨트리는 메소드
		// 상하좌우
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		int bound = tmpGraph[x][y] - 1; // 구슬 맞은 벽돌의 폭발 범위
		
		count++; // 터진 벽돌 개수 세주고
		tmpGraph[x][y] = 0; // 벽돌 없애주기
		
		for (int i = 0; i < 4; i++) { // 4방으로 폭발
			for (int j = 1; j <= bound; j++) { // 폭발 범위만큼
				int nx = x + dx[i] * j;
				int ny = y + dy[i] * j;
				if(nx >= 0 && nx < H && ny >= 0 && ny < W) { // 범위 체크
					// 벽돌이었다면 함께 터트려준다
					if(tmpGraph[nx][ny] != 0) breaking(nx, ny);
				}
			}
		}
	}
	
	private static void dropBrick() { // 위에 떠있는 벽돌 밑으로 떨어지게 하는 메소드
		for (int i = H - 2; i >= 0; i--) { // 밑에서 부터 확인
			for (int j = 0; j < W; j++) {
				if(tmpGraph[i][j] != 0 && tmpGraph[i + 1][j] == 0) { // 현재 위치에 벽돌이 있는데 밑이 빈칸이라면
					int x = i;
					for (int k = i + 1; k < H; k++) { // 밑 칸을 계속 확인해주며
						if(tmpGraph[k][j] != 0) break; // 가장 위에 있는 벽돌을 확인해주며
						x = k; // 떨어질 벽돌의 x좌표 값을 구해준다
					}
					tmpGraph[x][j] = tmpGraph[i][j]; // 벽돌 위치 수정
					tmpGraph[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			graph = new int[H][W]; // 벽돌 정보
			
			countOfBrick = 0;
			result = 0;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					int n = Integer.parseInt(st.nextToken());
					if(n != 0) {
						graph[i][j] = n;
						countOfBrick++;
					}
				}
			}
			
			bead = new int[N];
			
			// 구슬 떨어트릴 위치 구한 후 떨어트리기
			location(0);
			
			// 결과 담기
			sb.append("#" + test_case + " " + (countOfBrick - result) + "\n");
		}
		
		// 출력
		System.out.println(sb);
	}

}
