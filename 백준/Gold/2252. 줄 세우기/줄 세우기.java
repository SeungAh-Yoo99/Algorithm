import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		int[] in_degree = new int[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			in_degree[b]++;
			list.get(a).add(b);
		}
		
		// 위상 정렬
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if(in_degree[i] == 0) {
				q.add(i);
				result.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for (int i = 0; i < list.get(now).size(); i++) {
				int next = list.get(now).get(i);
				
				if(in_degree[next] > 1) {
					in_degree[next]--;
				}
				else if(in_degree[next] == 1) {
					in_degree[next]--;
					q.add(next);
					result.add(next);
				}
			}
			
		}
		
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i) + " ");
		}
		System.out.println(sb);
	}

}