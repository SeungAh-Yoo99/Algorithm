import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int n, k, t, m, i, j, s, grade;
        int[][] scores;
        int[] counts, lastTimes;
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            scores = new int[n + 1][k + 1];
            counts = new int[n + 1];
            lastTimes = new int[n + 1];

            for (int time = 0; time < m; time++) {
                st = new StringTokenizer(br.readLine());
                i = Integer.parseInt(st.nextToken());
                j = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());

                if(scores[i][j] < s) {
                    scores[i][0] += s - scores[i][j];
                    scores[i][j] = s;
                }
                counts[i]++;
                lastTimes[i] = time;
            }

            // 우리 팀보다 순위가 높은 팀 갯수 세기
            grade = 1;
            for (int a = 1; a <= n; a++) {
                if(a == t) continue;

                if(scores[a][0] > scores[t][0]) grade++;
                else if(scores[a][0] == scores[t][0]) {
                    if(counts[a] < counts[t]) grade++;
                    else if(counts[a] == counts[t]) {
                        if(lastTimes[a] < lastTimes[t]) grade++;
                    }
                }
            }

            result.append(grade).append("\n");
        }

        System.out.print(result);
    }
}
