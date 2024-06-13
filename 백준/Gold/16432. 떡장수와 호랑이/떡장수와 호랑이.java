import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static boolean[][] rice_cake;
    static boolean[][] visited;
    static int[] pick;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        rice_cake = new boolean[N + 1][10];
        int m;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                rice_cake[i][Integer.parseInt(st.nextToken())] = true;
            }
        }

        // 이미 구한 적 있는 조합의 경우 구하지 않기 위한 방문 체크 배열
        visited = new boolean[N + 1][10];

        // 고른 떡 종류
        pick = new int[N + 1];

        // 떡을 줄 방법이 있는 경우 조합 구하기
        dfs(1);

        // 답이 없는 경우
        if(pick[N] == 0) {
            System.out.println(-1);
            return;
        }

        // 조합을 구한 경우
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            result.append(pick[i] + "\n");
        }
        System.out.println(result);
    }

    private static void dfs(int day) {

        if(day == N + 1) {
            return;
        }

        for (int i = 1; i <= 9; i++) {

            // 전 날 고른 떡과 같은 종류의 떡이 아니고
            // 오늘 가져간 종류의 떡 중 하나이며
            // 아직 확인한 적 업는 조합일 경우
            if(pick[day - 1] != i && rice_cake[day][i] && !visited[day][i]) {
                pick[day] = i;
                visited[day][i] = true;
                dfs(day + 1);
            }

            // 이미 조합이 끝난 경우 더 이상 확인하지 않음
            if(pick[N] != 0) break;
        }
    }
}