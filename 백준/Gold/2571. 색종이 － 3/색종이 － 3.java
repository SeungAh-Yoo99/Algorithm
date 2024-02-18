import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        boolean[][] black = new boolean[101][101];
        int[][] paper = new int[101][101];

        int x, y;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= 10; j++) {
                for (int k = 1; k <= 10; k++) {
                    black[j + x][k + y] = true;
                }
            }
        }

        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                if(black[i][j]) paper[i][j] = paper[i][j - 1] + 1;
            }
        }

        int answer = 0, count;
        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {
                count = paper[i][j];
                for (int k = i; k > 0; k--) {
                    count = Math.min(count, paper[k][j]);
                    answer = Math.max(answer, count * (i - k + 1));
                }
            }
        }

        System.out.println(answer);
    }
}
