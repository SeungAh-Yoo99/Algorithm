import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        // 크루스칼 알고리즘
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        int A, B, C;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            pq.add(new int[] {A, B, C});
        }

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int[] now;
        int result = 0;
        int count = 0;
        while(!pq.isEmpty()) {
            now = pq.poll();

            if(union(now[0], now[1])) { // 아직 정복하지 않은 도시를 발견했을 경우
                result += now[2] + (t * count++); // 비용 더하기
            }
        }

        System.out.println(result);
    }

    private static int find(int a) {

        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    private static boolean union(int a, int b) {

        a = find(a);
        b = find(b);

        // 이미 연결되어 있다면 false
        if(a == b) return false;

        // 아직 연결 전이라면 true;
        if(a < b) parent[b] = a;
        else parent[a] = b;
        return true;
    }
}