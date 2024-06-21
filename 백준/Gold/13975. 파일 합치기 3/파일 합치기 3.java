import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int K;
        PriorityQueue<Long> pq;
        long a, b;
        long cost;
        for (int tc = 0; tc < T; tc++) {
            K = Integer.parseInt(br.readLine());

            // 큰 비용이 드는 파일일수록 되도록 합치는 연산을 하지 않는 것이 좋다.
            // 우선순위 큐에 비용을 넣어두고
            // 계속 적은 비용이 드는 것들끼리만 합쳐준다.

            pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            cost = 0;
            while(pq.size() > 1) { // 장이 하나가 될 때까지
                a = pq.poll();
                b = pq.poll(); // 가장 비용이 적은 값 두 개를 꺼내
                cost += a + b; // 비용을 추가해주고
                pq.add(a + b); // 다시 큐에 넣는다
            }

            result.append(cost + "\n");
        }

        System.out.println(result);
    }
}
