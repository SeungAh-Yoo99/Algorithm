import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 꼭짓점의 개수 N 입력
		int N = Integer.parseInt(br.readLine());
		
		// 봉우리의 왼쪽 좌표 x값과 오른쪽 좌표 x값을 담을 리스트
		ArrayList<int[]> list = new ArrayList<>();
		// 봉우리의 정보를 담을 스택(밑에서 위로 올라오는 점이면 push, 위에서 밑으로 내려가는 점이면 pop)
		Stack<Integer> stack = new Stack<>();
		
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
						int[] b = new int[2];
						// 왼쪽 끝점을 0인덱스, 오른쪽 끝점을 1인덱스
						b[0] = x < p1[0] ? x : p1[0];
						b[1] = x > p1[0] ? x : p1[0];
						list.add(b);
					}
				}
			}
			p1 = p2; // 다음 꼭짓점 정보를 비교하기 위해 p2 정보를 p1으로 바꿔줌.
		}
		// 꼭짓점 정보 입력이 끝났는데, stack에 봉우리의 끝점이 남아있다면 첫번째 입력 받은 점과 마지막 입력 받은 점이 하나의 끝점임
		if(!stack.isEmpty()) {
			int x = stack.pop();
			int[] b = new int[2];
			// 왼쪽 끝점을 0인덱스, 오른쪽 끝점을 1인덱스
			b[0] = x < tmp[0] ? x : tmp[0];
			b[1] = x > tmp[0] ? x : tmp[0];
			list.add(b);
		}
		
		int count1 = 0; // 다른 봉우리에 의해 포함되지 않는 봉우리 개수
		int count2 = 0; // 다른 봉우리를 포함하지 않는 봉우리 개수
		if(list.size() == 1) { // 봉우리가 한개라면
			count1 = 1;
			count2 = 1;
		}
		else if(list.size() > 1){ // 봉우리가 한개 이상이라면
			for (int i = 0; i < list.size(); i++) {
				int b1_x1 = list.get(i)[0]; // 비교할 첫 번째 봉우리 정보 가져오기
				int b1_x2 = list.get(i)[1];
				
				boolean isCount1 = false; // 다른 봉우리에 의해 포함된다면 true, 아니라면 false
				boolean isCount2 = false; // 다른 봉우리를 포함한다면  true, 아니라면 false
				
				for (int j = 0; j < list.size(); j++) {
					if(i != j) { // 같은 점이 아닐 때
						int b2_x1 = list.get(j)[0]; // 비교할 두 번째 봉우리 정보 가져오기
						int b2_x2 = list.get(j)[1];
						
						// 봉우리1이 봉우리2에 포함된다면
						if(b2_x1 < b1_x1 && b1_x2 < b2_x2) isCount1 = true;
						// 봉우리1이 봉우리2를 포함한다면
						if(b1_x1 < b2_x1 && b2_x2 < b1_x2) isCount2 = true;
					}
				}
				
				if(!isCount1) count1++;
				if(!isCount2) count2++;
			}
		}
		
		// 출력
		System.out.println(count1 + " " + count2);
		
	}

}