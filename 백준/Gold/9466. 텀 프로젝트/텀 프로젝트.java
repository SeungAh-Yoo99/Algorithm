import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] s;
    static boolean[] visited;
    static int[][] order;
    static int result;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int n, count;
        for (int tc = 0; tc < T; tc++) {
            n = Integer.parseInt(br.readLine());

            s = new int[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[n + 1];
            order = new int[n + 1][2];
            result = n;
            count = 0;
            for (int i = 1; i <= n; i++) {
                if(!visited[i]) {
                    dfs(i, count++, 1);
                }
            }

            answer.append(result + "\n");
        }

        System.out.print(answer);
    }

    private static void dfs(int node, int count, int o) {

        visited[node] = true;
        order[node][0] = count;
        order[node][1] = o;

        // node가 선택한 학생이 아직 확인 전이라면
        if(!visited[s[node]]) dfs(s[node], count, o + 1);
        // 서클이 생겼다면
        else if(order[s[node]][0] == count) result -= o - order[s[node]][1] + 1;
    }
}