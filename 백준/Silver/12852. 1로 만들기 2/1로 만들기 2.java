import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int N;
	static ArrayList<Integer> result;
	
	private static void bfs() {
		Queue<ArrayList<Integer>> q = new LinkedList<>();
		boolean[] visited = new boolean[N];
		
		q.add(new ArrayList<>(Arrays.asList(N)));
		while(!q.isEmpty()) {
			ArrayList<Integer> now = q.poll();
			
			if(now.get(now.size() - 1) % 3 == 0) { // 3으로 나눠 떨어진다면
				int tmp = now.get(now.size() - 1) / 3;
				
				if(!visited[tmp]) { // 아직 방문하지 않았다면
					ArrayList<Integer> tmpList = new ArrayList<>();
					tmpList.addAll(now);
					tmpList.add(tmp);
					
					// 1을 만들었다면
					if(tmp == 1) {
						result = tmpList;
						break;
					}
					
					visited[tmp] = true;
					q.add(tmpList);
				}
			}
			
			if(now.get(now.size() - 1) % 2 == 0) { // 2으로 나눠 떨어진다면
				int tmp = now.get(now.size() - 1) / 2;
				if(!visited[tmp]) { // 아직 방문하지 않았다면
					ArrayList<Integer> tmpList = new ArrayList<>();
					tmpList.addAll(now);
					tmpList.add(tmp);
					
					// 1을 만들었다면
					if(tmp == 1) {
						result = tmpList;
						break;
					}
					
					visited[tmp] = true;
					q.add(tmpList);
				}
			}
			
			// 1을 빼는 경우
			int tmp = now.get(now.size() - 1) - 1;
			if(!visited[tmp]) { // 아직 방문하지 않았다면
				ArrayList<Integer> tmpList = new ArrayList<>();
				tmpList.addAll(now);
				tmpList.add(tmp);
				
				// 1을 만들었다면
				if(tmp == 1) {
					result = tmpList;
					break;
				}
				
				visited[tmp] = true;
				q.add(tmpList);
			}
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		result = new ArrayList<>();
		
		if(N == 1) result.add(1);
		else bfs();
		
		sb.append((result.size() - 1) + "\n");
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i) + " ");
		}
		System.out.println(sb);
	}

}