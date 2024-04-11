import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] edges = new int[N - 1][2];
        long[] countOfEdges = new long[N + 1];

        int u, v;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());

            edges[i][0] = u;
            edges[i][1] = v;

            countOfEdges[u]++;
            countOfEdges[v]++;
        }

        long countD = 0;
        for (int i = 0; i < N - 1; i++) {
            // i번 엣지로 이어지는 두 정점에 대해 'ㄷ'의 개수 구하기
            countD += (countOfEdges[edges[i][0]] - 1) * (countOfEdges[edges[i][1]] - 1);
        }

        long countG = 0;
        for (int i = 1; i <= N; i++) {
            // 엣지가 3개 이상인 정점에 대해, 이어진 정점들 중 3개 고르기
            if(countOfEdges[i] >= 3) {
                countG += (countOfEdges[i] * (countOfEdges[i] - 1) * (countOfEdges[i] - 2)) / 6;
            }
        }

        if(countD > 3 * countG) System.out.println("D");
        else if(countD < 3 * countG) System.out.println("G");
        else System.out.println("DUDUDUNGA");
    }
}