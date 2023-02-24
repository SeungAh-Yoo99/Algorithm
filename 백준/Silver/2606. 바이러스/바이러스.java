import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 컴퓨터의 수 n, 컴퓨터 쌍의 수 m 입력
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		// 컴퓨터 쌍의 정보를 담을 리스트
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		// m개의 컴퓨터 쌍 정보 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		boolean[] visited = new boolean[n + 1]; // 방문체크
		int result = 0;
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1); // 바이러스 시작은 1번
		visited[1] = true; //1번 방문체크
		
		while(!q.isEmpty()) {
			int now = q.poll(); // 큐에서 연결된 컴퓨터 하나 빼주고
			
			ArrayList<Integer> nowList = list.get(now); //now에 연결된 컴퓨터 리스트 뽑아옴
			for (int i = 0; i < nowList.size(); i++) { // 리스트 중에서
				if(!visited[nowList.get(i)]) { // 아직 방문하지 않은 컴퓨터가 있다면
					q.add(nowList.get(i)); // 큐에 넣어줌
					visited[nowList.get(i)] = true; //방문체크
					result++; // 감염된 컴퓨터 수 체크
				}
			}
		}
		
		// 출력
		System.out.println(result);
	}

}