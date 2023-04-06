import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		// 먹을 수 있는 초밥
		int[] sushi = new int[d + 1];
		
		// 초밥 벨트
		int[] belt = new int[N];
		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}
		
		// 먹을 수 있는 초밥 가짓수
		sushi[c] = 1;
		int count = 1;
		
		// 처음 k의 초밥을 고르는 경우
		for (int i = 0; i < k; i++) {
			if(sushi[belt[i]] == 0) count++;
			sushi[belt[i]]++;
		}
		int result = count;
		
		// 뒤에 초밥 빼주고 앞에 초밥 추가
		for (int i = 0; i < N - 1; i++) {
			// 뒤에 초밥 빼주기
			if(sushi[belt[i]] == 1) count--;
			sushi[belt[i]]--;
			
			// 앞에 초밥 추가
			int idx = i + k >= N ? i + k - N : i + k;
			if(sushi[belt[idx]] == 0) count++;
			sushi[belt[idx]]++;
			
			// 답 비교
			result = Math.max(result, count);
		}
		
		System.out.println(result);
	}

}