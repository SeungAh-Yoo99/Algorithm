import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static class Node {
        int num;
        Node next;

        Node() {}

        Node(int num) {
            this.num = num;
            next = null;
        }
    }

    static class LinkedList {

        Node head;
        Node tail;
        int size;

        LinkedList() {
            head = new Node();
            tail = head;
            size = 0;
        }

        void add(int index, int num) {

            // 만약 맨 마지막에 추가해주는 경우라면
            if(index == size) {
                addLast(num);
                return;
            }

            Node now = head;
            int idx = 0;

            // index - 1 위치로 이동
            while(idx++ < index) now = now.next;

            // index 위치에 num 추가
            Node tmp = new Node(num);
            tmp.next = now.next;
            now.next = tmp;

            // 사이즈 바꿔주기
            size++;
        }

        void addLast(int num) {

            Node node = new Node(num);

            tail.next = node;
            tail = node;

            size++;
        }

        void delete(int index) {

            Node now = head;
            int idx = 0;

            // index - 1 위치로 이동
            while(idx++ < index) now = now.next;

            // index 빼주기
            now.next = now.next.next;

            // 마지막 원소를 뺘준거라면 꼬리 정보 바꿔주기
            if(index == size - 1) tail = now;

            // 사이즈 바꿔주기
            size--;
        }

        void set(int index, int num) {

            Node now = head;
            int idx = 0;

            // index 위치로 이동
            while(idx++ <= index) now = now.next;

            // index 위치 수 바꿔주기
            now.num = num;
        }

        int get(int index) {

            // size를 넘어선 값이 입력으로 들어왔을 경우
            if(index >= size) return -1;

            // 꼬리 정보를 물어본 경우
            if(index == size - 1) return tail.num;

            Node now = head;
            int idx = 0;

            // index 위치로 이동
            while(idx++ <= index) now = now.next;

            return now.num;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        // T := 테스트케이스의 수
        int T = Integer.parseInt(br.readLine());
        int N, M, L, x, y; String cmd;
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            // 수열
            LinkedList list = new LinkedList();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.addLast(Integer.parseInt(st.nextToken()));
            }

            // 명령
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                cmd = st.nextToken();
                if(cmd.equals("I")) {
                    x = Integer.parseInt(st.nextToken());
                    y = Integer.parseInt(st.nextToken());
                    list.add(x, y);
                } else if(cmd.equals("D")) {
                    x = Integer.parseInt(st.nextToken());
                    list.delete(x);
                } else {
                    x = Integer.parseInt(st.nextToken());
                    y = Integer.parseInt(st.nextToken());
                    list.set(x, y);
                }
            }

            // L 인덱스 정보 저장
            answer.append("#" + tc + " " + list.get(L) + "\n");
        }

        System.out.println(answer);
    }
}
