import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		int node;
		int cost;
		
		Node(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// N, R 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		// 연결된 간선들 정보 담을 ArrayList
		ArrayList<ArrayList<Node>> nodeList = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			nodeList.add(new ArrayList<>());
		}
		
		// 간선들 정보 입력
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			nodeList.get(a).add(new Node(b, c));
			nodeList.get(b).add(new Node(a, c));
		}
		
		// bfs를 위한 visited 배열
		boolean[] visited = new boolean[N + 1];
		
		int pillar = 0;
		int branch = 0;
		
		// bfs
		Queue<Node> q = new LinkedList<>();
		visited[R] = true;
		q.add(new Node(R, 0));
		boolean flag = true; // 아직 기둥
		while(!q.isEmpty()) {
			Node now = q.poll();
			ArrayList<Node> list = nodeList.get(now.node);
			
			int count = 0;
			for (int i = 0; i < list.size(); i++) {
				if(!visited[list.get(i).node]) {
					visited[list.get(i).node] = true;
					count++;
					q.add(new Node(list.get(i).node, now.cost + list.get(i).cost));
				}
			}
			if(flag && count >= 2) {
				pillar = now.cost;
				flag = false;
			}
			if(flag && count < 2) { // 현재 노드도 아직 기둥이라면
				pillar = now.cost;
			}
			else if(!flag && count == 0) { // 현재 노드가 리프 노드라면
				branch = Math.max(branch, now.cost - pillar);
			}
		}
		
		System.out.println(pillar + " " + branch);
	}
}