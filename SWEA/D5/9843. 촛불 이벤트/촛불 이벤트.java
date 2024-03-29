import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            long N = Long.parseLong(br.readLine());

            /*
            N = (K(K+1)/2 이므로
            2N = K(K + 1)
            1 ~ N 사이의 수 중 K(K+1) = 2N을 만족하는 K를 이분 탐색으로 찾으면 된다.
             */

            // 이분 탐색
            long start = 1;
            long end = (long)Math.sqrt(N * 2);

            long result = -1;
            while(start <= end) {
                long K = (start + end) / 2;
                long num = K * (K + 1) / 2;

                if(num == N) {
                    result = K;
                    break;
                }
                else if(num > N) {
                    end = K - 1;
                }
                else {
                    start = K + 1;
                }
            }

            sb.append("#" + t + " " + result + "\n");
        }

        System.out.print(sb);
    }
}