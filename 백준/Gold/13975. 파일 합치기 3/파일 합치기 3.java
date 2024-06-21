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

            pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            cost = 0;
            while(pq.size() > 1) {
                a = pq.poll();
                b = pq.poll();
                cost += a + b;
                pq.add(a + b);
            }

            result.append(cost + "\n");
        }

        System.out.println(result);
    }
}