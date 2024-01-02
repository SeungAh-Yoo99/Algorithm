import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        final int MAX = 4_000_001;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // V := 마을 개수, E := 도로 개수
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // V가 500 이하이므로 플로이드-워셜을 사용해 답을 구합

        // 플로이드-워셜 사용에 필요한 배열
        int[][] minLen = new int[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            Arrays.fill(minLen[i], MAX);
        }

        // 도로 정보 입력
        int a, b, c;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            minLen[a][b] = c;
        }

        // 플로이드=워셜
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                for (int k = 1; k <= V; k++) {
                    minLen[j][k] = Math.min(minLen[j][k], minLen[j][i] + minLen[i][k]);
                }
            }
        }

        // i -> j -> i 경로가 가장 짧은 것 찾기
        int result = MAX;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                result = Math.min(result, minLen[i][j] + minLen[j][i]);
            }
        }

        if(result == MAX) System.out.println(-1);
        else System.out.println(result);
    }
}