import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // dp 사용 시 IndexOutOfBounds 에러를 방지하기 위해 앞에 2칸 테두리 추가
        int[] arr = new int[N + 2];
        for (int i = 2; i < N + 2; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[M + 1][N + 2];
        int pre_max;
        for (int i = 1; i <= M; i++) { // i개의 구간 합 최대값 구하기

            pre_max = dp[i - 1][2 * i - 2];
            dp[i][2 * i] = pre_max + arr[2 * i];

            for (int j = 2 * i + 1; j < N + 2; j++) {
                pre_max = Math.max(pre_max, dp[i - 1][j - 2]);
                dp[i][j] = Math.max(pre_max, dp[i][j - 1]) + arr[j];
            }
        }

        int result = -32768 * 100 - 1;
        for (int i = 2 * M; i < N + 2; i++) {
            result = Math.max(result, dp[M][i]);
        }
        System.out.println(result);
    }
}