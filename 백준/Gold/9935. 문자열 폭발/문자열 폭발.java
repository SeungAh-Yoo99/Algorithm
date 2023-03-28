import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static class Node {
		
		Node pre;
		Node next;
		char c;
		
		Node(char c) {
			this.pre = null;
			this.next = null;
			this.c = c;
		}
	}
	
	static class LinkedList {
		
		Node head;
		Node tail;
		
		LinkedList() {
			head = new Node('-');
			tail = head;
		}
		
		void add(char c) {
			tail.next = new Node(c);
			tail.next.pre = tail;
			tail = tail.next;
		}
		
		boolean findSubString(char[] string) {
			boolean returnValue = false; // 한 번이라도 문자열을 지운 적 있다면 true 리턴
			
			Node cur = head;
			
			while (cur != null) {
				
				if(cur.c == string[0]) { // 폭발 문자열의 시작 문자와 같은 문자를 발견한다면
					Node tmp = cur.next;
					boolean flag = true;
					for (int i = 1; i < string.length; i++) {
						if(tmp == null || tmp.c != string[i]) {
							flag = false;
							break;
						}
						tmp = tmp.next;
					}
					if(flag) { // 폭발 문자열을 발견했을 경우, 폭발 문자열 지워줌
						cur.pre.next = tmp;
						cur = cur.pre;
						if(tmp != null) tmp.pre = cur;
						returnValue = true;
					}
					else cur = cur.next;
				}
				else {
					cur = cur.next;
				}
			}
			
			return returnValue;
		}
		
		void findExplosionString(char[] string) {
			while(findSubString(string));
		}
		
		StringBuilder print() {
			StringBuilder sb = new StringBuilder();
			
			Node cur = head.next;
			while(cur != null) {
				sb.append(cur.c);
				cur = cur.next;
			}
			
			return sb;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] s = br.readLine().toCharArray();
		
		LinkedList list = new LinkedList();
		
		for (int i = 0; i < s.length; i++) {
			list.add(s[i]);
		}
		
		char[] string = br.readLine().toCharArray();
		
		list.findExplosionString(string);
		
		// 출력
		sb = list.print();
		if(sb.length() == 0) System.out.println("FRULA");
		else System.out.println(list.print());
	}

}