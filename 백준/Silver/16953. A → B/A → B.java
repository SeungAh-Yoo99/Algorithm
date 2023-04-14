import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int result = 1;
		
		while(A != B) {
			
			if(B < A) {
				result = -1;
				break;
			}
			
			if(B % 10 == 1) B /= 10;
			else if(B % 2 == 0) B /= 2;
			else {
				result = -1;
				break;
			}
			
			result++;
		}
		
		System.out.println(result);
	}

}