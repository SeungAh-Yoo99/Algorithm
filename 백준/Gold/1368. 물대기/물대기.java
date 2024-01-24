import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception{

        final int MAX = 30_000_001;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 논의 수
        int N = Integer.parseInt(br.readLine());

        /**
         * 크루스칼 알고리즘 사용
         *
         * 1 ~ N번의 우물을 0번의 가상 우물에 모두 연결해준다.
         */

        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        for (int i = 1; i <= N; i++) {
            pq.add(new int[] {0, i, Integer.parseInt(br.readLine())}); // 새로 우물을 파는 경우를 0번의 가상 우물에 연결시켜준다고 생각.
        }
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if(i < j) pq.add(new int[] {i, j, Integer.parseInt(st.nextToken())});
                else Integer.parseInt(st.nextToken()); // 중복된 경우는 넣어주지 않음
            }
        }

        int[] now;
        int sum = 0;
        while(!pq.isEmpty()) {
            now = pq.poll();

            // 새로 연결시킨 경우
            if(union(now[0], now[1])) sum += now[2];
        }

        // 출력
        System.out.println(sum);
    }

    private static int find(int a) {
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    private static boolean union(int a, int b) {

        a = find(a);
        b = find(b);

        // 이미 연결되어 있는 경우
        if(a == b) return false;
        else if(a < b) parent[b] = a;
        else parent[a] = b;
        return true;
    }
}
