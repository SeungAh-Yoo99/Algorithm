import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] V = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        // 이미 구한 경우의 수는 다시 구하지 않기 위한 visited 배열
        boolean[][] visited = new boolean[N][M + 1];

        // 볼륨 조정 경우를 담은 큐
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {-1, S}); // 처음 곡

        int[] now; int next;
        int result = -1;
        while(!q.isEmpty()) {
            now = q.poll();

            if(now[0] == N - 1) {
                result = Math.max(result, now[1]);
                continue;
            }

            next = now[0] + 1;

            // 볼륨을 줄이는 경우
            if(now[1] - V[next] >= 0 && !visited[next][now[1] - V[next]]) { // 아직 확인 안 한 경우에만
                visited[next][now[1] - V[next]] = true;
                q.add(new int[] {next, now[1] - V[next]});
            }
            // 볼륨을 높이는 경우
            if(now[1] + V[next] <= M && !visited[next][now[1] + V[next]]) {
                visited[next][now[1] + V[next]] = true;
                q.add(new int[] {next, now[1] + V[next]});
            }
        }

        System.out.println(result);
    }
}