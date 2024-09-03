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

        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        // 이분 탐색
        int s = 0, e = 1_000_000_000, m;
        long sum;
        int result = 0;
        while(s <= e) {
            m = (s + e) / 2;

            sum = 0;
            for(int tree : trees) {
                sum += tree - m <= 0 ? 0 : tree - m;
            }

            if(sum >= M) {
                result = m;
                s = m + 1;
            } else e = m - 1;
        }

        System.out.println(result);
    }
}