import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Deque<int[]> deque = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            deque.offerLast(new int[] {Integer.parseInt(st.nextToken()), i});
        }

        int[] now = deque.pollFirst();
        result.append(now[1]);
        while(!deque.isEmpty()) {

            // 이전에 터진 풍선 안의 종이에 적혀있는 값이 양수라면 오른쪽 풍선으로 이동
            // 즉, 왼쪽 값을 꺼내 오른쪽에 다시 넣는다
            if(now[0] > 0) {
                now[0] %= deque.size(); // 반복되는 횟수를 줄이기 위해 나머지 값만큼만 수행
                if(now[0] == 0) { // 맨 마지막 풍선으로 이동하는 경우
                    now = deque.pollLast();
                    result.append(" ").append(now[1]);
                    continue;
                }
                // 원하는 풍선 전까지 왼쪽 풍선 빼서 오른쪽에 추가
                for (int i = 1; i < now[0]; i++) {
                    deque.offerLast(deque.pollFirst());
                }
                now = deque.pollFirst();
                result.append(" ").append(now[1]);
            }
            // 음수라면 왼쪽 풍선으로 이동
            // 즉, 오른쪽 값을 꺼내 왼쪽에 다시 넣는다
            else {
                now[0] *= -1; // 얼만큼 이동해야 하는지 계산하기 위해 양수값으로 만들어줌
                now[0] %= deque.size();
                if(now[0] == 0) {
                    now = deque.pollFirst();
                    result.append(" ").append(now[1]);
                    continue;
                }
                // 원하는 풍선 전까지 오른쪽 풍선 빼서 왼쪽에 추가
                for (int i = 1; i < now[0]; i++) {
                    deque.offerFirst(deque.pollLast());
                }
                now = deque.pollLast();
                result.append(" ").append(now[1]);
            }
        }

        System.out.println(result);
    }
}