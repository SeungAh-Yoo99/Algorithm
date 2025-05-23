import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long D = Long.parseLong(st.nextToken());

        // 규칙
        int[][] rules = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            rules[i][0] = Integer.parseInt(st.nextToken());
            rules[i][1] = Integer.parseInt(st.nextToken());
            rules[i][2] = Integer.parseInt(st.nextToken());
        }

        // 이분탐색
        int s = 1, e = N, m;
        long d;
        int result = 0;
        while(s <= e) {
            m = (s + e) / 2;

            // m번 상자까지 몇 개의 도토리를 넣을 수 있는지 확인
            d = 0;
            for (int i = 0; i < K; i++) {
                if(rules[i][0] <= m) {
                    d += (Math.min(m, rules[i][1]) - rules[i][0]) / rules[i][2] + 1;
                }
            }

            if(d < D) { // 뒷 상자까지 도토리를 담을 수 있다면
                s = m + 1;
            }
            else {// m번 상자까지 도토리를 담을 수 없다면
                result = m;
                e = m - 1;
            }
        }

        System.out.println(result);
    }
}
