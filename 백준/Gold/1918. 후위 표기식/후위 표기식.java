import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] median = br.readLine().toCharArray();
		
		Stack<Character> stack = new Stack<>();
	
		for (int i = 0; i < median.length; i++) {
			if(median[i] == '+' || median[i] == '-') {
				while(!stack.isEmpty() && stack.peek() != '(') sb.append(stack.pop());
				stack.push(median[i]);
			}
			else if(median[i] == '*' || median[i] == '/') {
				if(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')) sb.append(stack.pop());
				stack.push(median[i]);
			}
			else if(median[i] == '(') {
				stack.push(median[i]);
			}
			else if(median[i] == ')') {
				while(stack.peek() != '(') sb.append(stack.pop());
				stack.pop();
			}
			else {
				sb.append(median[i]);
			}
		}
		
		while(!stack.isEmpty()) sb.append(stack.pop());
		
		// 출력
		System.out.println(sb);
	}

}