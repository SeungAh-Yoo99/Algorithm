import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] temps = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            temps[i] = Integer.parseInt(st.nextToken());
        }


        // 0 ~ K - 1까지의 온도 합
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += temps[i];
        }

        // 슬라이딩 윈도우
        int answer = sum;
        for (int i = 0; i < N - K; i++) {
            sum -= temps[i];
            sum += temps[i + K];
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}