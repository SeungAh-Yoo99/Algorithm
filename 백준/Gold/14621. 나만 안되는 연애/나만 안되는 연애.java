import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N:= 학교의 수, M := 도로의 개수
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 학교 정보
        String[] school = new String[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            school[i] = st.nextToken();
        }

        /**
         * 크루스칼 알고리즘을 사용하기 위해
         * 간선 정보를 입력 받으며 우선순위 큐에 넣는다.
         *
         * 1번 조건에 의해
         * 만약, 두 도로가 남초 <-> 남초 거나, 여초 <-> 여초 인 경우에는 큐에 넣지 않는다.
         */
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        int u, v, d;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            // 두 학교 정보가 같다면 넘어감
            if(school[u].equals(school[v])) continue;

            pq.add(new int[] {u, v, d});
        }

        // 크루스칼 이용해 최단 거리 구하기
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int[] edge;
        int result = 0;
        while (!pq.isEmpty()) { // 거리가 짧은 도로부터 꺼내기
            edge = pq.poll();

            // 이 도로를 사용한다면
            if(union(edge[0], edge[1])) result += edge[2];
        }

        // 모든 학교가 연결되어 있는지 확인
        for (int i = 1; i <= N; i++) {
            if(find(i) != 1) result = -1;
        }

        // 출력
        System.out.println(result);
    }

    private static int find(int a) {
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    private static boolean union(int a, int b) { // 새료 연결해주었다면 true

        a = find(a);
        b = find(b);

        if(a == b) return false; // 이미 연결되어 있으므로 fasle

        // 새료 연결
        if(a < b) parent[b] = a;
        else parent[a] = b;
        return true;
    }
}