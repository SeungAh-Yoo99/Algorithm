import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;

    static boolean[] leftToRight;

    static int odd;
    static int even;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 왼쪽 위에서 오른쪽 밑으로 향하는 대각선 방향에는 비숍이 하나만 올 수 있음
        leftToRight = new boolean[N * 2 - 1];

        odd = 0; even = 0;
        back_tracking(0, 0);
        back_tracking(1, 0);
        System.out.println(odd + even);
    }

    // 오른쪽 위에서 왼쪽 아래로 내려오는 대각선 라인에서 하나만 골라 다음 라인 체크
    private static void back_tracking(int d, int count) {

        if(d >= N * 2 - 1) {
            if(d % 2 == 0) even = Math.max(even, count);
            else odd = Math.max(odd, count);
            return;
        }

        int start = d < N ? 0 : d - N + 1;

        for (int i = start; i < N; i++) {
            if(d - i >= 0 && map[i][d - i] == 1 && !leftToRight[getIndex(i, d - i)]) {
                leftToRight[getIndex(i, d - i)] = true;
                back_tracking(d + 2, count + 1);
                leftToRight[getIndex(i, d - i)] = false;
            }
        }
        // 현재 라인에서 아무것도 선택하지 않고 다음 라인으로 넘어감
        back_tracking(d + 2, count);
    }

    private static int getIndex(int x, int y) {

        if(x - y >= 0) return x - y;

        return N * 2 - 1 + x - y;
    }
}