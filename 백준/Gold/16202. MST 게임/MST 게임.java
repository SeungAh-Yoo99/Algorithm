import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 간선 정보
        int[][] edges = new int[M + 1][3];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = i;
        }

        int cost = 0, count;
        for (int i = 0; i < K; i++) {

            // 전 단계에서 MST 비용을 구하지 못한 경우
            if(i != 0 && cost == 0) {
                answer.append(0 + " ");
                continue;
            }

            cost = 0;
            count = 0;

            // 크루스칼 알고리즘을 사용하기 위한 부모 정보
            parent = new int[N + 1];
            for (int j = 1; j <= N; j++) {
                parent[j] = j;
            }

            for (int j = i + 1; j <= M; j++) {
                if(union(edges[j][0], edges[j][1])) {
                    cost += edges[j][2];
                    count++;
                }
                if(count == N - 1) break;
            }

            // MST를 구하지 못한 경우
            if(count != N - 1) cost = 0;

            answer.append(cost + " ");
        }

        System.out.println(answer);
    }

    private static int find(int a) {
        if(parent[a] == a) return a;

        return parent[a] = find(parent[a]);
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) return false;

        if(a < b) parent[b] = a;
        else parent[a] = b;
        return true;
    }
}
