import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < tc; t++) {
			TreeMap<Integer, Integer> tm = new TreeMap<>(); // 우선 순위로 정렬되며, 가장 작은 수와 가장 큰 수를 뺄 수 있다.
			
			int tt = Integer.parseInt(br.readLine());
			for (int i = 0; i < tt; i++) {
				st = new StringTokenizer(br.readLine());
				String s = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				
				if(s.equals("I")) { // I는 삽입
					tm.put(n, tm.getOrDefault(n, 0) + 1); // 이미 들어있는 정수면 개수를 늘려주고, 처음 넣는 정수면 1을 넣어준다
				}
				else { // D는 삭제 연산
					if(tm.size() > 0) { // empty가 아니라면
						
						if(n == 1) { // 1은 최댓값 삭제
							int num = tm.get(tm.lastKey()); // 최대값 정수의 개수
							if(num == 1) tm.remove(tm.lastKey()); // 최대값이 1개 남았다면 맵에서 삭제
							else tm.put(tm.lastKey(), num - 1); // 여러 개였다면 개수를 하나 줄여줌
						}
						
						else { // -1은 최소값 삭제
							int num = tm.get(tm.firstKey()); // 최소값 정수의 개수
							if(num == 1) tm.remove(tm.firstKey()); // 최소값 1개 남았다면 맵에서 삭제
							else tm.put(tm.firstKey(), num - 1); // 여러 개였다면 개수를 하나 줄여줌
						}
					}
				}
			}
			
			// 답 저장
			if(tm.size() == 0) { // 맵이 비어있다면 "EMPTY" 출력
				 sb.append("EMPTY\n");
			}
			else {
				sb.append(tm.lastKey() + " " + tm.firstKey() + "\n");
			}
		}
		
		System.out.println(sb);
	}

}