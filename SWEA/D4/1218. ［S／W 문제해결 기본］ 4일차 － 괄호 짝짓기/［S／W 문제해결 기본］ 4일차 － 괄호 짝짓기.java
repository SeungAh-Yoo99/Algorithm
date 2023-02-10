import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			sb.append("#" + test_case + " ");
			
			Stack<Character> stack = new Stack<>(); // 소괄호를 담을 스택
			
			// 테스트 케이스의 길이
			int n = Integer.parseInt(br.readLine());
			// 괄호문들 담을 배열
			char[] arr = br.readLine().toCharArray();
			
			boolean result = true;
			for (int i = 0; i < n; i++) {
				// 여는 괄호들은 스택에 추가해줌
				if(arr[i] == '(') stack.add('(');
				else if(arr[i] == '{') stack.add('{');
				else if(arr[i] == '[') stack.add('[');
				else if(arr[i] == '<') stack.add('<');
				
				else if(arr[i] == ')') {
					if(stack.empty()) result = false; // 스택이 비어있다면 false
					else { // 닫는 괄호들이 나왔을 때 스택의 top에는 닫는 괄호의 짝이 있어야 한다.
						char tmp = stack.pop();
						if(tmp != '(') result = false;
					}
				}
				
				else if(arr[i] == '}') {
					if(stack.empty()) result = false;
					else {
						char tmp = stack.pop();
						if(tmp != '{') result = false;
					}
				}
				
				else if(arr[i] == ']'){
					if(stack.empty()) result = false;
					else {
						char tmp = stack.pop();
						if(tmp != '[') result = false;
					}
				}
				
				else{
					if(stack.empty()) result = false;
					else {
						char tmp = stack.pop();
						if(tmp != '<') result = false;
					}
				}
				
				if(!result) break;
			}
			
			// 스택에 남아있는 괄호가 있다면
			if(!stack.empty()) result = false;
			
			if(result) sb.append(1 + "\n");
			else sb.append(0 + "\n");
		}
		
		// 출력
		System.out.println(sb);
	}

}