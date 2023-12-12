import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        // N := 파티자으이 크기, M := 서비스를 요청한 손님의 수
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드-워셜로 최단 거리 구하기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    arr[j][k] = arr[j][k] > arr[j][i] + arr[i][k] ? arr[j][i] + arr[i][k] : arr[j][k];
                }
            }
        }

        // M번의 서비스 요청
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            // A -> B까지의 최단 거리
            int min = arr[A][B];

            // C 시간 내에 갈 수 있는지 확인
            if(min <= C) result.append("Enjoy other party\n");
            else result.append("Stay here\n");
        }

        // 답 춝력
        System.out.println(result);
    }
}