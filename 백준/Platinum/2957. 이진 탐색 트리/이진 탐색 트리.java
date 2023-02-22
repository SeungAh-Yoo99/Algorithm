import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;


public class Main {
	
	static long c;
	static TreeMap<Integer, Integer> tm = new TreeMap<>();
	static StringBuilder sb = new StringBuilder();
	
	private static void insert(int x) {
		if(tm.size() == 0) { // 루트 노드를 아직 넣지 않았다면
			tm.put(x, 0); // 루트 노드 넣어줌(key는 정수, value는 depth)
			sb.append("0\n");
			return;
		}

		tm.put(x, 0); // TreeMap에 x를 넣어줌
		
		// 부모 노드의 depth를 구한다
		// 부모는 현재 노드보다 큰 수 중 가장 작거나, 작은 수 중 가장 큰 수
		int parent = 0;
		if(tm.lowerKey(x) == null) { // 자신보다 작은 수가 없으면 부모가 현재 노드보다 큰 수 중 가장 작은 수라면
			parent = tm.higherKey(x); // 부모의 값을 가져온다
		}	
		else if(tm.higherKey(x) == null){ // 자신보다 큰 수가 없으면 부모가 현재 노드보다 작은 수 중 가장 큰 수라면
			parent = tm.lowerKey(x); // 부모의 값을 가져온다
		}
		else { // 둘 다 있다면 parent는 depth가 높은 것
			parent = tm.get(tm.higherKey(x)) > tm.get(tm.lowerKey(x)) ? tm.higherKey(x) : tm.lowerKey(x); 
		}
		int parentDepth = tm.get(parent); // 부모의 depth를 구하고
		c += parentDepth + 1; // 루트 노드에서부터 x까지 오려면 parent의 depth에서 한 칸 더 내려와야 한다.
		tm.put(x, parentDepth + 1); // x의 Depth도 바꿔줌
		
		// 현재의 c값 출력
		sb.append(c + "\n");
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 수열의 크기 N 입력
		int N = Integer.parseInt(br.readLine());
		
		// N개의 수 트리에 넣기
		for (int i = 0; i < N; i++) {
			insert(Integer.parseInt(br.readLine()));
		}
		
		// 출력
		System.out.println(sb);
	}

}