import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			// 입력
			char[] p = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			char[] x = br.readLine().toCharArray();
			
			// char형 배열을 정수로 바꿔 dq에 넣어줌
			int s = 1; // 정수 시작 인덱스
			if(n > 0) {
				for (int i = 1; i < x.length; i++) {
					if(x[i] == ',' || x[i] == ']') {
						int num = 0;
						for (int j = s; j < i; j++) {
							num = num * 10 + (x[j] - '0');
						}
						list.add(num);
						s = i + 1;
					}
				}
			}
			
			// 명령 수행
			boolean flag = true; // 에러가 발생했을 경우  false;
			boolean first = true; // false면 반대 방향
			for (int i = 0; i < p.length;) {
				if(p[i] == 'R') { // R일 경우
					int count = 0; // 뒤집는 함수가 연속으로 몇 번 나오는지 세준다
					while(i < p.length && p[i] == 'R') {
						count++;
						i++;
					}
					// 뒤집는 연산이 연속으로 짝수만큼 나오면 연산해주지 않아도 되므로
					// 홀수일 때만 뒤집어준다.
					if(count % 2 == 1) {
						first = !first;
					}
				}
				else { // D일 경우
					if(list.isEmpty()) {
						sb.append("error\n");
						flag = false;
						break;
					}
					else {
						if(first) list.remove(0); // -> 방향일 경우
						else list.remove(list.size() - 1); // <- 방향일 경우
					}
					i++;
				}
			}
			
			// 에러가 아닌 경우 배열 담기
			if(flag) {
				sb.append("[");
				if(first) {
					for (int i = 0; i < list.size(); i++) {
						if(i == list.size() - 1) sb.append(list.get(i));
						else sb.append(list.get(i) + ",");
					}
				}
				else {
					for (int i = list.size() - 1; i >= 0; i--) {
						if(i == 0) sb.append(list.get(i));
						else sb.append(list.get(i) + ",");
					}
				}
				sb.append("]\n");
			}
		}
		// 출력
		System.out.println(sb);
	}

}