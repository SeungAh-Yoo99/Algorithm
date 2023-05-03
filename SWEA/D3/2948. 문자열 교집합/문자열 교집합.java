import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// 첫 번째 집합의 원소 문자열 입력 후 HashMap에 저장
			HashMap<String, Integer> hm = new HashMap<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				hm.put(st.nextToken(), 0);
			}
			
			// 두 번째 집합의 원소 문자열 입력 후 이미 값이 있다면 count
			int count = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				if(hm.containsKey(st.nextToken())) count++;
			}
			
			// 출력 담기
			sb.append("#" + tc + " " + count + "\n");
		}
		
		System.out.println(sb);
	}

}