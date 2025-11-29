import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder result;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M + 1];
        visited = new boolean[N + 1];
        result = new StringBuilder();

        combi(1);

        System.out.print(result);
    }

    private static void combi(int len) {
        if(len == M + 1) {
            for (int i = 1; i <= M; i++) {
                result.append(arr[i]).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[len] = i;
                combi(len + 1);
                visited[i] = false;
            }
        }
    }
}
