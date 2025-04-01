import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 방문 가능한지 체크하는 배열
        // flag[i][j] == 1 := i에서 j로 이동 가능
        // flag[i][j] == 0 := i에서 j로 이동 불가능
        int[][] flag = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                flag[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // N이 500 이하이므로 플로이드-워셜로 이동 가능 도시 구하기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= N; k++) {
                    if((flag[j][i] == 1 && flag[i][k] == 1) || j == k)
                        flag[j][k] = 1;
                }
            }
        }

        // 여행 계획이 가능한지 검사
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()), b;
        for (int i = 1; i < M; i++) {
            b = Integer.parseInt(st.nextToken());

            if(flag[a][b] == 0) {
                System.out.println("NO");
                return;
            }

            a = b;
        }

        System.out.println("YES");
    }
}
