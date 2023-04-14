import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		long result = -1;
		
		Queue<long[]> q = new LinkedList<>();
		boolean[] visited = new boolean[B + 1];
		
		q.add(new long[] {A, 1});
		visited[A] = true;
		
		while(!q.isEmpty()) {
			long now[] = q.poll();
			
			if(now[0] * 2 == B || now[0] * 10 + 1 == B) {
				result = now[1] + 1;
				break;
			}
			
			if(now[0] * 2 < B && !visited[(int)now[0] * 2]) {
				visited[(int) now[0] * 2] = true;
				q.add(new long[] {now[0] * 2, now[1] + 1});
			}
			
			if(now[0] * 10 + 1 < B && !visited[(int) now[0] * 10 + 1]) {
				visited[(int) now[0] * 10 + 1] = true;
				q.add(new long[] {now[0] * 10 + 1, now[1] + 1});
			}
		}
		
		System.out.println(result);
	}

}