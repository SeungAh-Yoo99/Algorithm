import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 도시 개수, M := 여행 일수
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /**
         * 1 -> 4로 여행을 간다고 한다면
         * 1 -> 2 -> 3 -> 4 방향을 가야한다.
         * 따라서 1, 2, 3번 철도를 이용해야 한다.
         *
         * 즉, s -> e (s < e)루트로 여행을 간다면
         * s ~ e - 1까지의 철도를 사용한다.
         *
         * route 배열에 route[s]는 + 1, route[e]에는 -1을 해주고
         * 누적합으로 각 철도별 사용 횟수를 구한다.
         */

        // 여행 루트
        int[] route = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()), e;
        for (int i = 0; i < M - 1; i++) {
            e = Integer.parseInt(st.nextToken());
            if(s < e) {
                route[s]++;
                route[e]--;
            } else {
                route[e]++;
                route[s]--;
            }
            s = e;
        }

        // 라인 정보
        long[][] line = new long[N][3];
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            line[i][0] = Long.parseLong(st.nextToken());
            line[i][1] = Long.parseLong(st.nextToken());
            line[i][2] = Long.parseLong(st.nextToken());
        }

        // 라인별 사용 횟수
        long[] use = new long[N + 1];
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += route[i];
            use[i] = sum;
        }

        // 각 라인별로 티켓을 구입하는게 더 나은지 IC 카드를 구입하는게 더 나은지 계산하여 더해주기
        long answer = 0;
        for (int i = 1; i < N; i++) {
            answer += Math.min(line[i][0] * use[i], line[i][1] * use[i] + line[i][2]);
        }

        // 출력
        System.out.println(answer);
    }
}