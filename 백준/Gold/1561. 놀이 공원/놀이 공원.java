import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 마지막 아이가 타는 시간을 기준으로 이분 탐색
        long s = 0, e = 2_000_000_000L * 30, m;
        long last = 0, total = 0;
        long sum, l;
        while(s <= e) {
            m = (s + e) / 2;

            sum = 0; l = 0;
            for (int i = 0; i < M; i++) {
                // m 시간 동안 태울 수 있는 아이 수
                sum += m / arr[i] + 1;

                if(arr[i] * (m / arr[i]) > l) l = arr[i] * (m / arr[i]);
            }

            if(sum >= N) {
                last = l;
                total = sum;
                e = m - 1;
            }
            else {
                s = m + 1;
            }
        }

        // 마지막 아이가 탄 놀이기구 번호 구하기
        long sub = total - N;
        int result = 0;
        for (int i = M - 1; i >= 0; i--) {
            if(last % arr[i] == 0) {
                if(sub == 0) {
                    result = i + 1;
                    break;
                }
                else sub--;
            }
        }

        System.out.println(result);
    }
}