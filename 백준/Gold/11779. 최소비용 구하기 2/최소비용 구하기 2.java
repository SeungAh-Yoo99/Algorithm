import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int m;
	static ArrayList<ArrayList<int[]>> nodeList;
	static int start;
	static int end;
	static int[] resultArray;
	static int resultCost;
	
	private static void dijstra() {
		
		PriorityQueue<int[][]> pq = new PriorityQueue<>((o1, o2) -> o1[0][1] - o2[0][1]);
		
		int[] tmp = new int[2];
		tmp[0] = 1;
		tmp[tmp[0]] = start;
		
		pq.add(new int[][] {{start, 0}, tmp.clone()});
		
		int[] minCost = new int[n + 1];
		Arrays.fill(minCost, Integer.MAX_VALUE);
		minCost[start] = 0;
		
		while(!pq.isEmpty()) {
			int[][] node = pq.poll();
			int now = node[0][0];
			int cost = node[0][1];
			int[] visited = node[1];
			
			if(now == end) {
				resultArray = visited;
				resultCost = minCost[end];
				return;
			}
			
			ArrayList<int[]> list = nodeList.get(now);
			
			for (int i = 0; i < list.size(); i++) {
				int[] next = list.get(i);
				
				if(minCost[next[0]] > cost + next[1]) {
					minCost[next[0]] = cost + next[1];
					
					int[] t = new int[visited[0] + 2];
					for (int j = 1; j <= visited[0]; j++) {
						t[j] = visited[j];
					}
					t[0] = visited[0] + 1;
					t[t[0]] = next[0];
					
					if(next[0] == end) {
						resultArray = t;
						resultCost = minCost[end];
					}
					
					pq.add(new int[][] {{next[0], cost + next[1]}, t});
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 입력
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		nodeList = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			nodeList.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			nodeList.get(a).add(new int[] {b, c});
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijstra();
		
		sb.append(resultCost + "\n");
		sb.append(resultArray[0] + "\n");
		for (int i = 1; i <= resultArray[0]; i++) {
			sb.append(resultArray[i] + " ");
		}
		System.out.println(sb);
	}

}