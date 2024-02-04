import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] canVisit = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if(st.nextToken().equals("0")) canVisit[i] = true;
        }

        // 방문할 수 있는 분기점을 지나는 간선 정보만 입력 받음
        ArrayList<ArrayList<int[]>> edges = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            edges.add(new ArrayList<>());
        }

        int a, b, t;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            if((canVisit[a] && canVisit[b]) || (a == N - 1 || b == N - 1)) {
                edges.get(a).add(new int[] {b, t});
                edges.get(b).add(new int[] {a, t});
            }
        }

        // 다익스트라
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1] < 0 ? -1 : 1);
        pq.add(new long[] {0, 0});

        long[] visited = new long[N];
        Arrays.fill(visited, Long.MAX_VALUE);

        long[] now; int[] next;
        ArrayList<int[]> edge;
        long result = -1;
        while(!pq.isEmpty()) {
            now = pq.poll();

            // N - 1에 도착
            if(now[0] == N - 1) {
                result = now[1];
                break;
            }

            // 이미 더 나은 경우를 찾은 경우, 지금 케이스는 더 이상 확인하지 않음
            if(visited[(int)now[0]] < now[1]) continue;

            edge = edges.get((int)now[0]);
            for (int i = 0; i < edge.size(); i++) {
                next = edge.get(i);
                if(visited[next[0]] > next[1] + now[1]) {
                    visited[next[0]] = next[1] + now[1];
                    pq.add(new long[] {next[0], visited[next[0]]});
                }
            }
        }

        System.out.println(result);
    }
}