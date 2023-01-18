import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		// 종료 시간 기준으로 정렬
		// 빨리 끝나는 회의들이 많을수록 더 많은 회의를 진행할 수 있으므로 종료 시간을 기준으로 정렬한다.
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[1] != b[1] ? a[1] - b[1] : a[0] - b[0];
			}
		});
		
		int count = 0;
		int end = 0;
		
		for(int i = 0; i < n; i++) {
			if (end <= arr[i][0]) {
				count++;
				end = arr[i][1];
			}
		}

		System.out.println(count);

	}
	
}