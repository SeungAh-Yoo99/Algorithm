import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static int result;
	
	private static void dfs(int start, int count) {
		if(count == 5) { // 5명의 친구를 찾았다면
			System.out.println(1); // 1 출력하고
			System.exit(0); // 시스템 종료
		}
		
		ArrayList<Integer> startList = list.get(start); // start의 친구 목록을 가져와서
		
		for (int i = 0; i < startList.size(); i++) {
			int friend = startList.get(i);
			if(!visited[friend]) { // 아직 방문하지 않은 친구라면
				visited[friend] = true; // 방문체크 해주고
				dfs(friend, count + 1); // 다음 친구 찾으러
				visited[friend] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 사람의 수 N, 친구 관계의 수 M 입력
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 관계를 담을 list
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) list.add(new ArrayList<>());

		// 친구 관계입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			dfs(i, 0);
		}
		
		System.out.println(0); // 아직 종료되지 않고 dfs가 끝났다면 해당되는 친구 관계가 없는 것
	}

}