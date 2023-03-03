import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] arr;
	static int[] order = new int[9];
	static int visited;
	static int result;
	
	private static void perm(int idx) {
		if(idx == 9) { // 순서를 다 정했다면
			getScore(); // 점수 구하기
			return;
		}
		

		
		// 4번 타자는 1번 선수로 고정
		if(idx == 3) perm(idx + 1);
		else {
			for (int i = 1; i < 9; i++) {
				if((visited & 1 << i) == 0) {
					visited |= 1 << i;
					order[idx] = i;
					perm(idx + 1);
					visited -= 1 << i;
				}
			}
		}
	}
	
	private static void getScore() {
		int score = 0;
		int n = 0; // 현재 n번째 타자 차례	
		
		for (int i = 0; i < N; i++) { // N번의 이닝 진행
			int q = 0; // 큐 역할을 할 비트
			
			int countZero = 0; // 아웃의 개수
			int j = n; // 현재 타자 순서
			while(true) {
				int s = arr[i][order[j]]; // j번째 타순인 선수의 i번째 이닝 진행
				
				if(s == 0) { // 아웃일 때
					countZero++;
					if(countZero == 3) {
						n = (j + 1) % 9; // 다음 이닝에는 현재 타자 다음 순서의 타자
						break; // 3회 아웃이라면 다음 이닝으로
					}
				}
				
				for (int k = 0; k < s; k++) {
					if((q & 1 << 2) == 1 << 2) score++; // 3루에 사람이 있을 때 점수를 주고
					if(k == 0) q = (q << 1) + 1; // 처음에만 사람을 넣어주고
					else q = q << 1; // 나머지는 빈간으로 채워줌
				}
				q = q & ((1 << 3) - 1); // 비트 3자리 유지하도록
				j = (j + 1) % 9; // 다음 타자
			}
		}
		
		result = Math.max(result, score);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		N = Integer.parseInt(br.readLine());
		arr = new int[N][9];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = 1 << 9; // 방문체크
		
		// 1번 선수는 4번 타자
		order[3] = 0;
		visited |= 1;
		
		// 순서를 구해서 최대 점수 구하기
		perm(0);
		
		// 출력
		System.out.println(result);
	}

}