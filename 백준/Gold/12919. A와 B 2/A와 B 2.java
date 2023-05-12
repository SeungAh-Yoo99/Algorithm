import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder S = new StringBuilder(br.readLine());
		StringBuilder T = new StringBuilder(br.readLine());
		
		int result = 0;
		Queue<StringBuilder> q = new LinkedList<>();
		q.add(T);
		
		while(!q.isEmpty()) {
			StringBuilder sb1 = q.poll();
			StringBuilder sb2 = new StringBuilder(sb1);
			
			char[] c1 = sb1.toString().toCharArray();
			if(c1[c1.length - 1] == 'A') {
				sb1.delete(c1.length - 1, c1.length);
				if(sb1.length() == S.length() && sb1.toString().equals(S.toString())) {
					result = 1;
					break;
				}
				else if(sb1.length() > S.length()) q.add(sb1);
			}
			
			char[] c2 = sb2.toString().toCharArray();
			if(c1[0] == 'B') {
				sb2.reverse().delete(c2.length - 1, c2.length);
				if(sb2.length() == S.length() && sb2.toString().equals(S.toString())) {
					result = 1;
					break;
				}
				else if(sb2.length() > S.length()) q.add(sb2);
			}
		}
		
		System.out.println(result);
	}

}