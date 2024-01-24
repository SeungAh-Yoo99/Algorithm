import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        // T := 테스트케이스의 개수
        int T = Integer.parseInt(br.readLine());

        int N, K, X, Y, W, next; int[] D; ArrayList<ArrayList<Integer>> edges; long[] time;
        Queue<long[]> q; long[] now; ArrayList<Integer> edge;
        for (int tc = 0; tc < T; tc++) {
            // N := 건물의 개수, K := 건설순서 규칙 개수
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // 건설에 걸리는 시간
            D = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                D[i] = Integer.parseInt(st.nextToken());
            }

            // 건설 규칙 (i번 건물을 짓기 위해 먼저 지어야 하는 건물을 담음)
            edges = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                edges.add(new ArrayList<>());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());
                edges.get(Y).add(X);
            }

            // W := 건설해야 할 건물의 번호
            W = Integer.parseInt(br.readLine());

            // W부터 시작해서 거꾸로 확인하여 가장 건물 짓는 시간 확인
            time = new long[N + 1];
            time[W] = D[W];

            q = new LinkedList<>();
            q.add(new long[] {W, D[W]});

            while(!q.isEmpty()) {
                now = q.poll();

                if(time[(int)now[0]] > now[1]) continue;

                edge = edges.get((int)now[0]);

                for (int i = 0; i < edge.size(); i++) {
                    next = edge.get(i);

                    if(time[next] < now[1] + D[next]) {
                        time[next] = now[1] + D[next];
                        q.add(new long[] {next, time[next]});
                    }
                }
            }

            long result = 0;
            for (int i = 1; i <= N; i++) {
                result = Math.max(result, time[i]);
            }

            answer.append(result + "\n");
        }

        System.out.println(answer);
    }
}