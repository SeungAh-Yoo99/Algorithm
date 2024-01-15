import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 과수원의 크기
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N + 1][N + 1]; // 누적합 저장
        int answer = -1000 * 300 * 300 - 1;
        int sum, tmp;
        for (int i = 1; i <= N; i++) {
            sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                tmp = Integer.parseInt(st.nextToken());
                sum += tmp;
                map[i][j] = sum + map[i - 1][j];
                answer = Math.max(answer, tmp); // 1 x 1 크기의 최대값 저장
            }
        }

        // k가 2 ~ N일 경우의 최대값 구하기
        for (int k = 2; k <= N; k++) {
            for (int i = k; i <= N; i++) {
                for (int j = k; j <= N; j++) {
                    answer = Math.max(answer, map[i][j] - map[i][j - k] - map[i - k][j] + map[i - k][j - k]);
                }
            }
        }

        // 츨력
        System.out.println(answer);
    }
}