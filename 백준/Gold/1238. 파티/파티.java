import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int X;
	static int[] time;
	
	private static void dijkstra(ArrayList<ArrayList<int[]>> list) {
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
		
		int[] minDis = new int[N + 1];
		Arrays.fill(minDis, Integer.MAX_VALUE);
		
		pq.add(new int[] {X, 0});
		minDis[X] = 0;
		
		
		while(!pq.isEmpty()) {
			int[] node = pq.poll();
			int now = node[0];
			int cost = node[1];
			
			ArrayList<int[]> tmpList = list.get(now);
			for (int i = 0; i < tmpList.size(); i++) {
				int[] next = tmpList.get(i);
				if(minDis[next[0]] > cost + next[1]) {
					minDis[next[0]] = cost + next[1];
					pq.add(new int[] {next[0], cost + next[1]});
				}
			}
			
		}
		for (int i = 1; i <= N; i++) {
			time[i] += minDis[i];
		}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<int[]>> nodeList = new ArrayList<>();
		ArrayList<ArrayList<int[]>> reverseNodeList = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			nodeList.add(new ArrayList<>());
			reverseNodeList.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			nodeList.get(a).add(new int[] {b, c}); // X에서 각 마을로 갈 때 사용할 array
			reverseNodeList.get(b).add(new int[] {a, c}); // 각 마을에서 X로 갈 때 사용할 array
		}
		
		time = new int[N + 1];
		
		dijkstra(nodeList); // X에서 각 마을로 갈 때 걸리는 시간 구하기
		dijkstra(reverseNodeList); // 각 마을에서 X로 갈 때 걸리는 시간 구하기
		
		
		int result = 0;
		for (int t : time) {
			result = Math.max(result, t);
		}
		System.out.println(result);
	}

}