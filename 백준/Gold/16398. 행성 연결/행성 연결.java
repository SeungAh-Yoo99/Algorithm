import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 행성의 수
        int N = Integer.parseInt(br.readLine());

        // 크루스칼 알고리즘을 이용해 최단거리 구하기
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        int tmp;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                tmp = Integer.parseInt(st.nextToken());
                if(j > i) pq.add(new int[] {i, j, tmp}); // 시작점, 출발점, 비용 (시작점 < 출발점)
            }
        }

        // 크루스칼 알고리즘을 위한 부모 세팅
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int[] now;
        long result = 0;
        while(!pq.isEmpty()) {
            now = pq.poll();

            // 새로 연결되는 제국들일 경우 비용 더하기
            if(union(now[0], now[1])) result += now[2];
        }

        System.out.println(result);
    }

    private static int find(int num) {
        if(parent[num] == num) return num;

        return parent[num] = find(parent[num]);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        // 이미 연결되어 있다면
        if(a == b) return false;

        else {
            if(a < b) parent[b] = a;
            else parent[b] = a;
            return true;
        }
    }
}