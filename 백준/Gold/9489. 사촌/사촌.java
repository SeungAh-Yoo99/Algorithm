import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int n;
		int k;
		int[][] arr;
		int kIdx = 0; // k의 인덱스
		
		
		while(true) {
			// n, k 입력
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			// 테스트 케이스 종료
			if(n == 0 && k == 0) break;
			
			// 필요 자료구조 선언
			arr = new int[n][2];
			// arr[i][0] := i번째 수
			// arr[i][1] := i번째 수의 부모 인덱스
			
			// 수열 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i][0] = Integer.parseInt(st.nextToken());
				if(arr[i][0] == k) kIdx = i;
			}
			arr[0][1] = -1; // 루트 노드라고 표시
			
			// 두 번재 노드부터 depth 정보 저장
			int p = 0; // 부모 노드의 인덱스
			for (int i = 1; i < n; i++) {
				arr[i][1] = p;
				
				// 다음 수가 연속된 수가 아니라면
				if(i < n - 1 && arr[i][0] + 1 != arr[i + 1][0]) p++;
			}
			
			int result = 0;
			if(kIdx != 0) {
				int pp = arr[arr[kIdx][1]][1]; // k의 부모의 부모 인덱스
				p = arr[kIdx][1]; // k의 부모 인덱스
				// k 부모의 형제 노드들의 자식 노드 개수 세기
				for (int i = 1; i < n; i++) {
					if(arr[i][1] >= kIdx) break; // k의 자식들이 나왔다면 그만 봐도 됨
					
					if(arr[i][1] == -1 || arr[arr[i][1]][1] == -1) continue;
					else if(arr[arr[i][1]][1] == pp && arr[i][1] != p) result++;
				}
			}
			sb.append(result).append("\n");
		}
		
		// 출력
		System.out.println(sb);
	}

}