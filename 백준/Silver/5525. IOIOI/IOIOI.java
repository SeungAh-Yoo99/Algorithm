import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] S = br.readLine().toCharArray();
		
		int result = 0;
		int start = 0, end = 0;
		while(start < M && end < M - 2) {
			if(S[start] !=  'I') { // P의 시작 위치 찾기
				start++;
				end = start;
			}
			else {
				int c = 0; // OI가 연속으로 오는 횟수
				while(end < M - 2 && c != N) { // P_N 이 되는 문자열 찾기
					if(S[end + 1] != 'O' || S[end + 2] !='I') {
						start++;
						end = start;
						break;
					}
					end += 2;
					c++;
				}
				
				if(c == N) { // P_N을 찾았다면
					result++; // 답 증가시켜주고
					while(end < M - 2) { // 뒤로 또 OI 문자열이 있다면 계속 답 증가시켜줌
						if(S[end + 1] != 'O' || S[end + 2] !='I') break;
						else {
							end += 2;
							result++;
						}
					}
					start = end;
				}
			}
		}
		// 출력
		System.out.println(result);
	}

}