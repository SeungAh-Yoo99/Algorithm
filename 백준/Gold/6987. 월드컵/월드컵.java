import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[][][] arr;
	static int[][] tmp;
	static int[] result;
	
	private static void vs(int a, int b) {
		
		// 하나의 경우가 나왔을 때
		if(a == 5) {
			for (int i = 0; i < 4; i++) {
				if(result[i] == 0) { // 아직 불가능한 결과인 테스트 케이스 중에
					int check = 1 << 6; // 원래 boolean 배열로 check 확인해줬는데, 메모리 부족으로 비트마스킹으로 대체
					int j = 0, k = 0;
					for (j = 0; j < 6; j++) { // 나올 수 있는 결과 tmp와 결과를 비교
						for (k = 0; k < 6; k++) {
							if(arr[i][j][0] == tmp[k][0] && arr[i][j][1] == tmp[k][1] && arr[i][j][2] == tmp[k][2] && (check >> k) % 2 == 0) {
								check |= 1 << k;
								break;
							}
						}
						if(k == 6) break;
					}
					// 결과가 같았는지 확인
					if(k != 6) {
						result[i] = 1;
					}
				}
			}
			
			return;
		}
		
		// a가 이긴 경우
		tmp[a][0]++;
		tmp[b][2]++;
		if(b == 5) vs(a + 1, a + 2);
		else vs(a, b + 1);
		tmp[a][0]--;
		tmp[b][2]--;
		
		// 무승부
		tmp[a][1]++;
		tmp[b][1]++;
		if(b == 5) vs(a + 1, a + 2);
		else vs(a, b + 1);
		tmp[a][1]--;
		tmp[b][1]--;
		
		
		// a가 진 경우
		tmp[a][2]++;
		tmp[b][0]++;
		if(b == 5) vs(a + 1, a + 2);
		else vs(a, b + 1);
		tmp[a][2]--;
		tmp[b][0]--;
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 6개국 결과 받기
		arr = new int[4][6][3];
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				for (int k = 0; k < 3; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		// 나올 수 있는 결과
		tmp = new int[6][3];
		
		// 결과
		result = new int[4];
		
		// 경우의 수 구하기
		vs(0, 1);
		
		// 출력
		for (int i = 0; i < 4; i++) {
			sb.append(result[i] + " ");
		}
		System.out.println(sb);
	}
}
