import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<int[]>> edges = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            edges.add(new ArrayList<>());
        }

        int s, e, c;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            edges.get(s).add(new int[] {e, c});
            edges.get(e).add(new int[] {s, c});
        }

        // visited[i][0] := A에서 출발하여 i에 도착할 수 있는 경우의 수 중, 최대 요금이 가장 작은 값 저장
        // visited[i][1] := A에서 출발하여 i에 도착할 수 있는 경우의 수 중, 요금의 총합이 가장 작은 값 저장
        int[][] visited = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            visited[i][0] = Integer.MAX_VALUE;
            visited[i][1] = Integer.MAX_VALUE;
        }

        // 최대 요금이 작을수록 우선순위 높음
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        visited[A][0] = 0;
        visited[A][1] = 0;
        pq.add(new int[] {A, 0, 0});

        int[] now, next;
        ArrayList<int[]> edge;
        while(!pq.isEmpty()) {
            now = pq.poll();

            if(now[0] == B) {
                System.out.println(now[1]);
                return;
            }

            edge = edges.get(now[0]);
            for (int i = 0; i < edge.size(); i++) {
                next = edge.get(i);

                // 가진 돈을 초과할 순 없음
                if(now[2] + next[1] <= C) {
                    // next로 가는 방법 중, 최대 요금이 더 작은 방법을 찾았다면
                    if(visited[next[0]][0] > Math.max(now[1], next[1])) {
                        visited[next[0]][0] = Math.max(now[1], next[1]);

                        if(visited[next[0]][1] > now[2] + next[1])
                            visited[next[0]][1] = now[2] + next[1];

                        pq.add(new int[] {next[0], visited[next[0]][0], now[2] + next[1]});
                    }
                    // 최대 요금이 더 작진 않지만 총 비용이 작은 방법을 찾았다면
                    else {
                        if(visited[next[0]][1] > now[2] + next[1]) {
                            visited[next[0]][1] = now[2] + next[1];
                            pq.add(new int[] {next[0], Math.max(now[1], next[1]), visited[next[0]][1]});
                        }
                    }
                }
            }
        }

        // 방법을 찾지 못한 경우
        System.out.println(-1);
    }
}