import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 인하대학교 크기, M := 폭탄 범위
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 현재 인하대학교 해발고도
        long[][] map = new long[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Long.parseLong(st.nextToken()) * -1; // 양수로 바꿔서 저장
            }
        }

        // 좌표별 폭탄 개수
        long[][] result = new long[N][N];

        // 행별 폭탄 누적합
        long[][] sum = new long[N][N];

        // 위-아래, 왼쪽-오른쪽 방향으로 확인
        long tmp;
        for (int i = 0; i <= N - M; i++) {
            tmp = 0; // i번째 줄의 sum 누적합
            for (int j = 0; j <= N - M; j++) {

                // (i + M / 2, j + M / 2)는 폭탄을 터트렸을 때,(i, j)를 범위의 가장 왼쪽 위로 가지는 좌표.
                // (i, j)에 (i + M / 2, J + M / 2)말고 다른 영향을 끼치는 폭탄 수만큼 빼주면 (i + M / 2, j + M / 2)의 폭탄 개수를 구할 수 있다.
                result[i + M / 2][j + M / 2] =
                        map[i][j]
                        - (sum[i + M / 2 - 1 < 0 ? 0 : i + M / 2 - 1][j + M / 2]
                                - sum[i + M / 2 - 1 < 0 ? 0 : i + M / 2 - 1][j - M / 2 - 1 < 0 ? 0 : j - M / 2 - 1]
                                - sum[i - M / 2 - 1 < 0 ? 0 : i - M / 2 - 1][j + M / 2]
                                + sum[i - M / 2 - 1 < 0 ? 0 : i - M / 2 - 1][j - M / 2 - 1 < 0 ? 0 : j - M / 2 - 1]) // (마지막 줄 - 1)까지의 누적 합
                        - (sum[i + M / 2][j + M / 2 - 1 < 0 ? 0 : j + M / 2 - 1]
                                - sum[i + M / 2][j - M / 2 - 1 < 0 ? 0 : j - M / 2 - 1]
                                - sum[i + M / 2 - 1 < 0 ? 0 : i + M / 2 - 1][j + M / 2 - 1 < 0 ? 0 : j + M / 2 - 1]
                                + sum[i + M / 2 - 1 < 0 ? 0 : i + M / 2 - 1][j - M / 2 - 1 < 0 ? 0 : j - M / 2 - 1]); // 마지막 줄 누적 합

                tmp += result[i + M / 2][j + M / 2]; // 이번 행의 누적합
                sum[i + M / 2][j + M / 2] = sum[i + M / 2 - 1 < 0 ? 0 : i + M / 2 - 1][j + M / 2] + tmp; // (i + M / 2, j + M / 2)에서의 누적합
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans.append(result[i][j] + " ");
            }
            ans.append("\n");
        }
        System.out.println(ans);
    }
}