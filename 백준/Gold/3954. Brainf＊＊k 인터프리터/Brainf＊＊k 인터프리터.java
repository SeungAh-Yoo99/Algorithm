import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int sm; // 메모리 배열 크기
	static int si; // 입력의 크기
	
	static int[] arr; // 배열
	static char[] code;  // 명령
	static char[] input;  // 입력
	static int[] bracket; // 각 괄호의 짝 인덱스
	
	static int p; // 포인터
	static int codeIdx; // 실행할 명령 인덱스
	static int inputIdx; // 다음 입력 인덱스
	
	private static void command() { // 명령을 수행하는 메소드
		switch (code[codeIdx]) {
		
		case '-': { // 포인터가 가리키는 수를 1 감소시킨다.
			arr[p] = arr[p] == 0 ? 255 : arr[p] - 1;
			break;
		}
		
		case '+': { // 포인터가 가리키는 수를 1 증가시킨다.
			arr[p] = arr[p] == 255 ? 0 : arr[p] + 1;
			break;
		}
		
		case '<': { // 포인터를 왼쪽으로 한 칸 움직인다.
			p = p == 0 ? sm - 1 : p - 1;
			break;
		}
		
		case '>': { // 포인터를 오른쪽으로 한 칸 움직인다.
			p = p == sm - 1 ? 0 : p + 1;
			break;
		}
		case '[': { // 만약 포인터가 가리키는 수가 0이라면, [ 와 짝을 이루는 ] 의 다음 명령으로 점프한다.
			if(arr[p] == 0) { // 루프에 걸리지 않음
				codeIdx = bracket[codeIdx];
			}
			break;
		}
		case ']': { // 만약 포인터가 가리키는 수가 0이 아니라면, ] 와 짝을 이루는 [ 의 다음 명령으로 점프한다.
			if(arr[p] != 0) { // 루프에 걸림
				codeIdx = bracket[codeIdx];
			}
			break;
		}
		case '.': { // 포인터가 가리키는 수를 출력한다.
			// 실제로는 아무일도 하지 않음
			break;
		}
		case ',': { // 문자 하나를 읽고 포인터가 가리키는 곳에 저장한다.
			arr[p] = inputIdx == si ? 255 : input[inputIdx++];
			break;
		}
		}
		codeIdx++;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			// 입력
			st = new StringTokenizer(br.readLine());
			sm = Integer.parseInt(st.nextToken()); // 메모리 배열 크기
			int sc = Integer.parseInt(st.nextToken()); // 프로그램 코드 크기
			si = Integer.parseInt(st.nextToken()); // 입력의 크기
			
			arr = new int[sm]; // 배열
			code = new char[sc]; // 명령
			input = new char[si]; // 입력
			
			code = br.readLine().toCharArray();
			input = br.readLine().toCharArray();
			
			// 각 괄호의 짝 인덱스 구하기
			bracket = new int[sc]; // '['의 위치에는 연결되는 ']'의 인덱스를, ']'의 위치에는 연결되는 '['의 인덱스를 저장함
			Stack<Integer> stack = new Stack<>(); // 괄호를 담아둘 스택
			for (int i = 0; i < bracket.length; i++) {
				if(code[i] == '[') stack.push(i); // 여는 괄호면 스택에 담고
				else if(code[i] == ']') { // 닫는 괄호면
					int start = stack.pop(); // 짝이 되는 여는 괄호를 꺼내고
					bracket[start] = i; // 각 인덱스에 서로의 인덱스를 저장
					bracket[i] = start;
				}
			}
			
			p = 0; // 프로그램 수행 전 포인터가 가리키는 칸은 0
			codeIdx = 0; // 실행할 명령 인덱스
			inputIdx = 0; // 다음 입력 인덱스
			int count = 0; // 명령 수행 횟수
			
			// 무한 루프에 빠지지 않고 모든 명령을 실행했거나
			// 명령을 5천만번 이상 실행했을 경우 반복문을 빠져나옴
			while(codeIdx < sc && count <= 50_000_000) {
				command();
				count++;
			}
			
			// 답 저장
			if(codeIdx == sc) sb.append("Terminates\n");
			else { // 무한루프에 빠졌다면
				/*
				 * 마지막으로 명령을 수행했던 곳에서 다시 5천만번의 명령을 수행하며
				 * 가장 마지막 인덱스까지 간 곳이 루프의 닫는 괄호이고
				 * 가장 앞 인덱스까지 간 곳의 앞 칸이 루프의 여는 괄호 위치이다,
				 * 
				 */
				int s = codeIdx;
				int e = codeIdx;
				while(count-- > 0) { // 어디 루프에 빠졌는지 구한다
					command();
					s = Math.min(s, codeIdx);
					e = Math.max(e, codeIdx);
				}
				sb.append("Loops " + (s - 1) + " " + e + "\n");
			}
		}
		
		// 출력
		System.out.println(sb);
	}

}