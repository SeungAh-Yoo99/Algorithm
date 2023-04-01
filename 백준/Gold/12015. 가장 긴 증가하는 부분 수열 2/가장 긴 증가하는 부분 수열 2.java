import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] partial;
	
	private static int search(int start, int end, int find) {
		
		if(start == end) return start;
		
		int mid = (start + end) / 2;
		
		if(partial[mid] >= find) {
			return search(start, mid, find);
		}
		else {
			return search(mid + 1, end, find);
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		partial = new int[N + 1];
		partial[1] = arr[0];
		int length = 1;
		
		for (int i = 0; i < N; i++) {
			if(partial[length] < arr[i]) {
				partial[++length] = arr[i];
			}
			else if(partial[length] > arr[i]) {
				int idx = search(1, length, arr[i]);
				partial[idx] = arr[i];
			}
		}
		
		System.out.println(length);
	}

}