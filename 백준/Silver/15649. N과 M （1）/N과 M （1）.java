import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int m;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb;
	
	public static void progression(int idx, int num) {
		arr[idx] = num;
		visited[num] = true;
		
		// 마지막 인덱스라면
		if(idx == m - 1) {
			for(int i = 0; i < m; i++)
				sb.append(arr[i] + " ");
			sb.append("\n");
			// 다시 방문 체크 풀어줌
			visited[num] = false;
			return;
		}
		
		// 방문한 적 없는 수면 재귀
		for(int i = 1; i <= n; i++) {
			if(!visited[i])
				progression(idx + 1, i);
		}
		
		// 다시 방문 체크 풀어줌
		visited[num] = false;
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// n, m 입력
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// 수열을 담을 배열 선언
		arr = new int[m];
		// 방문체크 하기 위한 배열 선언
		visited = new boolean[n + 1];
		
		// 수열 구하기
		sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			progression(0, i);
		}
		
		System.out.println(sb);
	}

}