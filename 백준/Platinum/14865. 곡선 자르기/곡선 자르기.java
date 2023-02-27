import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static HashMap<Integer, Integer> hm; // 봉우리 정보를 담은 HashMap
	static int count1; // 다른 봉우리에 의해 포함되지 않는 봉우리 개수
	static int count2; // 다른 봉우리를 포함하지 않는 봉우리 개수
	
	private static int count(int x1, int x2) {
		boolean isCount2 = true;
		for (int j = x1 + 1; j < x2; j++) { // 한 봉우리 사이에 다른 봉우리가 있는지 확인
			Integer t = hm.get(j);
			if(t != null) { // 봉우리 안에 다른 봉우리가 있다면
				isCount2 = false; // 현재 봉우리가 다른 봉우리를 포함하므로
				count1--;
				j = count(j, t);
			}
		}
		if(isCount2) count2++;
		return x2;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 꼭짓점의 개수 N 입력
		int N = Integer.parseInt(br.readLine());
		
		// 봉우리의 정보를 담을 스택(밑에서 위로 올라오는 점이면 push, 위에서 밑으로 내려가는 점이면 pop)
		Stack<Integer> stack = new Stack<>();
		// 봉우리의 왼쪽 끝점을 담을 HashMap
		hm = new HashMap<>();
		// 가장 왼쪽 봉우리의 왼쪽 끝점
		int minX1 = (int) 10e9;
		int maxX1 = (int) - 10e9;
		
		// 꼭짓점 정보 입력 받는다.
		int[] p1 = new int[2];
		
		st = new StringTokenizer(br.readLine());
		p1[0] = Integer.parseInt(st.nextToken());
		p1[1] = Integer.parseInt(st.nextToken());
		
		int[] tmp = p1; // 첫번째 점의 정보를 기억해둔다
		
		for (int i = 1; i < N; i++) {
			int[] p2 = new int[2]; // 다음 꼭짓점 정보 입력
			st = new StringTokenizer(br.readLine());
			p2[0] = Integer.parseInt(st.nextToken());
			p2[1] = Integer.parseInt(st.nextToken());
			
			if(p1[0] == p2[0]) { // 두 점의 x 값이 같을 때
				// 밑에서 위로 올라가는 방향이라면
				if((p1[1] <= 0 && p2[1] > 0)){ 
					stack.push(p1[0]);
				}
				// 위에서 아래로 내려오는 방향이라면
				if(p1[1] > 0 && p2[1] <= 0) {
					if(stack.isEmpty()) {
						stack.push(p1[0]);
					}
					else {
						int x = stack.pop();
						// 왼쪽 끝점을 0인덱스, 오른쪽 끝점을 1인덱스
						int x1 = x < p1[0] ? x : p1[0];
						int x2 = x > p1[0] ? x : p1[0];
						hm.put(x1, x2);
						minX1 = Math.min(minX1, x1);
						maxX1 = Math.max(maxX1, x1);
					}
				}
			}
			p1 = p2; // 다음 꼭짓점 정보를 비교하기 위해 p2 정보를 p1으로 바꿔줌.
		}
		// 꼭짓점 정보 입력이 끝났는데, stack에 봉우리의 끝점이 남아있다면 첫번째 입력 받은 점과 마지막 입력 받은 점이 하나의 끝점임
		if(!stack.isEmpty()) {
			int x = stack.pop();
			// 왼쪽 끝점을 0인덱스, 오른쪽 끝점을 1인덱스
			int x1 = x < tmp[0] ? x : tmp[0];
			int x2 = x > tmp[0] ? x : tmp[0];
			hm.put(x1, x2);
			minX1 = Math.min(minX1, x1);
			maxX1 = Math.max(maxX1, x1);
		}
		
		count1 = hm.size();
		count2 = 0;
		
		if(hm.size() == 1) { // 봉우리가 한개라면
			count1 = 1;
			count2 = 1;
		}
		else if(hm.size() > 1){ // 봉우리가 한개 이상이라면
			for (int i = minX1; i <= maxX1; i++) {
				Integer x2 = hm.get(i);
				if(x2 != null) i = count(i, x2);
			}
		}
		
		// 출력
		System.out.println(count1 + " " + count2);
		
	}

}