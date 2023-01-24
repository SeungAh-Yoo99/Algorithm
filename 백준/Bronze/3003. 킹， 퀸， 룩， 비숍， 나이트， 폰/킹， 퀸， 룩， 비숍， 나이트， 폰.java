import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] arr = {1, 1, 2, 2, 2, 8};
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			arr[i] -= Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < 6; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}