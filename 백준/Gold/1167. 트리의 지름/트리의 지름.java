import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int V;
	static ArrayList<ArrayList<int[]>> list;
	static boolean[] visited;
	static long result;
	
	private static int maxLength(int node) {
		
		ArrayList<int[]> nodeList = list.get(node);
		int size = nodeList.size();
		
		int[] child = new int[size + 1];
		
		for (int i = 0; i < size; i++) {
			int[] next = nodeList.get(i);
			
			if(!visited[next[0]]) {
				visited[next[0]] = true;
				child[i] = maxLength(next[0]) + next[1];
			}
		}
		
		Arrays.sort(child);
		
		result = Math.max(result, child[size] + child[size - 1]);
		
		return child[size];
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 입력
		V = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		for (int i = 0; i <= V; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			while(true) { // -1이 입력될 때까지 입력
				int b = Integer.parseInt(st.nextToken());
				if(b == -1) break;
				int c = Integer.parseInt(st.nextToken());
				list.get(a).add(new int[] {b, c});
			}
		}
		visited = new boolean[V + 1];
		
		visited[1] = true;
		maxLength(1);
		
		System.out.println(result);
	}

}