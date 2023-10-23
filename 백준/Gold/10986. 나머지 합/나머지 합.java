import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 수의 개수 N, 연속된 부분 구간의 합 M 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N개의 수 입력
        long[] sum = new long[N]; // 누적합 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if(i == 0) sum[i] = Long.parseLong(st.nextToken());
            else sum[i] = Long.parseLong(st.nextToken()) + sum[i - 1];
        }

        /**
         * (sum[j] - sum[i - 1]) % M = 0
         * (sum[j] % M) - (sum[i - 1] % M) = 0
         * sum[j] % M = sum[i - 1] % M
         * 즉, 누적합을 M으로 나눴을 때 나머지가 같으면, (i, j)꺼지의 합이 M의 배수이다.
         */
        
        long[] rest = new long[M]; // 누적합의 나머지의 개수 저장
        for (int i = 0; i < N; i++) {
            rest[(int)(sum[i] % M)]++;
        }

        // 누적합의 나머지별로 2개씩 조합
        long result = rest[0];
        for (int i = 0; i < M; i++) {
            if(rest[i] > 0) result += rest[i] * (rest[i] - 1) / 2;
        }

        System.out.println(result);
    }
}