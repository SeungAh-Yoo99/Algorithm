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

        int[][] count = new int[N][4];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                count[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 정렬
        Arrays.sort(count, (o1, o2) ->
                o1[1] == o2[1] // 금메달 수가 같으면
                    ? o1[2] == o2[2] // 은메달 수가 같으면
                        ? o2[3] - o1[3] // 동메달 많은 사람이 우선 순위가 더 높음
                        : o2[2] - o1[2] // 은메달 많은 사람이 우선 순위가 더 높음
                    : o2[1] - o1[1]); // 금메달 많은 사람이 우선 순위가 더 높음

        // 순위 구하기
        int result = 1;
        for (int i = 1; i < N; i++) {
            if(count[i - 1][1] != count[i][1]
                || count[i - 1][2] != count[i][2]
                || count[i - 1][3] != count[i][3]) // 앞 사람과 메달 수가 동일하지 않을 때만
                result = i + 1; // 순위가 올라감

            // K번째 국가를 찾았다면 탈출
            if(count[i][0] == K) break;
        }

        System.out.println(result);
    }
}