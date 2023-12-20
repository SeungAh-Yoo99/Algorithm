import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        final int MAX = 10_000_001;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n := 집하장의 개수, m := 집하장간 경로의 개수
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 최단 경로
        int[][] edges = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(edges[i], MAX);
        }

        // 가장 먼저 거쳐야 하는 집하장
        int[][] first = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                first[i][j] = j;
            }
        }

        // 경로 정보 입력
        int a, b, l;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            edges[a][b] = l;
            edges[b][a] = l;
        }

        // n이 200 이하이므로 플로이드-워셜로 최단 거리 구하기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if(edges[j][k] > edges[j][i] + edges[i][k]) {
                        edges[j][k] = edges[j][i] + edges[i][k];
                        first[j][k] = first[j][i];
                    }
                }
            }
        }

        // 출력
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j) result.append("- ");
                else result.append(first[i][j] + " ");
            }
            result.append("\n");
        }
        System.out.println(result);
    }
}