import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int MAX = 10_000_001;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 최단 비용 저장할 배열
        int[][] weight = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(weight[i], MAX);
            weight[i][i] = 0;
        }

        // 경로를 저장할 리스트
        ArrayList<Integer>[][] routes = new ArrayList[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                routes[i][j] = new ArrayList<>();
            }
        }

        // 버스 정보 입력
        int s, e, w;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            weight[s][e] = Math.min(weight[s][e], w);
        }

        // 플로이드-워셜
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    // i를 거쳐가는게 최소비용이라면
                    if(weight[j][i] + weight[i][k] < weight[j][k]) {
                        // 최소비용 갱신
                        weight[j][k] = weight[j][i] + weight[i][k];

                        // 거쳐가는 도시 리스트 갱신
                        routes[j][k].clear(); // 기존 리스트 삭제
                        routes[j][k].addAll(routes[j][i]); // j -> i까지의 도시 리스트 추가
                        routes[j][k].add(i);
                        routes[j][k].addAll(routes[i][k]); // i -> k까지의 도시 리스트 추가
                    }
                }
            }
        }

        // 출력
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                result.append(weight[i][j] == MAX ? 0 : weight[i][j]).append(" ");
            }
            result.append("\n");
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(weight[i][j] == 0 || weight[i][j] == MAX) {
                    result.append("0\n");
                }
                else {
                    result.append(routes[i][j].size() + 2).append(" ").append(i).append(" ");
                    for (int k = 0; k < routes[i][j].size(); k++) {
                        result.append(routes[i][j].get(k)).append(" ");
                    }
                    result.append(j).append("\n");
                }
            }
        }
        System.out.println(result);
    }
}
