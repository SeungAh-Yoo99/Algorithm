import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int A;
	static int B;
	static boolean[] visited;
	static StringBuilder result;
	
	private static void bfs() {
		
		String[] commandList = {"D", "S", "L", "R"};
		
		Queue<Integer> iq = new LinkedList<>(); // 레지스터 값을 넣어둘 큐
		Queue<String> sq = new LinkedList<>(); // iq에 해당하는 레지스터 값을 만들기 위한 명령어를 넣어둘 큐
		
		iq.add(A);
		sq.add("");
		visited[A] = true;
		
		while(!iq.isEmpty()) {
			int num = iq.poll();
			String cmd = sq.poll();
			
			for (int i = 0; i <= 3; i++) {
				int tmp = cal(i, num);
				if(!visited[tmp]) {
					if(tmp == B) {
						result.append(cmd + commandList[i] + "\n");
						return;
					}
					visited[tmp] = true;
					iq.add(tmp);
					sq.add(cmd + commandList[i]);
				}
			}
		}
	}
	
	private static int cal(int c, int a) {
		if(c == 0) return (a * 2) % 10000;
		else if(c == 1) return a == 0 ? 9999 : a - 1;
		else if(c == 2) return (a * 10) % 10000 + a / 1000;
		else return (a % 10) * 1000 + a / 10;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		result = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			// 입력
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			visited = new boolean[10000];
			bfs(); // bfs로 답 구하기
		}
		
		// 출력
		System.out.println(result);
	}

}