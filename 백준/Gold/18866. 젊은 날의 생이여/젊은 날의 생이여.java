import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        final int MAX = 1_000_000_001;
        final int MIN = -1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][2];

        int[] minHappyLeft = new int[N + 2]; // 구간 1 ~ index의 최소 행복도
        int[] maxHappyRight = new int[N + 2]; // 구간 index ~ N의 최대 행복도

        int[] maxFatigueLeft = new int[N + 2]; // 구간 1 ~ index의 최대 피로도
        int[] minFatigueRight = new int[N + 2]; // 구간 index ~ N의 최소 피로도


        minHappyLeft[0] = MAX;
        maxHappyRight[N + 1] = MIN;
        maxFatigueLeft[0] = MIN;
        minFatigueRight[N + 1] = MAX;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            // 구간 1 ~ i까지의 최소 행복도 구하기
            if(arr[i][0] != 0) minHappyLeft[i] = Math.min(minHappyLeft[i - 1], arr[i][0]);
            else minHappyLeft[i] = minHappyLeft[i - 1];
            // 구간 1 ~ i까지의 최대 피로도 구하기
            if(arr[i][1] != 0) maxFatigueLeft[i] = Math.max(maxFatigueLeft[i - 1], arr[i][1]);
            else maxFatigueLeft[i] = maxFatigueLeft[i - 1];
        }

        // 구간 i ~ N까지의 행복도, 피로도 최소 최대 구하기
        for (int i = N; i >= 1; i--) {
            // 구간 i ~ N까지의 최대 행복도 구하기
            if(arr[i][0] != 0)  maxHappyRight[i] = Math.max(maxHappyRight[i + 1], arr[i][0]);
            else maxHappyRight[i] = maxHappyRight[i + 1];
            // 구간 i ~ N까지의 최소 피로도 구하기
            if(arr[i][1] != 0) minFatigueRight[i] = Math.min(minFatigueRight[i + 1], arr[i][1]);
            else minFatigueRight[i] = minFatigueRight[i + 1];
        }

        // 뒤에서부터 만족하는 K 찾기
        for (int i = N - 1; i >= 1; i--) {
            // 1 ~ i년까지의 최소 행복도가 i+1 ~ N년의 최대 행복도보다 커야하며,
            // 1 ~ i년까지의 최대 피로도가 i+1 ~ n년의 최소 피로도보다 작아야 한다.
            if(minHappyLeft[i] >= maxHappyRight[i + 1] && maxFatigueLeft[i] <= minFatigueRight[i + 1]) {
                System.out.println(i);
                return;
            }
        }

        // 찾지 못한 경우
        System.out.println(-1);
    }
}