import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // ice[i][0] := 얼음의 양
        // ice[i][1] := 양동이 좌표
        int[][] ice = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ice[i][0] = Integer.parseInt(st.nextToken());
            ice[i][1] = Integer.parseInt(st.nextToken());
        }

        // 양동이 좌표 기준으로 오름차순 정렬
        Arrays.sort(ice, (o1, o2) -> o1[1] - o2[1]);

        // 투 포인터
        int s = 0, e = 0;
        int sum = ice[0][0];
        int result = 0;
        while(e < N) {
            // s와 e 사이의 양동이가 자리잡을 수 있는 범위 내라면
            if(ice[e][1] - ice[s][1] <= 2 * K) {
                result = Math.max(result, sum);
                if(++e < N) sum += ice[e][0];
            }
            // s와 e 사이의 양동이가 자리잡을 수 있는 범위를 초과했다면
            else {
                sum -= ice[s++][0];
            }
        }

        System.out.println(result);
    }
}