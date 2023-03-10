import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		boolean[] arr = new boolean[21];
		
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			if(command.equals("add")) {
				int x = Integer.parseInt(st.nextToken());
				arr[x] = true;
			}
			else if(command.equals("remove")) {
				int x = Integer.parseInt(st.nextToken());
				arr[x] = false;
			}
			else if(command.equals("check")) {
				int x = Integer.parseInt(st.nextToken());
				if(arr[x]) sb.append("1\n");
				else sb.append("0\n");
			}
			else if(command.equals("toggle")) {
				int x = Integer.parseInt(st.nextToken());
				arr[x] = !arr[x];
			}
			else if(command.equals("all")) Arrays.fill(arr, true);
			else if(command.equals("empty")) Arrays.fill(arr, false);
		}
		
		System.out.println(sb);
	}

}