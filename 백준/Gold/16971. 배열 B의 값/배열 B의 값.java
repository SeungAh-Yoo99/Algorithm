import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /**
     * A의 네 모서리(A[0][0], A[0][M - 1], A[N - 1][0], A[N - 1][M - 1])는
     * B를 구하기 위해 1번 씩만 사용된다.
     *
     * A의 0번 행, N - 1번 행, 0번 열, M - 1번 열에 속한 원소들 중
     * 네 모서리가 아닌 원소들은
     * B를 구하기 위해 2번 씩만 사용된다.
     *
     * A의 나머지 원소들은
     * B를 구하기 위해 4번씩 사용된다.
     *
     * 1 2 2 ... 2 2 1
     * 2 4 4 ... 4 4 2
     * 2 4 4 ... 4 4 2
     * ...
     * 2 4 4 ... 4 4 2
     * 2 4 4 ... 4 4 2
     * 1 2 2 ... 2 2 1
     */

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 임의의 두 행 위치를 교환하는 경우
        // 0번째 행과 N - 1번째 행 중 원소의 합이 더 큰 행이
        // 1 ~ N-2번째 행 중 원소의 합이 작은 행보다 합이 더 크다면
        // 두 행의 위치를 교환해줌

        int[] rowB = new int[N];
        for (int i = 0; i < N; i++) {
            rowB[i] = A[i][0]; // 맨 왼쪽은 1번만 사용됨
            for (int j = 1; j < M - 1; j++) {
                rowB[i] += A[i][j] * 2;
            }
            rowB[i] += A[i][M - 1]; // 맨 오른쪽도 1번만 사용됨
        }
        swap(rowB);

        // rowB의 합을 구해줌
        int result = sum(rowB);

        // 행과 마찬가지로 열도 위의 과정을 진행해줌
        int[] colB = new int[M];
        for (int i = 0; i < M; i++) {
            colB[i] = A[0][i];
            for (int j = 1; j < N - 1; j++) {
                colB[i] += A[j][i] * 2;
            }
            colB[i] += A[N - 1][i];
        }
        swap(colB);
        result = Math.max(result, sum(colB));

        System.out.println(result);
    }

    private static void swap(int[] arr) {
        // 1 ~ n-2번째 원소 중 가장 작은 값 구하기
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if(min > arr[i]) {
                min = arr[i];
                index = i;
            }
        }

        // 0번째 원소와 n - 1번째 원소 중 더 큰 값이
        // 위에서 구한 min보다 더 크다면 위치 교환
        if(arr[0] > arr[arr.length - 1]) {
            if(arr[0] > min) {
                arr[index] = arr[0];
                arr[0] = min;
            }
        }
        else {
            if(arr[arr.length - 1] > min) {
                arr[index] = arr[arr.length - 1];
                arr[arr.length - 1] = min;
            }
        }
    }

    private static int sum(int[] arr) {

        // 0번째, n - 1번째 원소는 * 1
        int ret = arr[0] + arr[arr.length - 1];

        // 나머지 원소는 * 2
        for (int i = 1; i < arr.length - 1; i++) {
            ret += arr[i] * 2;
        }

        return ret;
    }
}