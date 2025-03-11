import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 카드 장수에 따라 오름차순으로 정렬해줄 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        int A, B;
        while(pq.size() > 1) {
            A = pq.poll();
            B = pq.poll();

            answer += A + B;
            pq.add(A + B);
        }

        System.out.println(answer);
    }
}
