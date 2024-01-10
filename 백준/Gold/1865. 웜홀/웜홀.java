import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<ArrayList<int[]>> edges;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        // TC := 테스트케이스의 개수
        int TC = Integer.parseInt(br.readLine());

        int M, W, S, E, T;
        for (int tc = 0; tc < TC; tc++) {
            // N := 지점의 수, M := 도로의 개수, W := 웜홀의 개수
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            // edges := 간선 정보
            edges = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                edges.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                S = Integer.parseInt(st.nextToken());
                E = Integer.parseInt(st.nextToken());
                T = Integer.parseInt(st.nextToken());
                edges.get(S).add(new int[] {E, T});
                edges.get(E).add(new int[] {S, T});
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                S = Integer.parseInt(st.nextToken());
                E = Integer.parseInt(st.nextToken());
                T = Integer.parseInt(st.nextToken());
                edges.get(S).add(new int[] {E, T * -1});
            }

            // 벨만포드 알고리즘을 사용하여 음수 사이클이 생겼는지 확인
            if(isPossible()) answer.append("YES\n");
            else answer.append("NO\n");
        }

        System.out.println(answer);
    }

    private static boolean isPossible() { // 벨만포드 알고리즘을 사용하여 음수 사이클이 생겼는지 확인

        // i부터 다른 지점에 도착하는 경우 구하기
        int[] minDis, now, next; Queue<int[]> q; ArrayList<int[]> edge;
        for (int i = 1; i <= N; i++) {

            minDis = new int[N + 1];
            Arrays.fill(minDis, Integer.MAX_VALUE);
            minDis[i] = 0;

            q = new LinkedList<>();
            q.add(new int[] {i, 0, 0});

            while(!q.isEmpty()) {
                now = q.poll();

                edge = edges.get(now[0]);
                for (int j = 0; j < edge.size(); j++) {
                    next = edge.get(j);

                    if(minDis[next[0]] > now[1] + next[1]) { // 더 짧은 경로를 찾았을 때만 이동
                        if(now[2] + 1 == N) { // 벨만포드 알고리즘에 의해서 N - 1개 이상의 간선을 지났다면 음수 사이클이 생긴 것
                            return true;
                        }
                        minDis[next[0]] = now[1] + next[1];

                        q.add(new int[] {next[0], now[1] + next[1], now[2] + 1});
                    }
                }
            }
        }

        // 모든 경우를 통과하고 여기까지 왔다면 음수 사이클이 생기지 않은 것
        return false;
    }

}