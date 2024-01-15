import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n := 사건의 개수, k := 사건의 전후 관계의 개수
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 자신보다 후에 일어난 사건일 경우 true
        boolean[][] after = new boolean[n + 1][n + 1];

        // 사건 입력
        int b, a;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            after[a][b] = true;
        }

        // 플로이드-워셜로 연결 확인
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int l = 1; l <= n; l++) {
                    if(after[j][i] && after[i][l]) after[j][l] = true;
                }
            }
        }

        // s := 관계를 알고 싶은 사건 쌍의 수
        int s = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(after[a][b]) answer.append("-1\n");
            else if(after[b][a]) answer.append("1\n");
            else answer.append("0\n");
        }

        // 출력
        System.out.println(answer);
    }
}