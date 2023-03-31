import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 입력
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			edge.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edge.get(a).add(b);
			edge.get(b).add(a);
		}
		
		// 부모 구하기
		int[] parent = new int[N + 1];
		parent[1] = -1; // 1번 노드를 루트 노드로 표시
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for (int i = 0; i < edge.get(now).size(); i++) {
				int child = edge.get(now).get(i);
				
				if(parent[child] == 0) {
					parent[child] = now;
					q.add(child);
				}
			}
		}
		
		// 출력
		for (int i = 2; i <= N; i++) {
			sb.append(parent[i] + "\n");
		}
		System.out.println(sb);
	}

}