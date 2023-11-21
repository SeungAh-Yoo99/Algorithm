import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n; // 이름 수
    static int m; // 노트의 가로 칸의 개수
    static int[] names; // names[i] := i번째 적어야할 이름의 길이

    static int[][] dp;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n := 적어야 하는 이름 수, m := 노트의 가로 칸의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // names[i] := i번째 적어야할 이름의 길이
        names = new int[n];
        for (int i = 0; i < n; i++) {
            names[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[n][m + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int result = check(1, names[0] + 1);
        System.out.println(result);
    }

    static int check(int index, int cnt) { // index := 이름 순서, cnt := 현재 줄에 채워진 칸 + 1

        // 마지막은 항상 0
        if(index == n) return 0;

        // 이미 확인한 경우라면 넘어감
        if(dp[index][cnt] != -1) return dp[index][cnt];

        int ret;

        // 1. 새로운 줄에 쓰는 경우
        ret = check(index + 1, names[index] + 1) + (int)Math.pow(m - cnt + 1, 2);

        // 2. 현재 줄에 쓰는 경우
        if(m >= cnt + names[index]) {
            ret = Math.min(ret, check(index + 1, cnt + names[index] + 1));
        }

        dp[index][cnt] = ret;
        return ret;
    }
}