import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        int n, K;
        int[] arr;
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
            int result = 0;

            int start = 0, end = n - 1;
            int sub;
            while(start < end) {

                sub = Math.abs(K - (arr[start] + arr[end]));
                if(min > sub) {
                    min = sub;
                    result = 1;
                }
                else if (min == sub) {
                    result++;
                }

                if(arr[start] + arr[end] < K) {
                    start++;
                }
                else end--;
            }

            answer.append(result + "\n");
        }

        System.out.print(answer);
    }
}