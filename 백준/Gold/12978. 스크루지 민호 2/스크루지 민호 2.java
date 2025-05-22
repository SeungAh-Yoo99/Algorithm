import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> edges;
    static int[][] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 도시 연결 상태 저장 리스트
        edges = new ArrayList<>();
        for(int i = 0; i <= N; i++)
            edges.add(new ArrayList<>());

        int u, v;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            edges.get(u).add(v);
            edges.get(v).add(u);
        }

        dp = new int[N + 1][2];

        // 1번 도시부터 시작
        dfs(1, 0);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void dfs(int now, int parent) {

        ArrayList<Integer> edge = edges.get(now);

        for(int next : edge) {
            if(next != parent) {
                dfs(next, now);

                // now에 경찰서를 건설할 경우, next에는 건설하든 하지 않든 상관 없음
                dp[now][0] += Math.min(dp[next][0], dp[next][1]);
                // now에 경찰서를 건설하지 않을 경우, next에는 무조건 건설해야 함
                dp[now][1] += dp[next][0];
            }
        }

        // now에 경찰서 건설
        dp[now][0] += 1;
    }
}
