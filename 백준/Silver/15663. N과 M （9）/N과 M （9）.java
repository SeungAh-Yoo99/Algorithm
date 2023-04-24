import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] arr;
	static int[] subArr;
	static boolean[] visited;
	static ArrayList<int[]> result;
	
	private static void sub(int n, int m) {
		
		if(m == M) {
			boolean flag = false; // result에 subArr와 같은 수열이 없다면 false
			for (int i = 0; i < result.size(); i++) {
					boolean f = true; // 현재 탐색 중인 배열이 subArr와 같다면 true
					for (int j = 0; j < M; j++) {
						if(result.get(i)[j] != subArr[j]) {
							f = false;
							break;
						}
					}
					if(f) {
						flag = true;
						break;
					}
			}
			if(!flag) {
				result.add(subArr.clone());
			}
			
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				subArr[m] = arr[i];
				visited[i] = true;
				sub(i + 1, m + 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		subArr = new int[M];
		visited = new boolean[N];
		
		result = new ArrayList<>();
		
		sub(0, 0);
		
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < M; j++) {
				sb.append(result.get(i)[j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}