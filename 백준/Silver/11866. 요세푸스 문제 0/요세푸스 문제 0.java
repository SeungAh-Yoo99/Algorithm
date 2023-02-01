import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<Integer> result = new LinkedList<>();
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// 1부터 n까지 list에 추가
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		// 요세푸스 문제 해결
		int i = 0;
		while(!list.isEmpty()) {
			i += k - 1;
			i %= list.size();
			
			result.add(list.get(i));
			list.remove(i);
		}
		
		// 출력
		System.out.print("<");
		for (i = 0; i < result.size(); i++) {
			if(i == result.size() - 1)
				System.out.print(result.get(i));
			else
				System.out.print(result.get(i) + ", ");
		}
		System.out.print(">");
	}

}