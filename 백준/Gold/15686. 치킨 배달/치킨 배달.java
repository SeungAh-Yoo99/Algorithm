import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int m, chickenSize, houseSize;
	static int result = (int) 10e9;
	static int[] chickenIndex;
	static int[][] disArr;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		int[][] house = new int[2 * n][2]; // 집의 위치 정보를 넣을 배열
		int[][] chicken = new int[13][2]; // 치킨집의 위치 정보를 넣을 배열
		
		// 집과 치킨집의 정보 입력
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j++) {
				int k = Integer.parseInt(st.nextToken());
				
				// k가 1이면 house 배열에 저장
				if(k == 1) {
					house[houseSize][0] = i;
					house[houseSize++][1] = j;
				}
				// k가 2면 chicken 배열에 저장
				else if (k == 2) {
					chicken[chickenSize][0] = i;
					chicken[chickenSize++][1] = j;
				}
			}
		}
		
		// 각 집과 치킨집의 거리를 구해 disArr에 저장
		disArr = new int[houseSize][chickenSize];
		for(int i = 0; i < houseSize; i++) {
			for (int j = 0; j < chickenSize; j++) {
				disArr[i][j] = Math.abs(house[i][0] - chicken[j][0]) + Math.abs(house[i][1] - chicken[j][1]);
			}
		}
		
		// 재귀함수를 통해 완전탐색
		chickenIndex = new int[m];
		for(int i = 0; i < chickenSize; i++) {
			getMinDis(0, i);
		}
		
		// 출력
		System.out.println(result);

	}

	static void getMinDis(int nth, int idx) {
		// chickenIndex 배열에 폐업하지 않는 치킨집의 인덱스 저장
		chickenIndex[nth] = idx;
		
		// 재귀
		for(int i = idx + 1; i < chickenSize; i++) {
			if(nth < m - 1) {
				getMinDis(nth + 1, i);
			}
		}

		if(nth == m - 1) {
			int minDis = 0;
			for(int i = 0; i < houseSize; i++) {
				int tmp = (int) 10e9;
				// 해당 집의 치킨 거리
				for (int j : chickenIndex) {
					tmp = tmp < disArr[i][j] ? tmp : disArr[i][j];
				}
				// 도시의 치킨 거리
				minDis += tmp;
			}
			// 가장 작은 도시의 치킨 거리를 result에 저장
			result = result < minDis ? result : minDis;
		}
	}
}