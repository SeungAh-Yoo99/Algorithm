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

        int[] arr = new int[N];
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        // 이분 탐색
        int s = 0, e = sum, m;
        int count;
        int result = 0;
        while(s <= e) {
            m = (s + e) / 2;

            // 합이 m 이상이도록 그룹을 나눴을 때, 그룹의 개수가 K개인지 확인
            sum = 0; count = 0;
            for (int i = 0; i < N; i++) {
                sum += arr[i];

                if(sum >= m) {
                    sum = 0;
                    count++;
                }
            }

            if(count >= K) {
                result = m;
                s = m + 1;
            } else e = m - 1;
        }

        System.out.println(result);
    }
}