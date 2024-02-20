import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        // T := 테스트케이스의 개수
        int T = Integer.parseInt(br.readLine());

        int N, M, X, s, e, t;
        ArrayList<ArrayList<int[]>> out, in;
        long result;
        for (int tc = 1; tc <= T; tc++) {
            // N := 사원의 수, M := 길의 수, X := 간담회를 여는 강의실
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            // 자신의 강의실에서 갈 수 있는 강의실 리스트
            out = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                out.add(new ArrayList<>());
            }

            // 다른 강의실에서 자신의 강의실로 올 수 있는 강의실 리스트
            in = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                in.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                t = Integer.parseInt(st.nextToken());
                out.get(s).add(new int[] {e, t});
                in.get(e).add(new int[] {s, t});
            }

            // 각 강의실에서 X번 강의실로 오는 최단 거리
            long[] maxInTime = new long[N + 1];
            Arrays.fill(maxInTime, Long.MAX_VALUE);
            dfs(maxInTime, in, X);

            // X번 강의실에서 각 강의실로 가는 최단 거리
            long[] maxOutTime = new long[N + 1];
            Arrays.fill(maxOutTime, Long.MAX_VALUE);
            dfs(maxOutTime, out, X);

            // 두 시간을 합친 시간 중 가장 긴 시간 답에 저장
            result = 0;
            for (int i = 1; i <= N; i++) {
                result = Math.max(result, maxInTime[i] + maxOutTime[i]);
            }
            answer.append("#" + tc + " " + result + "\n");
        }

        // 츨력
        System.out.println(answer);
    }

    private static void dfs(long[] result, ArrayList<ArrayList<int[]>> edges, int start) {

        Queue<long[]> q = new LinkedList<>();
        q.add(new long[] {start, 0});

        result[start] = 0;

        long[] now;
        int[] next;
        ArrayList<int[]> edge;
        while(!q.isEmpty()) {
            now = q.poll();

            if(result[(int)now[0]] < now[1]) continue;

            edge = edges.get((int)now[0]);
            for (int i = 0; i < edge.size(); i++) {
                next = edge.get(i);

                if(result[next[0]] > now[1] + next[1]) {
                    result[next[0]] = now[1] + next[1];
                    q.add(new long[] {next[0], result[next[0]]});
                }
            }
        }
    }
}
