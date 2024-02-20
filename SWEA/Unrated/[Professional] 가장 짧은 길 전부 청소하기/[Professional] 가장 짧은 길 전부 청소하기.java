import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        // T := 테스트케이스의 개수
        int T = Integer.parseInt(br.readLine());

        int N, M, s, e, l;
        ArrayList<ArrayList<int[]>> edges;
        ArrayList<int[]> edge;
        PriorityQueue<long[]> pq;
        long[] minLength, price, now;
        long result;
        int[] next;
        for (int tc = 1; tc <= T; tc++) {

            // N := 건물의 수, M := 길들의 수
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 길 정보
            edges = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                edges.add(new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                l = Integer.parseInt(st.nextToken());
                edges.get(s).add(new int[] {e, l});
                edges.get(e).add(new int[] {s, l});
            }

            // 해당 건물의 최단거리
            minLength = new long[N + 1];
            Arrays.fill(minLength, Long.MAX_VALUE);
            minLength[1] = 0;

            // 해당 건물을 가기위해 사용한 길의 거리
            price = new long[N + 1];

            pq = new PriorityQueue<>((o1, o2) -> o1[1] < o2[1] ? -1 : 1);
            pq.add(new long[] {1, 0});

            while (!pq.isEmpty()) {
                now = pq.poll();

                if(minLength[(int)now[0]] < now[1]) continue;

                edge = edges.get((int)now[0]);
                for (int i = 0; i < edge.size(); i++) {
                    next = edge.get(i);

                    if(minLength[next[0]] > now[1] + next[1]) { // next로 가기 위한 최단 거리를 찾은 경우
                        minLength[next[0]] = now[1] + next[1];
                        price[next[0]] = next[1];
                        pq.add(new long[] {next[0], minLength[next[0]]});
                    } else if(minLength[next[0]] == now[1] + next[1] && price[next[0]] > next[1]) { // next로 가기 위한 최단 거리를 같지만, 더 짧은 길을 사용할 수 있는 경우
                        price[next[0]] = next[1];
                    }
                }
            }


            result = 0;
            for (int i = 1; i <= N; i++) {
                result += price[i];
            }

            // 답 저장
            answer.append("#" + tc + " " + result + "\n");
        }

        System.out.println(answer);
    }
}
