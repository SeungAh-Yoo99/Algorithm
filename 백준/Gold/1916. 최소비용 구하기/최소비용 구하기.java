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

        // N := 도시의 개수
        int N = Integer.parseInt(br.readLine());

        // M := 버스의 개수
        int M = Integer.parseInt(br.readLine());

        // 버스 노선 정보
        ArrayList<ArrayList<int[]>> edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        int s, e, p;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            edges.get(s).add(new int[] {e, p});
        }

        // S := 출발점, E := 도착점
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // bfs를 통해 최소비용 구하기
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] < o2[1] ? -1 : 1);
        pq.add(new long[] {S, 0});

        long[] minLength = new long[N + 1];
        Arrays.fill(minLength, Long.MAX_VALUE);

        long[] now; ArrayList<int[]> edge; int[] next;
        while(!pq.isEmpty()) {
            now = pq.poll();

            // 이미 더 나은 경우를 확인한 후라면 이 경우는 넘어감
            if(minLength[(int)now[0]] < now[1]) continue;

            if(now[0] == E) { // 도착
                break;
            }

            edge = edges.get((int)now[0]);

            for (int i = 0; i < edge.size(); i++) {
                next = edge.get(i);

                if(minLength[next[0]] > now[1] + next[1]) {
                    minLength[next[0]] = now[1] + next[1];
                    pq.add(new long[] {next[0], minLength[next[0]]});
                }
            }
        }

        // 출력
        System.out.println(minLength[E]);
    }
}