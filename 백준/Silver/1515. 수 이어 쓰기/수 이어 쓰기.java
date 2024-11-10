import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int now = 0; // 현재 수
        Deque<Character> dq = new ArrayDeque<>();

        Character n;
        int tmp;
        for (int i = 0; i < N.length(); i++) {
            n = N.charAt(i); // N의 i번째 자리에 오는 숫자

            while(true) {
                if(dq.isEmpty()) { // 큐에 아무 수도 없다는건 현재 n이 now에 속하는 숫자가 아님
                    now++; // now를 +1 해주고

                    // now의 숫자들을 큐에 넣어줌
                    tmp = now;
                    while(tmp > 0) {
                        dq.addFirst((char)((tmp % 10) + '0'));
                        tmp /= 10;
                    }
                }

                // n에 해당하는 숫자를 찾았다면 다음 n을 확인하러
                if(dq.pollFirst() == n) {
                    break;
                }
            }
        }

        System.out.println(now);
    }
}