import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] W = new int[N];
        boolean[] exist = new boolean[100_000_001]; // 인덱스에 해당하는 무게의 물건이 있으면 true

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            W[i] = Integer.parseInt(st.nextToken());
            exist[W[i]] = true;
        }

        int idx;
        for (int i = 0; i < N; i++) {

            // W[i] 하나만으로 C를 만들 수 있는 경우
            if(W[i] == C) {
                System.out.println(1);
                return;
            }

            for (int j = i + 1; j < N; j++) {

                // W[i]와 W[j]만으로 C를 만들 수 있는 경우
                if(W[i] + W[j] == C) {
                    System.out.println(1);
                    return;
                }

                // C - W[i] - W[j]인 수가 존재하며, 이 수가 W[i]나 W[j]가 아닌 경우
                // 이 세 수로 C를 만들 수 있음
                idx = C - (W[i] + W[j]);
                if(idx < 1) continue;

                // 조합을 찾은 경우
                if(idx != W[i] && idx != W[j] && exist[idx]) {
                    System.out.println(1);
                    return;
                }
            }
        }

        // 조합을 찾지 못한 경우
        System.out.println(0);
    }
}