import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // 자를 수 있는 지점
        int[] S = new int[M + 2];

        for (int i = 1; i <= M; i++) {
            S[i] = Integer.parseInt(br.readLine());
        }
        S[M + 1] = L;

        StringBuilder answer = new StringBuilder();
        int s, e, m, count, last, w, Q, result;
        for (int i = 0; i < N; i++) {
            Q = Integer.parseInt(br.readLine());

            // 떨어져 있는 길이로 이분 탐색
            s = 0; e = L;
            result = 0;
            while(s <= e) {
                m = (s + e) / 2;

                // m 길이 이상으로 Q번 자르면 Q  + 1조각을 만들 수 있어야 한다.
                count = 0;
                last = 0; // 마지막으로 자른 곳
                for (int j = 1; j <= M + 1; j++) {
                    if(S[j] - last >= m) {
                        count++;
                        last = S[j];
                    }
                    if(count == Q + 1) break;
                }

                if(count == Q + 1) {
                    result = m;
                    s = m + 1;
                } else e = m - 1;
            }

            answer.append(result + "\n");
        }

        System.out.println(answer);
    }
}
