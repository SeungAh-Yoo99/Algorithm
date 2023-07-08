import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] days = new int[n];
            for (int i = 0; i < n; i++) days[i] = Integer.parseInt(st.nextToken());

            int ans = 0;
            for (int i = 0; i < n ; i++) { // i := 시작일의 인덱스
                int s = i, e = n - 1;

                while(s <= e) {
                    int mid = (s + e) / 2; // 가능성이 있는 날의 인덱스
                    int blank = (days[mid] - days[i] + 1) - (mid - i + 1);

                    if(blank > p) e = mid - 1;
                    else {
                        ans = Math.max(ans, (days[mid] - days[i] + 1) + (p - blank));
                        s = mid + 1;
                    }
                }
            }

            sb.append("#" + tc + " " + ans + "\n");
        }

        System.out.println(sb);
    }
}