import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb;
	static int n;
	static int[] inOrder;
	static int[] postOrder;
	
	private static void preOrder(int is, int ie, int ps, int pe) {
		
		if(is > ie) return;
		
		// 포스트오더의 가장 마지막은 프리오더의 가장 처음
		sb.append(postOrder[pe] + " ");
		
		// 인오더에서 pe를 찾는다
		int parent = 0;
		for (int i = is; i <= ie; i++) {
			if(inOrder[i] == postOrder[pe]) {
				parent = i;
				break;
			}
		}
		
		// 인오더에서 pe를 기준으로 왼쪽 서브트리 개수와 오른쪽 서브트리 개수
		int leftCount = parent - is;
		int rightCount = ie - parent;
		
		// pe를 기준으로 왼쪽 서브트리, 오른쪽 서브트리 재귀
		preOrder(is, parent - 1, ps, ps + leftCount - 1);
		preOrder(parent + 1, ie, pe - rightCount, pe - 1);
	}

	public static void main(String arg[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		// 입력
		n = Integer.parseInt(br.readLine());
		
		inOrder = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
		}
		
		postOrder = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
		}
		
		// 프리오더 구하기
		preOrder(0, n - 1, 0, n - 1);
		
		// 출력
		System.out.println(sb);
	}
}