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
		
		boolean[] knowTruth = new boolean[N + 1]; // 진실을 아는 사람은 true
		st = new StringTokenizer(br.readLine());
		int kt = Integer.parseInt(st.nextToken());
		for (int i = 0; i < kt; i++) {
			knowTruth[Integer.parseInt(st.nextToken())] = true;
		}
		
		int[][] party = new int[M][N + 1]; // 파티 정보
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			party[i] = new int[n];
			for (int j = 0; j < n; j++) {
				party[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		boolean flag = false; // 더 이상 바뀐 정보가 없다면 true
		boolean[] truthParty = new boolean[M]; // 진실을 말한 파티라면 true
		while(!flag) {
			flag = true;
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < party[i].length; j++) {
					if(truthParty[i]) continue; // 이미 진실을 말하기로 한 파티면 넘어감
					if(knowTruth[party[i][j]]) { // 진실을 아는 사람이 있다면
						for (int k = 0; k < party[i].length; k++) { // 현재 파티의 모든 사람들을 진실을 안다고 표시해주고
							knowTruth[party[i][k]] = true;
						}
						truthParty[i] = true; // 진실을 말하기로 한 파티라고 표시해주고
						flag = false; // 바뀐 정보가 있다고 표시
						break; // 다음 파티 정보로 넘어감
					}
				}
			}
		}
		
		int result = 0;
		for (boolean tp : truthParty) {
			if(!tp) result++; // 과장된 이야기를 할 수 있는 파티 개수 구하기
		}
		
		// 출력
		System.out.println(result);
	}

}