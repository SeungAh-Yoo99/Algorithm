import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static ArrayList<Integer> tree;
	static int[] result;
	static int index;
	
	private static void postOrder(int start, int end) { // 후위 순회
		
		result[index--] = tree.get(start); // 시작 노드를 답 배열에 담아줌
		
		int left = -1; // 왼쪽 자식의 노드를 가리킬 인덱스
		int right = -1; // 오른쪽 자식의 노드를 가리킬 인덱스
		
		// 왼쪽 자식의 인덱스 구하기
		if(start + 1 < tree.size() && tree.get(start) > tree.get(start + 1)) { // 왼쪽 자식이 있다면
			left = start + 1; // start의 바로 다음 값은 start 값보다 작을 것
		}
		
		// 오른쪽 자식의 인덱스 구하기
		for (int i = start; i <= end; i++) {
			if(tree.get(start) < tree.get(i)) {// 처음으로 나온 start 값보다 큰 곳이 오른쪽 자식의 인덱스
				right = i;
				break;
			}
		}
		
		// 오른쪽 서브 트리를 후위 순회
		if(right != -1) { // 오른쪽 자식이 있다면
			postOrder(right, end);
		}
		
		// 왼쪽 서브 트리를 후위 순회
		if(left != -1) { // 왼쪽 자식이 있다면
			// 왼쪽 서브 트리의 끝 인덱스는
			// 오른쪽 서브 트리가 있으면 오른쪽 인덱스 - 1
			// 오른쪽 서브 트리가 없으면 끝까지
			postOrder(left, right != -1 ? right - 1 : end);
		}
	}

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		tree = new ArrayList<>(); // 전위 순회한 트리 담을 리스트
		while(sc.hasNext()) { // 입력이 없을 때까지 반복(입력 끝났으면 ctrl+z)
			tree.add(sc.nextInt());
		}
		
		// 트리를 후위 순회한 결과를 담을 배열
		result = new int[tree.size()];
		index = tree.size() - 1;
		
		// 후위 순회
		postOrder(0, tree.size() - 1);
		
		// 값 출력
		for (int n : result) {
			sb.append(n + "\n");
		}
		System.out.println(sb);
	}
}