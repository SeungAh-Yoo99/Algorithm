import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[][] points = new long[N + 1][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = Long.parseLong(st.nextToken());
            points[i][1] = Long.parseLong(st.nextToken());
        }
        points[N] = points[0];

        // 점 3개씩의 넓이 구하기
        long sum1 = 0L, sum2 = 0L;
        for (int i = 0; i < N; i++) {
            sum1 += points[i][0] * points[i + 1][1];
            sum2 += points[i][1] * points[i + 1][0];
        }

        System.out.printf("%.1f", Math.round(Math.abs(sum1 - sum2) / 2.0 * 10) / 10.0);
    }
}
