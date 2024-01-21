import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // n := 직원 수, m := 칭찬의 횟수
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 관계
        int[] relationship = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        int boss;
        for (int i = 1; i <= n; i++) {
            boss = Integer.parseInt(st.nextToken());
            relationship[i] = boss;
        }

        // 칭찬
        int[] commend = new int[n + 1];

        int i, w;
        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            commend[i] += w;
        }

        // 상사의 칭찬을 전달 받음
        for (int j = 2; j <= n; j++) {
            commend[j] += commend[relationship[j]];
        }

        // 출력
        StringBuilder answer = new StringBuilder();
        for (int j = 1; j <= n; j++) {
            answer.append(commend[j] + " ");
        }
        System.out.println(answer);
    }
}