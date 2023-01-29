import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] sour;
	static int[] bitter;
	static int result = (int)10e9;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		sour = new int[n];
		bitter = new int[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitter[i] = Integer.parseInt(st.nextToken());
		}
		
		// 재료가 한가지일 경우에는 result를 바로 구함.
		if(n == 1)
			result = Math.abs(sour[0] - bitter[0]);
		else
			taste(1, 0, 0);
		System.out.println(result);
	}

	static void taste(int sourTaste, int bitterTaste, int idx) {
		if(idx < n) {
			// 현재 재료 사용 x
			taste(sourTaste, bitterTaste, idx + 1);
			// 현재 재료 사용 o
			taste(sourTaste * sour[idx], bitterTaste + bitter[idx], idx + 1);
		}
		
		// 마지막 인덱스일 때 result 체크 후 최소값으로 갱신
		// (sourTaste와 bitterTaste가 1, 0으로 들어온 경우, 재료를 하나도 넣지 않은 경우이기 때문에 제외해줌)
		int ans = Math.abs(sourTaste - bitterTaste);
		if(idx == n && result > ans && bitterTaste != 0) {
			result = ans;
		}
	}
}