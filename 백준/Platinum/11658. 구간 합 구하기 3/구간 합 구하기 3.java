import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] fenwick_tree;
	
	private static void update(int row, int idx, int value1, int value2) {
		
		while(idx <= N) {
			fenwick_tree[row][idx] = fenwick_tree[row][idx] - value1 + value2;
			idx += idx & -idx;
		}
		
	}
	
	private static int sum(int x1, int y1, int x2, int y2) {
		
		int r = 0;
		for (int i = x1; i <= x2; i++) {
			int idx1 = y1 - 1;
			int idx2 = y2;
			
			// 1 ~ y2 누적합 구하기
			int tmp2 = 0;
			while(idx2 > 0) {
				tmp2 += fenwick_tree[i][idx2];
				idx2 -= idx2 & -idx2;
			}
			
			// 1 ~ y1 누적합 구하기
			int tmp1 = 0;
			while(idx1 > 0) {
				tmp1 += fenwick_tree[i][idx1];
				idx1 -= idx1 & - idx1;
			}
			
			r += tmp2 - tmp1;
		}
		
		return r;
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N + 1][N + 1];
		fenwick_tree = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				update(i, j, 0, arr[i][j]);
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			
			if(w == 0) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				update(x, y, arr[x][y], c);
				arr[x][y] = c;
			}
			
			else if(w == 1) {
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				sb.append(sum(x1, y1, x2, y2) + "\n");
			}
		}
		
		System.out.println(sb);
	}

}