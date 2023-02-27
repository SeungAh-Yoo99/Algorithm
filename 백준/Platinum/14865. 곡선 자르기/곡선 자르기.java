import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<int[]> list;
	static int count1; // 다른 봉우리에 의해 포함되지 않는 봉우리 개수
	static int count2; // 다른 봉우리를 포함하지 않는 봉우리 개수
	
	private static int count(int idx) {
		boolean isCount2 = true;
		int j;
		for (j = idx + 1; j < list.size();) { // 한 봉우리 사이에 다른 봉우리가 있는지 확인
			if(list.get(idx)[1] > list.get(j)[0]) { // 다음 봉우리가 idx 봉우리 사이에 있다면
				count1--;
				isCount2 = false;
				j = count(j);
			}
			else break;
		}
		if(isCount2) count2++;
		
		return j;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 꼭짓점의 개수 N 입력
		int N = Integer.parseInt(br.readLine());
		
		// 봉우리의 정보를 담을 스택(밑에서 위로 올라오는 점이면 push, 위에서 밑으로 내려가는 점이면 pop)
		Stack<Integer> stack = new Stack<>();
		// 봉우리의 왼쪽 끝점을 담을 리스트
		list = new ArrayList<>();
		
		// 꼭짓점 정보 입력 받는다.
		int[] p1 = new int[2];
		
		st = new StringTokenizer(br.readLine());
		p1[0] = Integer.parseInt(st.nextToken());
		p1[1] = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i < N; i++) {
			int[] p2 = new int[2]; // 다음 꼭짓점 정보 입력
			st = new StringTokenizer(br.readLine());
			p2[0] = Integer.parseInt(st.nextToken());
			p2[1] = Integer.parseInt(st.nextToken());
			
			if(p1[0] == p2[0]) { // 두 점의 x 값이 같을 때
				// 밑에서 위로 올라가는 방향이라면
				if((p1[1] < 0 && p2[1] > 0)){ 
					stack.push(p1[0]);
				}
				// 위에서 아래로 내려오는 방향이라면
				if(p1[1] > 0 && p2[1] < 0) {
					if(stack.isEmpty()) {
						stack.push(p1[0]);
					}
					else {
						int x = stack.pop();
						// 왼쪽 끝점을 0인덱스, 오른쪽 끝점을 1인덱스
						int x1 = x < p1[0] ? x : p1[0];
						int x2 = x > p1[0] ? x : p1[0];
						list.add(new int[] {x1, x2});
					}
				}
			}
			p1 = p2; // 다음 꼭짓점 정보를 비교하기 위해 p2 정보를 p1으로 바꿔줌.
		}
		// stack에 봉우리의 끝점이 남아있다면 첫번째 입력 받은 점과 마지막 입력 받은 점이 하나의 끝점임
		if(stack.size() == 1) {
			int x = stack.pop();
			// 왼쪽 끝점을 0인덱스, 오른쪽 끝점을 1인덱스
			int x1 = x < p1[0] ? x : p1[0];
			int x2 = x > p1[0] ? x : p1[0];
			list.add(new int[] {x1, x2});
		}
		// stack에 끝점이 두개 남아있다면, 오른쪽 끝점이 먼저 입력된 하나의 봉우리임
		else if(stack.size() == 2) {
			int s1 = stack.pop();
			int s2 = stack.pop();
			int x1 = s1 < s2 ? s1 : s2;
			int x2 = s1 > s2 ? s1 : s2;
			list.add(new int[] {x1, x2});
		}
		
		list.sort((o1, o2) -> o1[0] - o2[0]); // 봉우리의 왼쪽 끝점을 기준으로 정렬
		
		count1 = list.size();
		count2 = 0;
		
		if(list.size() == 1) { // 봉우리가 한개라면
			count1 = 1;
			count2 = 1;
		}
		else { // 봉우리가 한개 이상이라면
			for (int i = 0; i < list.size();) {
				i = count(i);
			}
		}
		
		// 출력
		System.out.println(count1 + " " + count2);
		
	}

}
