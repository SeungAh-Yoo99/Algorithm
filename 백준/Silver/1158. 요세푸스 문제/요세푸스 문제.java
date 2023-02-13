import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// N, K 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 1 ~ N까지 LinkedList에 넣기
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		sb.append("<");
		int idx = 0;
		while(!list.isEmpty()) {
			idx += K - 1;
			if(idx >= list.size())
				idx %= list.size();
			
			sb.append(list.get(idx));
			list.remove(idx);
			if(!list.isEmpty())
				sb.append(", ");
		}
		sb.append(">\n");
		
		System.out.println(sb);
	}

}