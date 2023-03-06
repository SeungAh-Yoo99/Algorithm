import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int M;
	static int C;
	static int[][] map;
	static int[][] pickedHiveInfo;
	static int result;
	static int count;
	static int tmpCount;
	
	private static void pickBeehive(int idx) {
		if(idx == 2) { // 두 사람의 벌통 위치를 다 골랐다면
			extraction();
		}
		
		else if(idx == 0) { // 첫번째 사람의 벌통을 고르는 경우라면
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - M; j++) {
					pickedHiveInfo[0][0] = i;
					pickedHiveInfo[0][1] = j;
					pickBeehive(idx + 1);
				}
			}
		}
		
		else { // 두번째 사람의 벌통을 고르는 경우라면
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= N - M; j++) {
					pickedHiveInfo[1][0] = i;
					if(pickedHiveInfo[0][0] == i) { // 첫번째 사람과 같은 행에서 고르는 경우
						if(j + M - 1 < pickedHiveInfo[0][1]) { // 첫번째 사람 앞에서 벌통을 고르는 경우
							pickedHiveInfo[1][1] = j;
						}
						else if(j + M - 1 < N && pickedHiveInfo[0][1] + M - 1 < j) { // 첫번째 사람 뒤에서 벌통을 고르는 경우
							pickedHiveInfo[1][1] = j;
						}
						else {
							continue;
						}
					}
					else { // 다른 행에서 고르는 경우
						pickedHiveInfo[1][1] = j;
					}
					pickBeehive(idx + 1);
				}
			}
		}
	}
	
	private static void extraction() { // 벌꿀 채취 매소드
		count = 0;

		for (int i = 0; i < 2; i++) { // 두 사람이 고른 벌통 위치에서 채취할 수 있는 꿀의 최대양 구하기
			int c = 0; // 꿀의 총량
			for (int j = pickedHiveInfo[i][1]; j < pickedHiveInfo[i][1] + M; j++) {
				c += map[pickedHiveInfo[i][0]][j];
			}
			
			if(c <= C) { // 현재 위치에서 꿀을 모두 채취할 수 있다면
				for (int j = pickedHiveInfo[i][1]; j < pickedHiveInfo[i][1] + M; j++) { // 모두 채취
					count += Math.pow(map[pickedHiveInfo[i][0]][j], 2);
				}
			}
			else { // 현재 위치에서 꿀을 모두 채취할 수 없다면
				Integer[] tmp = new Integer[M]; // 꿀 정보를 가져와서
				for (int j = 0; j < M; j++) {
					tmp[j] = map[pickedHiveInfo[i][0]][j + pickedHiveInfo[i][1]];
				}
				
				tmpCount = 0;
				subset(tmp, new boolean[M], 0, 0, 0);
				count += tmpCount;
			}
		}
		
		result = Math.max(result, count);
	}
	
	// 벌꿀을 채취할 수 있는 범위 내에서 가장 많은 수익을 얻을 수 있는 벌꿀통 구하는 매소드
	private static void subset(Integer[] arr, boolean[] visited, int idx, int count, int c) {
		if(idx == arr.length) {
			if(c <= C) { // C를 넘지 않을 때만 계산
				tmpCount = Math.max(tmpCount, count);
			}
			return;
		}
		
		subset(arr, visited, idx + 1, count, c); // 현재 인덱스를 포함하지 않는 경우
		
		visited[idx] = true;
		c += arr[idx];
		count += Math.pow(arr[idx], 2);
		subset(arr, visited, idx + 1, count, c); // 현재 인덱스를 포함하는 경우
		
		visited[idx] = false;
		c -= arr[idx];
		count -= Math.pow(arr[idx], 2);
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 입력
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 벌통들의 크기
			M = Integer.parseInt(st.nextToken()); // 벌통의 개수
			C = Integer.parseInt(st.nextToken()); // 꿀을 채취할 수 있는 최대 양
			
			map = new int[N][N]; // 꿀의 양에 대한 정보
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 초기화
			pickedHiveInfo = new int[2][2];
			result = 0;
			
			// 벌꿀 채취
			pickBeehive(0);
			
			// 출력 담기
			sb.append("#" + test_case + " " + result + "\n");
		}
		
		// 출력
		System.out.println(sb);
	}

}