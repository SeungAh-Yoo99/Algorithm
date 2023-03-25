import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static ArrayList<ArrayList<int[]>> nodeList;
	
	private static int dijkstra(int start, int end) {
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		int[] minDis= new int[N + 1];
		Arrays.fill(minDis, Integer.MAX_VALUE);
		
		pq.add(new int[] {start, 0});
		minDis[start] = 0;
		
		while(!pq.isEmpty()) {
			int[] node = pq.poll();
			int now = node[0];
			int cost = node[1];
			
			if(now == end) {
				return minDis[end];
			}
			
			ArrayList<int[]> list = nodeList.get(now);
			for (int i = 0; i < list.size(); i++) {
				int[] next = list.get(i);
				
				if(minDis[next[0]] > cost + next[1]) {
					minDis[next[0]] = cost + next[1];
					pq.add(new int[] {next[0], cost + next[1]});
				}
			}
		}
		
		return -1;
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		nodeList = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			nodeList.add(new ArrayList<>());
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			nodeList.get(a).add(new int[] {b, c});
			nodeList.get(b).add(new int[] {a, c});
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		// 각 구간 별 최소 경로 구하기
		int v1Tov2 = dijkstra(v1, v2); // v1과 v2로 향하는 경로
		
		int OneTov1 = dijkstra(1, v1); // 1과 v1으로 향하는 경로
		int v2ToN = dijkstra(v2, N); // v2에서 N으로 향하는 경로
		
		int OneTov2 = dijkstra(1, v2); // 1과 v2으로 향하는 경로
		int v1ToN = dijkstra(v1, N); // v1에서 N으로 향하는 경로
		
		// 답 구하기
		int result = 0;
		if(v1Tov2 == -1) { // v1에서 v2로 가는 경로가 없다면 두 개의 정점을 지나는 최단 경로는 없다
			result = -1;
		}
		// 1 -> v1 -> v2 -> N으로 가는 경로와
		// 1 -> v2 -> v1 -> N으로 가는 경로가 모두 불가능하다면 답은 -1
		else if((OneTov1 == -1 || v2ToN == -1) && (OneTov2 == -1 || v1ToN == -1)){
			result = -1;
		}
		else {
			// 1 -> v1 -> v2 -> N으로 가는 경로가 없을 경우
			if(OneTov1 == -1 || v2ToN == -1) result = OneTov2 + v1Tov2 + v1ToN;
			// 1 -> v2 -> v1 -> N으로 가는 경로가 없을 경우
			else if(OneTov2 == -1 || v1ToN == -1) result = OneTov1 + v1Tov2 + v2ToN;
			// 두 경로 모두 가능할 경우
			else {
				int root1 = OneTov1 + v1Tov2 + v2ToN;
				int root2 = OneTov2 + v1Tov2 + v1ToN;
				result = Math.min(root1, root2);
			}
		}
		
		System.out.println(result);
	}

}