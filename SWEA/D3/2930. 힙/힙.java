import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[] heap;
	static int size;
	
	private static void insert(int x) {
		// 1. 배열의 가장 맨 뒤에 삽입 (root는 1부터 시작)
		heap[++size] = x;
		
		// 2. 부모를 확인하며 부모가 자신보다 작다면 바꿔줌
		int now = size;
		while(now > 1) {
			int parent = now / 2; // 부모의 위치
			if(heap[parent] < heap[now]) { // 부모가 자신보다 작다면
				int tmp = heap[parent]; // 서로 위치 바꿔줌
				heap[parent] = heap[now];
				heap[now] = tmp;
				now = parent; // 다음 부모 확인하러
			}
			else break; // 부모가 자신보다 크거나 같으면 더 이상 확인해주지 않아도 됨
		}
	}
	
	private static int delete() {
		// 루트 노드 값 저장
		if(size == 0) return -1;
		int ret = heap[1];
		
		// 루트 값 바꿔줌
		// 1. 가장 마지막 원소를 노드에 저장
		heap[1] = heap[size];
		heap[size--] = 0;
		// 2. 루트 노드를 자식과 비교하며 자신보다 큰 값이 있을 때 바꿔줌
		int now = 1;
		int left = 2;
		int right = 3;
		while(now < size) {
			// 왼쪽, 오른쪽 중 더 큰 자식과 자리를 바꿈
			if(heap[left] > heap[right]) { // 왼쪽이 더 큰 경우
				// 현재 노드가 더 크다면 while문 탈출
				if(heap[left] <= heap[now]) break;
				int tmp = heap[now]; // 서로 위치 바꿔줌
				heap[now] = heap[left];
				heap[left] = tmp;
				
				now = left;
			}
			else { // 오른쪽이 더 큰 경우
				// 현재 노드가 더 크다면 while문 탈출
				if(heap[right] <= heap[now]) break;
				int tmp = heap[now]; // 서로 위치 바꿔줌
				heap[now] = heap[right];
				heap[right] = tmp;
				
				now = right;
			}
			
			left = now * 2;
			right = left + 1;
		}
		
		return ret;
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			
			int N = Integer.parseInt(br.readLine());
			
			// heap 초기화
			heap = new int[200003];
			size = 0;
			
			// 연산 시작
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				
				if(c == 1) { // 추가
					int x = Integer.parseInt(st.nextToken());
					insert(x);
				}
				else { // 조회, 삭제
					sb.append(delete() + " ");
				}
			}
			sb.append("\n");
			
		}
		
		System.out.println(sb);
	}

}