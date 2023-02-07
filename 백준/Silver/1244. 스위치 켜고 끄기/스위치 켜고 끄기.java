import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int[] swit;
	
	public static void boy(int num) {
		for(int i = 1;; i++) {
			if(num * i > n)
				break;
			// 1->0, 0->1
			if(swit[num * i] == 1) swit[num * i] = 0;
			else swit[num * i] = 1;
		}
	}
	
	public static void girl(int num) {
		// 처음엔 입력 받은 수의 스위치 조작
		if(swit[num] == 1) swit[num] = 0;
		else swit[num] = 1;
		
		// 대칭 확인 후
		// 대칭이면 스위치 조작
		// 대칭 아닐때까지 왼쪽 오른쪽 한 칸씩 더 확인
		for(int i = 1;;i++) {
			int left = num - i;
			int right = num + i;
			// 범위 체크 && 대칭 확인
			if(left > 0 && right <= n && swit[left] == swit[right]) {
				if(swit[left] == 1) {
					swit[left] = 0;
					swit[right] = 0;
				}
				else {
					swit[left] = 1;
					swit[right] = 1;
				}
				continue;
			}
			// 대칭 아니라면 반복문 탈출
			break;
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 스위치 개수 입력
		n = Integer.parseInt(br.readLine());
		
		// 스위치 정보를 넣을 배열 선언 & 입력
		swit = new int[n + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			swit[i] = Integer.parseInt(st.nextToken());
		}
		
		// 학생 수 입력
		int s = Integer.parseInt(br.readLine());
		
		// 학생 수만큼 성별, 수 입력 후 스위치 조작
		for(int i = 0; i < s; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			// 남학생이라면
			if(gender == 1)
				boy(num);
			// 여학생이라면
			else
				girl(num);
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n + 1; i++) {
			sb.append(swit[i] + " ");
			if(i % 20 == 0)
				sb.append("\n");
		}
		System.out.println(sb);
	}

}