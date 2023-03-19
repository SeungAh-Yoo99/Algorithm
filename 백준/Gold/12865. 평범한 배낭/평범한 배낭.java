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
		int K = Integer.parseInt(st.nextToken());
		
		long[] bag = new long[K + 1]; // 인덱스에 해당하는 무게 중 가장 큰 가치를 저장한다.
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken()); // 무게
			long V = Long.parseLong(st.nextToken()); // 가치
			// W 무게의 물건을 넣을 수 있는 경우 중 최대 가치 구하기
			long maxValue = 0;
			long[] tmpBag = bag.clone();
			for (int j = 0; j <= K - W; j++) {
				maxValue = Math.max(maxValue, bag[j]);
				tmpBag[j + W] = Math.max(bag[j + W], maxValue + V);
			}
			bag = tmpBag;
		}
		
		System.out.println(bag[K]);
	}

}