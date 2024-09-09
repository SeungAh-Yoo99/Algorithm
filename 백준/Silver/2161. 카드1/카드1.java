import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.offerLast(i);
        }

        int iter = 1;
        StringBuilder result = new StringBuilder();
        while(!deque.isEmpty()) {

            if((iter & 1) == 1) {
                result.append(deque.pollFirst() + " ");
            }
            else {
                deque.offerLast(deque.pollFirst());
            }

            iter++;
        }

        System.out.println(result);
    }
}