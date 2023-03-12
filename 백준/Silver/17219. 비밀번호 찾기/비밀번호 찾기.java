import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 사이트 주소와 비밀번호 HashMap에 저장
		HashMap<String, String> hm = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			hm.put(st.nextToken(), st.nextToken());
		}
		
		// 사이트 주소로 비밀번호 찾기
		for (int i = 0; i < M; i++) {
			sb.append(hm.get(br.readLine()) + "\n");
		}
		
		// 출력
		System.out.println(sb);
	}

}