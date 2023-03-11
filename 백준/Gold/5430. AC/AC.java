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
			int start = 0; // 시작 인덱스
			int end = list.size() - 1; // 끝 인덱스
			int length = list.size(); // 리스트 크기
			for (int i = 0; i < p.length; i++) {
				if(p[i] == 'R') { // R일 경우
					first = !first;
				}
				else { // D일 경우
					if(length == 0) {
						sb.append("error\n");
						flag = false;
						break;
					}
					else {
						if(first) start++; // -> 방향일 경우
						else end--; // <- 방향일 경우
						length--;
					}
				}
			}
			
			if(flag) { // 에러가 아닌 경우 배열 담기
				sb.append("[");
				if(length > 0) { // 아직 수가 남아있을 때만 출력 담기
					if(first) { // -> 방향으로 출력
						for (int i = start; i <= end; i++) {
							if(i == end) sb.append(list.get(i));
							else sb.append(list.get(i) + ",");
						}
					}
					else { // <- 방향으로 출력
						for (int i = end; i >= start; i--) {
							if(i == start) sb.append(list.get(i));
							else sb.append(list.get(i) + ",");
						}
					}
				}
				sb.append("]\n");
			}
		}
		// 출력
		System.out.println(sb);
	}

}