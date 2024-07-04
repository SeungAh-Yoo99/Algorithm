import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 10_000_000;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] length = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                Arrays.fill(length[i], MAX);
                length[i][i] = 0;
            }

            int a, b, c;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());

                length[a][b] = c;
                length[b][a] = c;
            }

            // 플로이드워셜
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    for (int k = 1; k <= N; k++) {
                        length[j][k] = Math.min(length[j][k], length[j][i] + length[i][k]);
                    }
                }
            }

            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> member = new ArrayList<>();
            for (int i = 0; i < K; i++) {
                member.add(Integer.parseInt(st.nextToken()));
            }

            int answer = 0;
            int max_length = MAX * N;
            int tmp;
            for (int i = 1; i <= N; i++) {
                tmp = 0;
                for (int j = 0; j < member.size(); j++) {
                    tmp += length[member.get(j)][i];
                }
                if(max_length > tmp) {
                    max_length = tmp;
                    answer = i;
                }
            }

            result.append(answer + "\n");
        }

        System.out.print(result);
    }
}