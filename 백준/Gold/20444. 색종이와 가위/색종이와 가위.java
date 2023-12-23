import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        // (m + 1) * (n - m + 1) = k라면 성립
        // 이분 탐색으로 m을 찾는다
        String result = "NO";
        long s = 0, e = n / 2 + 1, m, tmp;
        while(s <= e) {
            m = (s + e) / 2;

            tmp = (m + 1) * (n - m + 1);
            if(tmp == k) {
                result = "YES";
                break;
            }
            else if (tmp > k) {
                e = m - 1;
            }
            else s = m + 1;
        }

        // 출력
        System.out.println(result);
    }
}