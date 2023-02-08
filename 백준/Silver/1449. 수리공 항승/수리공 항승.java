import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// n, l 입력
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		// 파이프의 정보를 담는 배열 선언 & 물이 새는 위치 입력
		boolean[] pipe = new boolean[1001];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			pipe[Integer.parseInt(st.nextToken())] = true;
		}
		
		int count = 0; // 테이프의 개수
		for (int i = 0; i < pipe.length; i++) { // 파이프를 순회하며
			if(pipe[i]) { // 물이 새는 위치부터 시작해서
				for(int j = 0; j < l; j++) { // 테이프이 길이만큼 테이프를 붙혀줌.
					if(i + j < pipe.length) pipe[i + j] = false;
				}
				count++;
			}
		}
		
		// 출력
		System.out.println(count);
	}

}