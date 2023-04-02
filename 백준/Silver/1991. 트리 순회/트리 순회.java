import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static char[][] tree;
	
	private static void preorder(int node, StringBuilder sb) {
		
		sb.append(tree[node][0]);
		
		if(tree[node][1] != '.') preorder(tree[node][1] - 'A', sb);
		if(tree[node][2] != '.') preorder(tree[node][2] - 'A', sb);
	}
	
	private static void inorder(int node, StringBuilder sb) {
		
		if(tree[node][1] != '.') inorder(tree[node][1] - 'A', sb);
		
		sb.append(tree[node][0]);
		
		if(tree[node][2] != '.') inorder(tree[node][2] - 'A', sb);
	}
	
	private static void postorder(int node, StringBuilder sb) {
		
		if(tree[node][1] != '.') postorder(tree[node][1] - 'A', sb);
		if(tree[node][2] != '.') postorder(tree[node][2] - 'A', sb);
		
		sb.append(tree[node][0]);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		tree = new char[26][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int node = st.nextToken().toCharArray()[0] - 'A';
			tree[node][0] = (char) (node + 'A');
			tree[node][1] = st.nextToken().toCharArray()[0];
			tree[node][2] = st.nextToken().toCharArray()[0];
		}
		
		// 전위 순회
		preorder(0, sb);
		sb.append("\n");
		
		// 중위 순회
		inorder(0, sb);
		sb.append("\n");
		
		// 후위 순회
		postorder(0, sb);
		sb.append("\n");
		
		System.out.println(sb);
	}

}