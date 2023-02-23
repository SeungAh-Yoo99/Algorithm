import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb;
	static int N;
	static int M;
	static int V;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	
	private static void dfs(int start) {
		
		visited[start] = true;
		sb.append(start + " ");
		
		ArrayList<Integer> l = list.get(start);
		
		for(int i = 0; i < l.size(); i++) {
			if(!visited[l.get(i)]) dfs(l.get(i));
		}
	}
	
	private static void bfs() {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(V);
		
		visited[V] = true;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			sb.append(node + " ");
			
			ArrayList<Integer> l = list.get(node);
			for(int i = 0; i < l.size(); i++) {
				if(!visited[l.get(i)]) {
					q.add(l.get(i));
					visited[l.get(i)] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		// 정점의 개수 N, 간선의 개수 M, 탐색을 시작할 정점의 번호 V 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		// 간선의 정보를 담을 리스트
		list = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<>());
		}
		
		// 간선 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		// 리스트 정렬
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(list.get(i));
		}
		
		// dfs
		visited = new boolean[N + 1];
		dfs(V);
		sb.append("\n");
		
		// bfs
		visited = new boolean[N + 1];
		bfs();
		
		// 출력
		System.out.println(sb);
	}

}