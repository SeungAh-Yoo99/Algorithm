import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Long> map = new HashMap<>();
        map.put(arr[0], 1L);

        HashMap<Integer, Long> tmp;
        int sum, sub;
        for (int i = 1; i < N - 1; i++) {

            tmp = new HashMap<>();

            for(int key : map.keySet()) {

                sum = key + arr[i];
                sub = key - arr[i];

                if(sum <= 20) {
                    tmp.put(sum, tmp.getOrDefault(sum, 0L) + map.get(key));
                }

                if(sub >= 0) {
                    tmp.put(sub, tmp.getOrDefault(sub, 0L) + map.get(key));
                }
            }

            map = tmp;
        }

        long result = map.get(arr[N - 1]);
        System.out.println(result);
    }
}