import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Long.parseLong(br.readLine());
		
		ArrayList<Integer> dp = new ArrayList<>();// 다음 수를 가리키는 dp
		dp.add(0);
		dp.add(1);
		dp.add(1);
		
		int first = 1;
		int second = 1;
		
		while(true) {
			// 반복되는 수를 찾았다면 반복문 탈출
			if(first == 0 && second == 1) break;
			int tmp = (first + second) % 1_000_000;
			dp.add(tmp);
			first =  second;
			second = tmp;
		}
		
		
		// 출력
		System.out.println(dp.get((int)(n % (dp.size() - 2))));
	}

}