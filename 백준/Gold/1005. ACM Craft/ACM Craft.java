import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] cost;
	static ArrayList<ArrayList<Integer>> list;
	
	private static int bfs(int start) {
		
		int[] visited = new int[N + 1];
		visited[start] = cost[start];
		
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		int result = cost[start];
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			ArrayList<Integer> al = list.get(now);
			for (int i = 0; i < al.size(); i++) {
				int next = al.get(i);
				if(visited[next] < visited[now] + cost[next]) {
					visited[next] = visited[now] + cost[next];
					result = Math.max(result, visited[next]);
					q.add(next);
				}
			}
		}
		
		return result;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			cost = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			list = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				list.add(new ArrayList<>());
			}
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				list.get(Y).add(X);
			}
			
			int W = Integer.parseInt(br.readLine());
			
			sb.append(bfs(W) + "\n");
		}
		
		System.out.println(sb);
	}

}