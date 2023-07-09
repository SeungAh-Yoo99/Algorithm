import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            long M = Long.parseLong(st.nextToken());

            Long[] candies = new Long[N];
            st = new StringTokenizer(br.readLine());
            long m = 0;
            for (int i = 0; i < N; i++) {
                candies[i] = Long.parseLong(st.nextToken());
                m = Math.max(m, candies[i]);
            }

            long s = 1, e = m;
            long ans = 0;
            while(s <= e) {
                long mid = (s + e) / 2;
                long p = M;

                for (int i = 0; i < N; i++) {
                    p -= (candies[i] - (candies[i] % mid)) / mid;
                    if(p <= 0) break;
                }

                if(p <= 0) {
                    ans = Math.max(ans, mid);
                    s = mid + 1;
                }
                else e = mid - 1;
            }

            result.append("#" + tc + " " + ans + "\n");
        }

        System.out.println(result);
    }
}