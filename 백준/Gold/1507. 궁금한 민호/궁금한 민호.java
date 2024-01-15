import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 도시의 개수
        int N = Integer.parseInt(br.readLine());

        // 도시 사이에 이동하는데 필요한 시간
        int[][] time = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                time[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 필요없는 도로 표시
        boolean[][] unnecessary = new boolean[N][N];

        // 플로이드-워셜 역으로 이용
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if(j == i || k == i) continue;

                    // 불가능한 경우
                    if(time[j][k] > time[j][i] + time[i][k]) {
                        System.out.println(-1);
                        return;
                    }

                    // 경유해서 간 경우
                    if(time[j][k] == time[j][i] + time[i][k]) unnecessary[j][k] = true;
                }
            }
        }

        // 경유하지 않고 간 도로 개수 세주기
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if(!unnecessary[i][j]) answer += time[i][j];
            }
        }

        // 출력
        System.out.println(answer);
    }
}