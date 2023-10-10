import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N := 입국심사대 개수, M := 상근이와 친구들 명수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        // arr[i] := T_i, i번째 심사대가 심사하는데 걸리는 시간
        long[] arr = new long[N];
        long min = 1_000_000_000, max = 0; // min := 가장 빠른 심사 시간, max := 가장 느린 심사 시간
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            min = min > arr[i] ? arr[i] : min;
            max = max < arr[i] ? arr[i] : max;
        }

        // 이분탐색
        long s = min, e = max * M;
        long result = 0;

        while(s <= e) {
            long m = (s + e) / 2;

            // m 시간 안에 가능한지 확인
            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += m / arr[i];
                if(sum >= M) break;
            }

            if(sum >= M) { // m 시간 안에 가능할 경우
                result = m;
                e = m - 1;
            } else { // 불가능할 경우
                s = m + 1;
            }
        }

        // 출력
        System.out.println(result);
    }
}