import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N := 배열의 크기
        long N = Long.parseLong(br.readLine());

        // k := 찾고 싶은 인덱스
        int k = Integer.parseInt(br.readLine());

        // 이분 탐색으로 앞에 k개 오는 수 구하기
        int s = 1, m, tmp1, tmp2;
        int e = (int)Math.min(1_000_000_000, N * N);

        while(s <= e) {
            m = (s + e) / 2;

            // m - 1 앞에 몇 개나 오는지 구하기
            tmp1 = 0;
            for (int i = 1; i <= Math.min(N, m - 1); i++) {
                tmp1 += Math.min(N, (m - 1) / i);
            }

            // m 앞에 몇 개나 오는지도 구하기
            tmp2 = 0;
            for (int i = 1; i <= Math.min(N, m); i++) {
                tmp2 += Math.min(N, m / i);
            }

            // k가 num[m - 1] ~ num[m] 사이 값이면 m이 답
            if(tmp1 < k && tmp2 >= k) {
                System.out.println(m);
                return;
            }

            if(tmp2 >= k) e = m - 1;
            else s = m + 1;
        }
    }
}