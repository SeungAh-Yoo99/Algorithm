import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> hm = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int x;
        for (int i = 0; i < K; i++) {
            x = Integer.parseInt(st.nextToken());

            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }

        arr = new int[N];
        for (int key : hm.keySet()) {
            something(key, hm.get(key));
        }

        long[] sum = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }

        StringBuilder result = new StringBuilder();
        int Q = Integer.parseInt(br.readLine());
        int L, R;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            result.append((sum[R + 1] - sum[L]) + "\n");
        }

        System.out.print(result);
    }

    static void something(int jump, int count) {

        int i = 0;
        while(i < N) {
            arr[i] += count;
            i += jump;
        }
    }
}