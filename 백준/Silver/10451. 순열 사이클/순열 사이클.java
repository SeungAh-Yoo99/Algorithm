import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        int N, count;
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            arr = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            visited = new boolean[N + 1];
            count = 0;

            for (int i = 1; i <= N; i++) {
                if(!visited[i]) {
                    dfs(i);
                    count++;
                }
            }

            answer.append(count).append("\n");
        }

        System.out.print(answer);
    }

    private static void dfs(int num) {

        visited[num] = true;

        if(!visited[arr[num]]) dfs(arr[num]);
    }
}
