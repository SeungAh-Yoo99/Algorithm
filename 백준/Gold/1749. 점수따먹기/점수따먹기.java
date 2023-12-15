import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        final int MIN = -400_000_000;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][M + 1];
        int[][] sum = new int[N + 1][M + 1]; // 각 행에 대한 누적합만 저장
        int maxNum = MIN;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = sum[i][j - 1] + arr[i][j];
                maxNum = Math.max(maxNum, arr[i][j]);
            }
        }

        int result = MIN;
        if(maxNum <= 0) { // 양수가 하나도 없다면
            result = maxNum; // 가장 큰 칸만 포함
        }
        else {
            int max, tmp;
            for (int i = 1; i <= M; i++) { // i + 1열부터
                for (int j = i; j <= M; j++) { // j열까지 포함
                    max = MIN;
                    for (int k = 1; k <= N; k++) { // 1~N까지 검사
                        // 위의 행을 합치는게 좋을지, 현재 행만 두는게 좋을지 검사
                        tmp = sum[k][j] - sum[k][i]; // 현재 행
                        max = Math.max(max + tmp, tmp);
                        result = Math.max(result, max);
                    }
                }
            }
        }

        System.out.println(result);
    }
}