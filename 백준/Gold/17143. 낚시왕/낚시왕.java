import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int R;
	static int C;
	static int M;
	static int[][] graph;
	static int[][] shark;
	static int result;
	
	private static void fishingKing(int idx) { // 낚시왕이 상어를 잡는 메소드
		for (int i = 1; i <= R; i++) { // 낚시왕이 있는 열에서 가장 가까운 상어를 잡는다
			if(graph[i][idx] != 0) {
				int srk = graph[i][idx]; // 상어의 인덱스
				result += shark[srk][4]; // 낚시왕이 잡은 상어 크기 더해주고
				shark[srk][4] = -1; // 해당 상어는 사라졌다고 표시해준다
				graph[i][idx] = 0; // 격자판에도 상어를 지워준다.
				break; // 가장 가까운 한마리만 잡는다
			}
		}
	}
	
	private static void move() { // 상어가 움직이는 메소드
		
		int[] dx = {0, -1, 1, 0, 0};
		int[] dy = {0, 0, 0, 1, -1};
		
		for (int i = 1; i <= M; i++) {
			if(shark[i][4] != -1) { // 이미 사라진 상어가 아니라면
				int r = shark[i][0];
				int c = shark[i][1];
				int s = shark[i][2];
				int d = shark[i][3];
				int z = shark[i][4];
				
				// 현재 격자판에 새로운 상어의 정보가 저장되어 있는게 아니라면 0으로 자리가 비었다고 표시해줌
				if(graph[r][c] == i) graph[r][c] = 0;
				
				// 상어가 움직였을 때의 위치를 구해준다.
				if(d == 1 || d == 2) { // 상어가 위나 아래로 움직이는 경우
					r += s % ((R - 1) * 2) * dx[d]; // (R - 1) * 2번 가면 제자리로 돌아오므로 나눈 나머지만큼만 가준다.
					while(r > R || r < 1) { // 인덱스 범위 안에 들어올 때까지 방향을 바꿔줌
						if(r > R) { // 격자판 밑을 넘어갔을 경우
							r = R - (r - R);
							d = 1; // 이제 상어는 위쪽 방향을 바라보고 있음
						}
						if(r < 1) { // 격자판 위로 넘어갔을 경우
							r = 1 + (1 - r);
							d = 2; // 이제 상어는 아래쪽 방향을 바라보고 있음
						}
					}
				}
				else { // 상어가 왼쪽이나 오른쪽으로 움직이는 경우
					c += s % ((C - 1) * 2) * dy[d]; // (C - 1) * 2번 가면 제자리로 돌아오므로 나눈 나머지만큼만 가준다.
					while(c > C || c < 1) { // 인덱스 범위 안에 들어올 때까지 방향을 바꿔줌
						if(c > C) { // 격자판 오른쪽을 넘어갔을 경우
							c = C - (c - C);
							d = 4; // 이제 상어는 왼쪽 방향을 바라보고 있음
						}
						if(c < 1) { // 격자판 왼쪽을 넘어갔을 경우
							c = 1 + (1 - c);
							d = 3; // 이제 상어는 오른쪽 방향을 바라보고 있음
						}
					}
				}
				
				// 격자판에 상어가 움진인 위치로 정보를 갱신해준다.
				if(graph[r][c] == 0 || graph[r][c] > i) { // 현재 해당 칸에 아무것도 없는 상태거나, 아직 위치 이동을 해주지 않은 상어라면
					graph[r][c] = i; // 해당 상어를 칸에 넣어준다
				}
				else { // 현재 해당 칸에 이미 위치 이동을 끝낸 상어가 이미 있다면
					int srk = graph[r][c]; // 이미 있던 상어의 인덱스
					if(shark[srk][4] > shark[i][4]) { // 기존에 있던 상어의 크기가 더 크면
						shark[i][4] = -1; // 상어거 잡아먹혔다는 표시
					}
					else { // 현재 상어가 더 크다면
						shark[srk][4] = -1; // 기존의 상어가 잡아먹혔다는 표시
						graph[r][c] = i; // 현재 상어의 정보를 격자판에 저장해줌
					}
				}
				
				// 바뀐 상어 정보 갱신
				shark[i][0] = r;
				shark[i][1] = c;
				shark[i][3] = d;
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new int[R + 1][C + 1]; // 격자판
		shark = new int[M + 1][5]; // 상어 정보
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				shark[i][j] = Integer.parseInt(st.nextToken());
			}
			graph[shark[i][0]][shark[i][1]] = i; // 격자판에 상어 위치 표시
		}
		
		for (int i = 1; i <= C; i++) {
			fishingKing(i); // 낚시왕의 낚시
			move(); // 상어 이동
		}

		System.out.println(result); // 출력
	}

}