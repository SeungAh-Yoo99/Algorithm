import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static StringBuilder sb;
	
	static int M;
	static ArrayList<Integer> list;
	static int[] result;
	
	public static void pick(int idx, int n) {
		
		if(idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = n; i < list.size(); i++) {
			result[idx] = list.get(i);
			pick(idx + 1, i);
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// arr 정렬
		Arrays.sort(arr);
		
		// arr에서 중복되는 값 제거
		list = new ArrayList<>();
		list.add(arr[0]);
		for (int i = 1; i < N; i++) {
			if(arr[i] != arr[i - 1]) list.add(arr[i]);
		}
		
		// 재귀로 M개의 수 오름차순으로 고르기
		result = new int[M];
		pick(0, 0);
		
		// 출력
		System.out.println(sb);
	}

}