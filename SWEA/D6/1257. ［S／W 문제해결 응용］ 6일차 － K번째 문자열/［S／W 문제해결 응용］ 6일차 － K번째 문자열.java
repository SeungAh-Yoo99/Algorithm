import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    static class Node {

        char c;
        int count;
        Trie trie;

        Node front;
        Node next;

        Node() {}

        Node(char c) {
            this.c = c;
            count = 0;
            trie = new Trie();
        }

        int add(char[] string, int s) {

            int ret = 0;

            if(string.length == s) return ret;

            Node n = trie.get(string[s]);

            // 현재 노드에 c에 해당하는 노드를 가지고 있지 않은 경우
            if(n == null) {
                // c에 해당하는 노드를 새로 만든다.
                n = trie.add(string[s]);
                ret++;
            }

            ret += n.add(string, s + 1);
            count += ret;
            return ret;
        }

        ArrayList<Character> get(int k) {

            ArrayList<Character> ret;

            if(k == 0) {
                ret = new ArrayList<>();
                ret.add(c);
                return ret;
            }

            Node now = trie.head;
            for (int i = 0; i < trie.size; i++) {
                now = now.next;

                if(now.count + 1 < k) k -= now.count + 1;
                else if(now.count + 1 == k) {
                    ret = new ArrayList<>();
                    ret.add(c);
                    return ret;
                }
                else break;
            }

            ret = now.get(k - 1);
            ret.add(c);
            return ret;
        }
    }

    static class Trie {

        Node head;
        int size;

        Trie() {
            head = new Node();
            size = 0;
        }

        Node get(char c) {

            // 아직 아무것도 들어있지 않은 트라이일 경우
            if(size == 0) return null;

            Node now = head;
            for (int i = 0; i < size; i++) {
                now = now.next;

                // 찾고 있는 노드를 찾은 경우
                if(now.c == c) return now;
            }

            // 찾지 못한 경우
            return null;
        }

        Node add(char c) {

            Node ret = new Node(c);

            Node now = head;
            for (int i = 0; i < size; i++) {
                now = now.next;

                // c가 trie의 중간에 와야하는 경우
                if(now.c > c) {
                    now.front.next = ret;
                    ret.front = now.front;

                    ret.next = now;
                    now.front = ret;

                    size++;
                    return ret;
                }
            }

            // c가 트라이의 마지막에 와야하는 경우
            now.next = ret;
            ret.front = now;

            size++;
            return ret;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int K;
        char[] string;
        Node root;
        for (int tc = 1; tc <= T; tc++) {
            K = Integer.parseInt(br.readLine());
            string = br.readLine().toCharArray();

            // 부분 문자열 트라이에 추가
            root = new Node('R');
            for (int i = 0; i < string.length; i++) {
                root.add(string, i);
            }

            // 부분 문자열이 K개보다 작다면
            if(root.count < K) {
                System.out.println("#" + tc + " none");
                continue;
            }

            // K번째 부분 문자열 구하기
            StringBuilder answer = new StringBuilder();
            ArrayList<Character> ret = root.get(K);
            for (int i = ret.size() - 2; i >= 0; i--) {
                answer.append(ret.get(i));
            }
            System.out.println("#" + tc + " " + answer);
        }
    }
}
