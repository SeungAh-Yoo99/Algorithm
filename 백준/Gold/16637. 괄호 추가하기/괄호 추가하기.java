import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N; // 수식의 길이
	static Long[] num; // 정수 넣을 배열
	static char[] operator; // 연산자 넣을 배열
	static boolean[] parenthesis; // 인덱스에 해당하는 연산자를 괄호로 묶을 것인지 아닌지
	static long result = Long.MIN_VALUE; // 답
	static long tmpResult;
	
	// 현재 연산자를 괄호로 묶는 경우, 아닌 경우를 구하는 dfs. 연산자의 인덱스를 파라미터로 받음
	private static void dfs(int idx) {
		if(idx == N / 2) { // 괄호로 묶을 연산자를 다 골랐다면
			calculation(); // 계산하러 감
			result = Math.max(result, tmpResult);
			return;
		}
		
		// idx 연산자를 괄호로 묶지 않는 경우
		dfs(idx + 1);
		// idx 연산자를 괄호로 묶는 경우
		if(idx == 0 || (idx > 0 && !parenthesis[idx - 1])) { // 전 연산자가 괄호로 묶이지 않았을 때만 묶을 수 있음
			parenthesis[idx] = true;
			dfs(idx + 1);
			parenthesis[idx] = false;
		}
	}
	
	private static void calculation() { // 괄호 여부에 따라 연산하는 메소드		
		Long[] tmpNum = num.clone(); // 정수 배열 딥카피
		
		// 괄호로 묶은 연산 먼저 진행
		for (int i = 0; i < N / 2; i++) {
			if(parenthesis[i]) { // 괄호로 묶인 연산이라면
				if(operator[i] == '+') tmpNum[i] += tmpNum[i + 1];
				else if(operator[i] == '-') tmpNum[i] -= tmpNum[i + 1];
				else tmpNum[i] *= tmpNum[i + 1];
				tmpNum[i + 1] = null; // 연산이 끝났다는 표시로 최대값 저장
			}
		}
		
		// 나머지 연산 진행
		tmpResult = tmpNum[0];
		int numIdx = 1; // 다음 연산할 정수 인덱스
		int opIdx = 0; // 다음 연산자 인덱스
		while(numIdx < N / 2 + 1 && opIdx < N / 2) {
			long a = 0; // 다음 연산할 정수
			while(numIdx < N / 2 + 1) { // 다음으로 계산할 정수를 찾는다
				if(tmpNum[numIdx] != null) { // 아직 계산하지 않은 정수를 찾았다면
					a = tmpNum[numIdx]; // 저장해주고 반복문 탈출
					break;
				}
				numIdx++;
			}
			if(numIdx == N / 2 + 1) break; // 연산이 끝난 경우
			
			char op = 0; // 다음 연산자
			while(opIdx < N / 2) { // 다음 연산자를 찾는다.
				if(!parenthesis[opIdx]) { // 아직 사용하지 않은 연산자를 찾았다면
					op = operator[opIdx]; // 저장해주고 반복문 탈출
					break;
				}
				opIdx++;
			}
			
			// 연산
			if(op == '+') tmpResult += a;
			else if(op == '-') tmpResult -= a;
			else tmpResult *= a;
			
			numIdx++;
			opIdx++;
		}
		
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		N = Integer.parseInt(br.readLine());
		num = new Long[N / 2 + 1];
		operator = new char[N / 2];
		parenthesis = new boolean[N / 2];
		char[] input = br.readLine().toCharArray();
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if(i % 2 == 0) num[idx] = (long) input[i] - '0';
			else {
				operator[idx] = input[i];
				idx++;
			}
		}
		
		// dfs로 괄호 묶을 수 있는 경우를 모두 구해서 최대값 구하기
		dfs(0);
		
		// 출력
		System.out.println(result);
	}

}