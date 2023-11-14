import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N := 타일 코드의 개수
        int N = Integer.parseInt(br.readLine());

        // 전체 타일 코드 저장할 배열
        int[] dp1 = new int[31];
        // 좌우 대칭 타일 코드를 저장할 배열
        int[] dp2 = new int[31];

        dp1[1] = 1; dp1[2] = 3; dp1[3] = 5;
        dp2[0] = 1; dp2[1] = 1; dp2[2] = 3; dp2[3] = 1;

        for (int i = 4; i <= N; i++) {
            dp1[i] = dp1[i - 1] + (dp1[i - 2] * 2);
            dp2[i] = dp2[i - 2] + (dp2[i - 4] * 2);
        }

        int result = (dp1[N] - dp2[N]) / 2 + dp2[N];
        System.out.println(result);
    }
}