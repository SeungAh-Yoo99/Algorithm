import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, K;
    static int[] arr;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 정렬
            Arrays.sort(arr);

            int min = Integer.MAX_VALUE;
            int result =0;

            int[] ret;
            for (int i = 0; i < n - 1; i++) {
                // 이분탐색으로
                ret = getMinSub(i, i + 1, n - 1);

                if(min > ret[0]) {
                    min = ret[0];
                    result = ret[1];
                }
                else if(min == ret[0]) {
                    result += ret[1];
                }
            }

            answer.append(result + "\n");
        }

        System.out.print(answer);
    }

    // start부터 end까지 index와의 합이 K와 가장 가까운 수의 차 구하기
    private static int[] getMinSub(int index, int start, int end) {

        int[] ret = new int[2];
        ret[0] = Integer.MAX_VALUE;

        // 찾고자 하는 수
        int find = K - arr[index];

        int mid, get = start;
        while(start <= end) {
            mid = (start + end) / 2;

            if(arr[mid] > find) end = mid - 1;
            else {
                get = mid;
                start = mid + 1;
            }
        }

        // 찾은 수
        int sub = Math.abs(K - (arr[index] + arr[get]));
        if(ret[0] > sub) {
            ret[0] = sub;
            ret[1] = 1;
        }
        else if(ret[0] == sub) {
            ret[1]++;
        }

        // 찾은 수보다 더 큰 수 중 가장 작은 수도 검사
        if(get != n - 1) {
            sub = Math.abs(K - (arr[index] + arr[get + 1]));
            if(ret[0] > sub) {
                ret[0] = sub;
                ret[1] = 1;
            }
            else if(ret[0] == sub) {
                ret[1]++;
            }
        }

        return ret;
    }
}