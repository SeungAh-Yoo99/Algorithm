import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // ArrayDeque를 stack으로 사용
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // 값을 다 넣어줌
        for (int i = 0; i < N; i++) {
            stack.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        int last = 0; // 마지막에 보이는 막대기 크기
        int tmp;
        while(!stack.isEmpty()) {
            tmp = stack.pollLast();

            // 더 큰 막대기를 발견했다면, 이 막대기는 보임
            if(last < tmp) {
                result++;
                last = tmp;
            }
        }

        System.out.println(result);
    }
}