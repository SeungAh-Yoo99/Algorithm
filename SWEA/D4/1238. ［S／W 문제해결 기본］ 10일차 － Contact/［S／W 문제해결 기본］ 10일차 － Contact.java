import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static ArrayList<ArrayList<Integer>> nodeList;
	static ArrayList<ArrayList<Integer>> depth;
	static boolean[] visited;
	static int d;
	
	private static void bfs(int start) {
		visited[start] = true;
		
		Queue<Integer> q1 = new LinkedList<>();
		
		d = 1; // depth
		q1.add(start);
		while(true) {
			Queue<Integer> q2 = new LinkedList<>(); // 다음 depth의 노드를 담을 큐
			
			while(!q1.isEmpty()) { // 현재 depth의 노드를 담은 큐가 빌 때까지
				int node = q1.poll(); // 현재 depth의 노드를 하나 꺼내옴
				
				ArrayList<Integer> list = nodeList.get(node); // node에 연결된 노드들 리스트를 가져온다
				for (int i = 0; i < list.size(); i++) { // 노드들을 하나씩 확인하면서
					int n = list.get(i);
					if(!visited[n]) { // 방문하지 않은 노드라면
						visited[n] = true; // 방문 처리해주고
						depth.get(d).add(n); // depth list에 넣어줌
						q2.add(n); // 다음 depth 큐에 담아줌
					}
				}
			}
			
			if(q2.isEmpty()) break; // 다음 depth가 없다면 반복문 탈출
			else {
				d++;
				q1 = q2;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			// 입력 받는 데이터의 길이 N, 시작점 start 입력
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			nodeList = new ArrayList<>();
			depth = new ArrayList<>();
			visited = new boolean[101];
			for (int i = 0; i <= 100; i++) {
				nodeList.add(new ArrayList<>());
				depth.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				nodeList.get(a).add(b);
			}
			
			// bfs로 방문한 노드 depth 확인
			bfs(start);
			
			// 가장 큰 depth를 가진 노드 중 번호가 가장 큰 사람을 구한다
			int result = 0;
			ArrayList<Integer> maxDepth = depth.get(d - 1);
			for (int i = 0; i < maxDepth.size(); i++) {
				result = Math.max(result, maxDepth.get(i));
			}
			
			
			sb.append("#" + test_case + " " + result + "\n");
		}
		System.out.println(sb);
	}

}
