import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int[][] cus;
	static int[] cusIndex;
	static boolean[] visited;
	static int result;
	
	private static void combi(int n) {
		if(n == N + 1) {
			dis(); // 도착 순서대로 이동거리 기록
			return;
		}
		
		for (int i = 2; i <= N + 1; i++) {
			if(!visited[i]) {
				visited[i] = true;
				cusIndex[n] = i;
				combi(n + 1);
				visited[i] = false;
			}
		}
	}
	
	private static void dis() {
		int distance = 0;
		
		// i -> i + 1로 가는 거리 모두 저장
		for (int i = 0; i < N + 1; i++)
			distance += Math.abs(cus[cusIndex[i]][0] - cus[cusIndex[i + 1]][0]) + Math.abs(cus[cusIndex[i]][1] - cus[cusIndex[i + 1]][1]);
		
		// 현재 거리가 가장 짧으면 result에 저장
		result = Math.min(result, distance);
	}

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스의 수 입력
		int tc = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= tc; test_case++) { // 10개의 테스트 케이스 반복
			sb.append("#" + test_case + " ");
			
			// 고객의 수 N 입력
			N = Integer.parseInt(br.readLine());
			// 회사 & 집 & 고객의 좌표 입력
			st = new StringTokenizer(br.readLine());
			cus = new int[N + 2][2];
			for (int i = 0; i < N + 2; i++) {
				cus[i][0] = Integer.parseInt(st.nextToken());
				cus[i][1] = Integer.parseInt(st.nextToken());
			}
			
			// N명의 고객 도착 순서 조합 구하기
			cusIndex = new int[N + 2];
			cusIndex[0] = 0; // 출발 인덱스는 회사
			cusIndex[N + 1] = 1; // 도착 인덱스는 집
			visited = new boolean[N + 2];
			result = Integer.MAX_VALUE;
			combi(1);
			
			// 출력
			sb.append(result + "\n");
		}
		
		System.out.println(sb);
	}

}