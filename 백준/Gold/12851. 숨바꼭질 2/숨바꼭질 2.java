import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int time = 100_001;
		int count = 0;
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, N});
		
		int[] visited = new int[150_001];
		Arrays.fill(visited, 100_001);
		visited[N] = 0;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			if(now[0] > time) break;
			
			if(now[1] == K) {
				time = now[0];
				count++;
			}
			
			if(now[1] - 1 >= 0 && visited[now[1] - 1] >= now[0] + 1) { // - 1
				visited[now[1] - 1] = now[0] + 1;
				q.add(new int[] {now[0] + 1, now[1] - 1});
			}
			if(now[1] + 1 <= 150_000 && visited[now[1] + 1] >= now[0] + 1) { // + 1
				visited[now[1] + 1] = now[0] + 1;
				q.add(new int[] {now[0] + 1, now[1] + 1});
			}
			if(now[1] * 2 <= 150_000 && visited[now[1] * 2] >= now[0] + 1) { // * 2
				visited[now[1] * 2] = now[0] + 1;
				q.add(new int[] {now[0] + 1, now[1] * 2});
			}
		}
		
		System.out.println(time + "\n" + count);
	}

}