import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static LinkedList<LinkedList<int[]>> list;
	static int result;
	
	public static int getWeight(int node, int weight) {
		// 리프 노드라면
		if(list.get(node).size() == 0) {
			return weight;
		}
		
		// 자식 노드가 있다면
		// 자식 노드들로 가는 weight들의 합을 담을 우선 순의 큐
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i < list.get(node).size(); i++) {
			int c = list.get(node).get(i)[0];
			int w = list.get(node).get(i)[1];
			
			pq.add(getWeight(c, w));
		}
		
		// 자식 노드가 2개 이상이라면
		// 우선 순위 큐에서 상위 2개를 꺼내 더했을 때와 result 중 더 큰 것을 result에 저장
		int first = pq.poll();
		if(pq.size() >= 1) {
			int second = pq.poll();
			result = result > first + second ? result : first + second;
		}
		
		// 가장 긴 길이 return
		return first + weight;
	}
	
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 노드의 개수 n 입력
		int n = Integer.parseInt(br.readLine());
		
		// 간선 정보를 넣을 LinkedList 정의
		list = new LinkedList<>();
		for (int i = 0; i < n + 1; i++) {
			list.add(new LinkedList<>());
		}
		
		// 간선 정보를 LinkedList에 넣기
		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(p).add(new int[] {c, w});
		}
		
		// result 구하기
		int tmp = getWeight(1, 0);
		result = result > tmp ? result : tmp;
		
		// 출력
		System.out.println(result);
	}

}