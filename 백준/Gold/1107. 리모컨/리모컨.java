import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 입력
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean[] broken = new boolean[10];
		if(M != 0) st = new StringTokenizer(br.readLine()); // 고장난 버튼이 있을 때만 입력 받음
		for (int i = 0; i < M; i++) {
			broken[Integer.parseInt(st.nextToken())] = true;
		}
		
		int result = Math.abs(N - 100); // 나올 수 있는 최대 값
		if(N != 100) { // 이동하려고 하는 채널이 100이면 이미 보고 있는 채널이 100이기 때문에 구하지 않아도 됨
			int[] arr = new int[2];
for1:		for (int i = 0; i <= Math.abs(N - 100); i++) {
				arr[0] = Math.max(N - i, 0); // N보다 작은 채널에서 +로 채널 이동하는 경우
				arr[1] = N + i; // N보다 큰 채널에서 -로 채널 이동하는 경우
				for (int a : arr) {
					boolean flag = true; // a 채널로 가기 위해 모든 숫자 버튼을 누를 수 있으면 true
					for (int j = 1; j <= String.valueOf(a).length(); j++) {
						int idx = (int) ((a % Math.pow(10, j)) / Math.pow(10, j - 1)); // a의 j-1 자릿수 가져오기
						if(broken[idx]) { // 고장나있는 버튼이 있다면
							flag = false;
							break;
						}
					}
					if(flag) { // 버튼을 모두 누를 수 있다면
						result = Math.min(result, i + String.valueOf(a).length());
						break for1;
					}
				}
			}
		}

		System.out.println(result);
	}

}