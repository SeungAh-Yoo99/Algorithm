import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] weight;
	static boolean[] arr;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// k 입력, 추의 무게를 담는 weight 배열 생성
		int k = Integer.parseInt(br.readLine());
		weight = new int[k];
		
		// 추의 무게 입력, 추의 모든 무게를 합한 크키 + 1 만큼의 배열 arr 생성
		// arr 배열에 인덱스에 해당하는 무게를 구할 수 있는지 boolean 타입으로 체크
		st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 0; i < k; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
			sum += weight[i];
		}
		arr = new boolean[sum + 1];
		
		// 측정
		estimate(0, 0);
		
		
		// 측정 불가능한 수 출력
		int result = 0;
		for (int i = 1; i < sum + 1; i++) {
			if (arr[i] == false)
				result++;
		}
		System.out.print(result);
	}

	static void estimate(int w, int idx) {
		if(idx < weight.length) {
			// 현재 무게를 포함하지 않음
			estimate(w, idx + 1);
			// 현재 무게를 왼쪽 저울에 포함함.
			estimate(w - weight[idx], idx + 1);
			// 현재 무게를 오른쪽 저울에 포함함.
			estimate(w + weight[idx], idx + 1);
		}
		
		// 마지막 추의 포함 여부까지 확인했으며, w이 양수라면
		// 무게 w는 측정 가능한 수 이므로 arr를 true로 바꿔준다.
		if(idx == weight.length && w > 0) {
			arr[w] = true;
		}
	}
}