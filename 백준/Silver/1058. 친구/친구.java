import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 사람의 수 N 입력
		int N = Integer.parseInt(br.readLine());
		
		// 친구 정보 입력
		char[][] friends = new char[N][N];
		for (int i = 0; i < N; i++) {
			friends[i] = br.readLine().toCharArray();
		}
		
		// 플로이드 워셜
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					// 본인이 아니고 서로 친구도 아닌 경우에
					if(j != k && friends[j][k] == 'N')
						// 친구의 친구라면
						if(friends[j][i] == 'Y' && friends[i][k] == 'Y')
							friends[j][k] = 'F'; // 'F'로 표시
				}
			}
		}
		
		// 가장 유명한 사람의 친구의 수 구하기
		int result = 0;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++)
				// 친구거나 친구의 친구라면 카운트
				if(friends[i][j] == 'Y' || friends[i][j] == 'F') sum++;
			result = Math.max(result, sum);
		}
		
		// 출력
		System.out.println(result);
	}

}