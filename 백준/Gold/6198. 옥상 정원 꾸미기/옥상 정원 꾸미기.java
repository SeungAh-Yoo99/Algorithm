import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// N 입력
		int N = Integer.parseInt(br.readLine());
		
		// 빌딩 높이 입력 
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 빌등의 오른쪽 건물들 중 가장 먼저 나오는 현재 빌딩보다 가장 높거나 같은 건물의 인덱스
		int[] rightIdx = new int[N];
		// 빌딩이 볼 수 있는 옥상 수를 담은 배열
		int[] numOfRoof = new int[N];
		
		// 오른쪽부터 시작
		rightIdx[N - 1] = N; //가장 오른쪽 건물은 볼 수 있는 건물이 없으니 건너뜀
		for (int i = N - 2; i >= 0; i--) {
			int tmpIdx = i + 1;
			while(tmpIdx < N && arr[i] > arr[tmpIdx]) { // rightIdx를 따라가며 건물 높이를 체크하다가 현재 건물보다 높은 건물이 나오면 스톱
				numOfRoof[i]++; // 한 칸 앞으로 이동했으니 + 1
				numOfRoof[i] += numOfRoof[tmpIdx]; // 다음 건물까지의 수  더해주기
				tmpIdx = rightIdx[tmpIdx]; // 다음 큰 건물로 이동
			}
			rightIdx[i] = tmpIdx;
		}
		
		// 모든 벤치마킹 가능한 빌딩 수의 합 구해주기
		long result = 0;
		for (int i = 0; i < N; i++) {
			result += numOfRoof[i];
		}
		
		// 출력
		System.out.println(result);
	}

}