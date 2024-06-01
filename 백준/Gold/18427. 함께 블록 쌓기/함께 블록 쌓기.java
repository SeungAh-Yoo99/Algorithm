import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    private static final int MOD = 10_007;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> hm = new HashMap<>();
        HashMap<Integer, Integer> tmp;
        hm.put(0, 1);

        int h, newKey;
        for (int i = 0; i < N; i++) {
            tmp = new HashMap<>();

            // 현재 학생의 블록을 사용하지 않는 경우
            for (int key : hm.keySet()) {
                tmp.put(key, hm.get(key));
            }

            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
              h = Integer.parseInt(st.nextToken());

                for (int key : hm.keySet()) {
                    newKey = key + h;
                    if(newKey <= H) {
                        tmp.put(newKey, (tmp.getOrDefault(newKey, 0) + hm.get(key)) % MOD);
                    }
                }
            }

            hm = tmp;
        }

        int result = hm.getOrDefault(H, 0);
        System.out.println(result);
    }
}