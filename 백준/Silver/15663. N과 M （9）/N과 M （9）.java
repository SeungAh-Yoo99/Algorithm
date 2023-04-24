import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[] arr;
	static int[] subArr;
	static boolean[] check;
	
	static List<List<Integer>> result = new ArrayList<>();
	static Set<List<Integer>> resultSet = new HashSet<>();
	
	private static void sub(int m) {
		
		if(m == M) {
			List<Integer> list = listOf(subArr);
			if(!resultSet.contains(list)) {
				result.add(list);
				resultSet.add(list);
			}
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!check[i]) {
				subArr[m] = arr[i];
				check[i] = true;
				sub(m + 1);
				check[i] = false;
			}
		}
	}
	
	private static List<Integer> listOf(int[] subArr) { // 배열을 ArrayList로 변환하는 메소드
		List<Integer> ret = new ArrayList<>();
		
		for (int i : subArr) {
			ret.add(i);
		}
		
		return ret;
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
		check = new boolean[N];
		
		sub(0);
		
		for (int i = 0; i < result.size(); i++) {
			for (int j = 0; j < M; j++) {
				sb.append(result.get(i).get(j) + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}