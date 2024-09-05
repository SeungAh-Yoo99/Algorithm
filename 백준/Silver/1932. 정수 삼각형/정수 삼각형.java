import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 삼각형의 왼쪽, 오른쪽에 여백을 줌
        int[][] dp = new int[n + 1][n + 2];

        // 리프 노드를 dp에 담아줌
        for (int i = 1; i <= n; i++) {
            dp[n][i] = arr[n][i];
        }

        // 자신의 왼쪽, 오른쪽 자식 중 더 큰 수를 가져옴
        for (int i = n - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + arr[i][j];
            }
        }

        // 출력
        System.out.println(dp[1][1]);
    }
}