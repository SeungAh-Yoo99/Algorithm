import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] sequence;
	
	// 부분 수열에서 num보다 크거나 같은 수 중 가장 작은 값을 찾는 메소드
	private static int findIdx(int start, int end, int num) {
		
		if(start == end) return start;
		
		int mid = (start + end) / 2;
		if(sequence[mid] >= num) return findIdx(start, mid, num);
		else return findIdx(mid + 1, end, num);
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		sequence = new int[N + 1]; // 증가하는 부분 수열을 담을 배열
		int[] index = new int[N + 1];
		int length = 0; // 수열의 길이
		
		// 첫번째 수 수열에 추가
		sequence[1] = arr[0];
		index[0] = 1;
		length = 1;
		for (int i = 1; i < N; i++) {
			// 수열의 마지막 수보다 작은 수를 발견했다면
			if(arr[i] < sequence[length]) {
				// 부분 수열 중, arr[i]보다 크거나 같은 수 중 가장 작은 값을 찾아 그 자리에 저장
				int idx = findIdx(1, length, arr[i]);
				sequence[idx] = arr[i];
				index[i] = idx;
			}
			
			// 수열의 마지막 수보다 큰 수를 발견했다면
			else if(arr[i] > sequence[length]) {
				// 수열에 추가
				sequence[++length] = arr[i];
				index[i] = length;
			}
		}
		
		// arr를 거꾸로 확인하며, sequence[idx]보다 큰 수를 발견하면 result에 넣는다.
		int[] result = new int[length + 1];
		int idx = length;
		for (int i = N - 1; i >= 0; i--) {
			if(index[i] == idx) result[idx--] = arr[i];
		}
		
		// 출력
		sb.append(length + "\n");
		for (int i = 1; i <= length; i++) {
			sb.append(result[i] + " ");
		}
		System.out.println(sb);
	}

}