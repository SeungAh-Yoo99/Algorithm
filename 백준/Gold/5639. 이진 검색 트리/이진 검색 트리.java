import java.io.InputStreamReader;
import java.util.Scanner;

class Node {
	int key;
	Node parent;
	Node leftChild;
	Node rightChild;
	
	Node(int key, Node parent) {
		this.key = key;
		this.parent = parent;
		this.leftChild = null;
		this.rightChild = null;
	}
}

public class Main {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		Node root = new Node(sc.nextInt(), null); // 루트 노드 입력
		
		while(sc.hasNext()) { // 입력이 없을 때까지 반복(입력 끝났으면 ctrl+z)
			
			Node p = root; // 현재 가리키고 있는 노드(맨 처음은 언제나 루트 노드를 가리킴)
			int n = sc.nextInt();
			
			while(true) { // 노드를 넣어줄 위치를 찾을 때까지 반복
				
				if(p.key > n) { // 현재 가리키고 있는 노드의 key보다 작을 경우
					
					if(p.leftChild != null) // 왼쪽 노드가 이미 있다면
						p = p.leftChild; // 왼쪽 노드를 가리켜줌
					
					else { // 왼쪽 노드가 비었다면
						p.leftChild = new Node(n, p); // 왼쪽 노드에 넣어주고
						break; // 다음 노드 입력 받으러
					}
				}
				
				else { // 현재 가리키고 있는 노드의 key보다 클 경우

					if(p.rightChild != null) // 오른쪽 노드가 이미 있다면
						p = p.rightChild; // 오른쪽 노드를 가리켜줌
					
					else { // 오른쪽 노드가 비었다면
						p.rightChild = new Node(n, p); // 오른쪽 노드에 넣어주고
						break; // 다음 노드 입력 받으러
					}
				}
			}
		}
		
		// 후위 순회
		Node p = root; // 현재 가리키는 노드
		while(true) {
			if(p.leftChild != null) // 현재 가리키는 노드의 왼쪽 자식이 있다면
				p = p.leftChild; // 왼쪽 자식을 가리킴
			
			else if(p.rightChild != null) // 현재 가리키는 노드의 오른쪽 자식이 있다면
				p = p.rightChild; // 오른쪽 자식을 가리킴
			
			else { // 현재 가리키는 노드의 자식이 없다면
				sb.append(p.key + "\n"); // 출력
				
				if(p.parent == null) // 루트 노드라면
					break; // 모든 출력 완료, 반복문 탈출
				
				if(p.key < p.parent.key) // 자신이 부모 노드의 왼쪽 자식이면
					p.parent.leftChild = null; // 부모 노드의 왼쪽 자식 삭제
				else // 자신이 부모 노드의 오른쪽 자식이면
					p.parent.rightChild = null; // 부모 노드의 오른쪽 자식 삭제
				
				p = p.parent; // 부모 노드를 가리켜줌
			}
		}
		
		// 출력
		System.out.println(sb);
	}

}