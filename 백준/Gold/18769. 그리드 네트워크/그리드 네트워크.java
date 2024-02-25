import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer =  new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int R, C, result;
        int[] now;
        PriorityQueue<int[]> pq;
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            // 크루스칼 알고리즘에 사용할 부모 배열
            parent = new int[R * C];
            for (int i = 0; i < R * C; i++) {
                parent[i] = i;
            }

            // 크루스칼 알고리즘에 사용할 우선순위 큐
            pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

            // 간선 정보 입력
            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C - 1; j++) {
                    pq.add(new int[] {Integer.parseInt(st.nextToken()), i * C + j, i * C + j + 1});
                }
            }
            for (int i = 0; i < R - 1; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    pq.add(new int[] {Integer.parseInt(st.nextToken()), i * C + j, (i + 1) * C + j});
                }
            }

            // 크루스칼 알고리즘
            result = 0;
            while(!pq.isEmpty()) {
                now = pq.poll();

                if(union(now[1], now[2])) result += now[0];
            }

            answer.append(result + "\n");
        }

        System.out.println(answer);
    }

    static private int find(int a) {
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    static private boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) return false;

        if(a < b) parent[b] = a;
        else parent[a] = b;
        return true;
    }
}