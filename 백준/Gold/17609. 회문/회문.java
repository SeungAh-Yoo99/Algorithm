import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static char[] string;
	static boolean flag;
	static int result;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			string = br.readLine().toCharArray();
			
			flag = true;
			result = 0;
			
			test(0, string.length - 1);
			
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}
	
	private static boolean test(int s, int e) {

		while(s < e) {
			if(string[s] == string[e]) {
				s++;
				e--;
			}
			else if(flag) {
				flag = false;
				
				if(test(s + 1, e)) {
					result = 1;
					return true;
				}
				else if(test(s, e - 1)) {
					result = 1;
					return true;
				}
				else {
					result = 2;
					return false;
				}
			}
			else {
				result = 2;
				return false;
			}
		}
		
		return true;
	}

}