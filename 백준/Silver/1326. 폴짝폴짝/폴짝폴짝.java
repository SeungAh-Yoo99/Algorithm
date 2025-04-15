import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] bridge = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 이미 b에 도착한 경우
        if(a == b) {
            System.out.println(-1);
            return;
        }

        // 이미 경우의 수를 확인한 징검다리는 중복으로 확인하지 않기 위한 방문 배열
        boolean[] visited = new boolean[N + 1];

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {a, 0});
        visited[a] = true;

        int[] now;
        while(!queue.isEmpty()) {
            now = queue.pollFirst();

            // 왼쪽으로 이동할 경우
            for(int next = now[0] - bridge[now[0]]; next > 0; next -= bridge[now[0]]) {
                if(!visited[next]) { // 이미 방문한 곳은 재방문하지 않음
                    if(next == b) { // 도착했다면
                        System.out.println(now[1] + 1);
                        return;
                    }
                    queue.add(new int[] {next, now[1] + 1});
                    visited[next] = true;
                }
            }

            // 오른쪽으로 이동할 경우
            for(int next = now[0] + bridge[now[0]]; next <= N; next += bridge[now[0]]) {
                if(!visited[next]) { // 이미 방문한 곳은 재방문하지 않음
                    if(next == b) { // 도착했다면
                        System.out.println(now[1] + 1);
                        return;
                    }
                    queue.add(new int[] {next, now[1] + 1});
                    visited[next] = true;
                }
            }
        }

        System.out.println(-1);
    }
}
