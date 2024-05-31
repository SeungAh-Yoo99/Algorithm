import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] num = br.readLine().toCharArray();

        Deque<Character> dq = new LinkedList<>();
        int count = 0; // 지운 개수
        int index = 0; // 현재 확인 중인 자리수

        while(index < N) {

            // 가장 앞 자릿수는 무조건 큐에 넣음
            if(dq.isEmpty()) {
                dq.addLast(num[index++]);
                continue;
            }

            // 앞자리수가 현재 확인 중인 자릿수보다 작으면 빼줌
            while(count < K && !dq.isEmpty() && dq.peekLast() < num[index]) {
                dq.pollLast();
                count++;
            }
            dq.addLast(num[index++]);
        }

        StringBuilder result = new StringBuilder();
        index = 0;
        while(index++ < N - K) {
            result.append(dq.pollFirst());
        }
        System.out.println(result);
    }
}