import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int[] parent = new int[V + 1]; // 인덱스에 해당하는 노드의 부모 정보
			ArrayList<ArrayList<Integer>> child = new ArrayList<>(); // 자식 정보
			for (int i = 0; i <= V; i++) {
				child.add(new ArrayList<>());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				parent[c] = p;
				child.get(p).add(c);
			}
			
			// a의 조상 노드 구하기
			ArrayList<Integer> ancestor = new ArrayList<>();
			int cur = a;
			while(cur != 1) {
				ancestor.add(parent[cur]);
				cur = parent[cur];
			}
			
			// b의 조상 노드를 따라가면 a와 공통조상 찾기
			cur = parent[b];
			int common = 0;
while1:		while(cur != 0) {
				for (int i = 0; i < ancestor.size(); i++) {
					if(cur == ancestor.get(i)) {
						common = cur;
						break while1;
					}
				}
				cur = parent[cur];
			}

			// 공통 조상을 루트로 하는 서브 트리의 크기
			int count = 1;
			Queue<Integer> q = new LinkedList<>();
			q.add(common);
			while(!q.isEmpty()) {
				int now = q.poll();
				
				for (int i = 0; i < child.get(now).size(); i++) {
					q.add(child.get(now).get(i));
					count++;
				}
			}
			
			sb.append("#" + tc + " " + common + " " + count + "\n");
		}
		
		System.out.println(sb);
	}

}