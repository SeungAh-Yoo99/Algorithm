import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    static class Dictionary {

        char c;
        int count;
        LinkedList child;

        Dictionary front;
        Dictionary next;

        Dictionary() {};

        Dictionary(char c) {
            this.c = c;
            count = 0;
            child = new LinkedList();
        }

        void add(char[] list, int s) {

            count++;

            if(s == list.length) return;

            Dictionary d = child.get(list[s]);
            d.add(list, s + 1);
        }

        ArrayList<Character> get(int k) {

            if(k > count) return new ArrayList<>();

            Dictionary d = child.head;
            for (int i = 0; i < child.size; i++) {
                d = d.next;

                if(d.count < k) k -= d.count;
                else break;
            }

            ArrayList<Character> ret = d.get(k);
            ret.add(c);
            return ret;
        }
    }

    static class LinkedList {

        Dictionary head;
        int size;

        LinkedList() {
            head = new Dictionary();
            size = 0;
        }

        Dictionary get(char c) {
            Dictionary now = head;

            for (int i = 0; i < size; i++) {
                now = now.next;
                if(now.c == c) break;
                else if(now.c > c) {
                    size++;
                    Dictionary d = new Dictionary(c);
                    now.front.next = d;
                    d.front = now.front;

                    now.front = d;
                    d.next = now;

                    now = d;
                    break;
                }
            }

            if(now.c != c) {
                size++;
                Dictionary d = new Dictionary(c);
                now.next = d;
                d.front = now;
                now = d;
            }

            return now;
        }
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int K;
        char[] string;
        Dictionary root;
        ArrayList<Character> ret;
        StringBuilder answer;
        for (int tc = 1; tc <= T; tc++) {
            K = Integer.parseInt(br.readLine());
            string = br.readLine().toCharArray();

            if(string.length < K) {
                System.out.println("#" + tc + " none");
            }

            root = new Dictionary('R');
            for (int i = 0; i < string.length; i++) {
                root.add(string, i);
            }

            ret = root.get(K);
            answer = new StringBuilder();
            answer.append("#" + tc + " ");
            for (int i = ret.size() - 2; i >= 0; i--) {
                answer.append(ret.get(i));
            }
            System.out.println(answer);
        }
    }
}
