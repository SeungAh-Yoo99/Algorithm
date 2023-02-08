import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// n, m 입력
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int minPrice1 = (int) 10e9; // 패키지 최솟값
		int minPrice2 = (int) 10e9; // 낱개 최솟값
		for (int i = 0; i < m; i++) {
			// 패키지 가격, 낱개 가격 입력
			st = new StringTokenizer(br.readLine());
			int price1 = Integer.parseInt(st.nextToken());
			int price2 = Integer.parseInt(st.nextToken());
			
			// 최솟값이면 저장
			minPrice1 = minPrice1 < price1 ? minPrice1 : price1;
			minPrice2 = minPrice2 < price2 ? minPrice2 : price2;
		}
		
		// 답 구하기
		int result = (n / 6) * minPrice1 + (n % 6) * minPrice2;
		// 세트로만 사는게 더 싸다면 세트로만 삼.
		int tmp = (n / 6 + 1) * minPrice1;
		result = result < tmp ? result : tmp;
		// 낱개로만 사는게 더 싸다면 낱개로만 삼.
		tmp = n * minPrice2;
		result = result < tmp ? result : tmp;
		
		// 답 출력
		System.out.println(result);
	}

}