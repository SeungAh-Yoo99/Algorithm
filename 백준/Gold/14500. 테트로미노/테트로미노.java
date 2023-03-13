import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 가능한 모든 모양을 배열에 담아준다.
		int[][][] tetromin = {{{0, 0}, {0, 1}, {0, 2}, {0, 3}},
				{{0, 0}, {1, 0}, {2, 0}, {3, 0}},
				{{0, 0}, {0, 1}, {1, 0}, {1, 1}},
				{{0, 0}, {-1, 0}, {0, -1}, {0, -2}},
				{{0, 0}, {-1, 0}, {-2, 0}, {0, 1}},
				{{0, 0}, {0, -1}, {1, 0}, {2, 0}},
				{{0, 0}, {0, 1}, {0, 2}, {1, 0}},
				{{0, 0}, {1, 0}, {0, -1}, {0, -2}},
				{{0, 0}, {0, -1}, {-1, 0}, {-2, 0}},
				{{0, 0}, {0, 1}, {1, 0}, {2, 0}},
				{{0, 0}, {-1, 0}, {0, 1}, {0, 2}},
				{{0, 0}, {0, -1}, {-1, 0}, {-1, 1}},
				{{0, 0}, {1, 0}, {0, -1}, {-1, -1}},
				{{0, 0}, {0, 1}, {-1, 0}, {-1, -1}},
				{{0, 0}, {-1, 0}, {0, -1}, {1, -1}},
				{{0, 0}, {0, -1}, {1, 0}, {0, 1}},
				{{0, 0}, {-1, 0}, {0, 1}, {1, 0}},
				{{0, 0}, {0, -1}, {-1, 0}, {0, 1}},
				{{0, 0}, {-1, 0}, {0, -1}, {1, 0}}};
		
		int result = 0;
		
		for (int i = 0; i < N; i++) { // x축
			for (int j = 0; j < M; j++) { // y축
				for (int k = 0; k < tetromin.length; k++) { // 모든 경우에 대해서
					boolean flag = true; // 불가능한 경우라면 false
					int sum = 0; // 4개 칸의 합
					for (int l = 0; l < 4; l++) {
						int nx = i + tetromin[k][l][0];
						int ny = j + tetromin[k][l][1];
						if(nx >= 0 && nx < N && ny >= 0 && ny < M) { // 범위 체크
							sum += arr[nx][ny];
						}
						else {
							flag = false;
							break;
						}
					}
					if(flag) { // 가능한 경우라면 답과 비교해줌
						result = Math.max(result, sum);
					}
				}
			}
			
		}
		
		// 출력
		System.out.println(result);
	}

}