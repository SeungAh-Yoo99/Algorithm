import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 100 * 10_000;

    static int N;
    static boolean[] visited;
    static int[][] dp;
    static int result;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // true := 리조트에 갈 수 있는 날
        // false := 리조트에 갈 수 없는 날
        visited = new boolean[N + 1];
        Arrays.fill(visited, true);

        if(M != 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                visited[Integer.parseInt(st.nextToken())] = false;
            }
        }

        // DP -> 같은 경우를 다시 계산하지 않기 위해 최소값 저장
        dp = new int[N + 6][N + 10];
        for (int i = 1; i < N + 6; i++) {
           Arrays.fill(dp[i], MAX);
        }

        result = MAX;
        backTracking(1, 0, 0);

        System.out.println(result);
    }

    private static void backTracking(int day, int coupon, int price) {

        // 리조트에 갈 수 있는 날로 이동
        while(day <= N && !visited[day]) day++;
        // 방학이 끝난 경우 답 갱신하고 리턴
        if(day > N) {
            result = Math.min(result, price);
            return;
        }

        // 쿠폰 이용하는 경우
        if(coupon >= 3 && dp[day + 1][coupon - 3] > price) {
            dp[day + 1][coupon - 3] = price;
            backTracking(day + 1, coupon - 3, price);
        }

        // 하루 이용권 이용하는 경우
        if(dp[day + 1][coupon] > price + 10_000) {
            dp[day + 1][coupon] = price + 10_000;
            backTracking(day + 1, coupon, price + 10_000);
        }

        // 연속 3일권 이용하는 경우
        if(dp[day + 3][coupon + 1] > price + 25_000) {
            dp[day + 3][coupon + 1] = price + 25_000;
            backTracking(day + 3, coupon + 1, price + 25_000);
        }

        // 연속 5일권 이용하는 경우
        if(dp[day + 5][coupon + 2] > price + 37_000) {
            dp[day + 5][coupon + 2] = price + 37_000;
            backTracking(day + 5, coupon + 2, price + 37_000);
        }
    }
}
