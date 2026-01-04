import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int MIN = -100_000_001;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 붙어있는 양수들을 모두 합치기
        int answer = MIN;

        // tmp[0] := 아직 한 번도 제거하지 않은 부분 합 중 최댓값
        // tmp[1] := 한 번 제거한 적 잇는 부분 합 중 최댓값
        int[] tmp = new int[2];
        tmp[0] = tmp[1] = MIN;

        int o, x;
        for (int i = 0; i < n; i++) {
            o = x = MIN;

            // tmp[0]에 대해 현재 값 더하기
            o = Math.max(o, tmp[0] + arr[i]);

            // tmp[0]에 대해 현재 값 빼기
            x = Math.max(x, tmp[0]);

            // 앞 값들을 더하지 않고 현재 값 새로 시작하기
            o = Math.max(o, arr[i]);

            // tmp[1]에 대해 현재 값 더하기
            x = Math.max(x, tmp[1] + arr[i]);

            answer = Math.max(answer, Math.max(o, x));
            tmp[0] = o;
            tmp[1] = x;
        }

        System.out.println(answer);
    }
}
