import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	
	Node back;
	String num;
	
	Node(String num) {
		this.back = null;
		this.num = num;
	}
}

public class Solution {
	
	static Node head;
	static Node tail;
	
	private static Node insert(Node node1, Node node2) {
		Node tmp = node1.back;
		node1.back = node2;
		node2.back = tmp;
		
		return node2;
	}
	
	private static void delete(Node node) {
		node.back = node.back.back;
	}
	
	private static void addFirst(Node node) {
		node.back = head;
		head = node;
	}
	
	private static void addLast(Node node) {
		tail.back = node;
		tail = node;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			// 초기화
			head = null;
			tail = null;
			
			// 원본 암호문의 길이 N 입력
			int N = Integer.parseInt(br.readLine());
			
			// 원본 암호문 입력
			st = new StringTokenizer(br.readLine());
			head = new Node(st.nextToken());
			tail = head;
			for (int i = 1; i < N; i++) {
				addLast(new Node(st.nextToken()));
			}
			
			// 명령어의 개수 M 입력
			int M = Integer.parseInt(br.readLine());
			
			// 명령어 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				String cmd = st.nextToken();
				
				if(cmd.equals("I")) { // 삽입
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					
					if(x == 0 ) { // 맨 앞 삽입
						// y개의 노드 삽입
						addFirst(new Node(st.nextToken()));
						Node now = head;
						for (int j = 1; j < y; j++) {
							now = insert(now, new Node(st.nextToken()));
						}
					}
					
					else { // 중간 삽입
						Node now = head;
						
						for (int j = 1; j < x; j++) { // x 위치의 노드 찾기
							now = now.back;
						}
						
						for (int j = 0; j < y; j++) { // y개의 노드 삽입
							now = insert(now, new Node(st.nextToken()));
						}
					}
				}
				
				else if(cmd.equals("D")) { // 삭제
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					
					if(x == 0) { // 맨 앞 삭제
						for (int j = 0; j < y; j++) {
							head = head.back;
						}
					}
					
					else {
						Node now = head;
						
						for (int j = 1; j < x; j++) { // x 위치의 노드 찾기
							if(now.back == null) break;
							now = now.back;
						}
						
						for (int j = 0; j < y; j++) { // y개의 노드 삭제
							if(now.back == null) break;
							delete(now);
						}
					}
				}
				
				else if(cmd.equals("A")) { // 맨 뒤 추가
					int y = Integer.parseInt(st.nextToken());
					
					for (int j = 0; j < y; j++) {
						addLast(new Node(st.nextToken()));
					}
				}
			}
			
			// 암호문의 처음 10개 항 출력
			sb.append("#" + test_case + " ");
			Node now = head;
			for (int i = 0; i < 10; i++) {
				if(now == null) break;
				sb.append(now.num + " ");
				now = now.back;
			}
			sb.append("\n");
		}
		
		// 출력
		System.out.println(sb);
	}

}