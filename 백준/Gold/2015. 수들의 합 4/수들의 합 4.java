import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		long sum = 0;
		long result = 0;
		HashMap<Long, Integer> hm = new HashMap<>(); // key값에 해당하는 부분합이 몇 개인지 저장
		for (int i = 0; i < N; i++) {
			// arr[0] ~ arr[i]까지의 합을 key 값으로 하여 hm에 저장
			
			sum += arr[i];
			Integer pair = hm.get(sum - K); // 이전 구간의 합들 중 sum - key = K 인 구간 합이 있었다면
			if(pair != null) {
				result += pair; // key인 구간 합이 나온 횟수만큼 더해줌
			}
			if(sum == K) { // arr[0] ~ arr[i] 까지의 합이 K일 경우
				result++;
			}
			
			hm.put(sum, hm.getOrDefault(sum, 0) + 1); // arr[0] ~ arr[i] 까지의 합을 저장
		}
		
		// 출력
		System.out.println(result);
	}

}