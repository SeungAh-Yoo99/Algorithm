import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int k, n;
    static long[] arr34;
    static long abs, result;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        long[] arr;
        long[] arr12;
        long tmp;
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            // 1반 힉생들의 몸무게 입력
            arr = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            // 2반 학생들의 몸무게 입력
            arr12 = new long[n * n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                tmp = Long.parseLong(st.nextToken());
                for (int j = 0; j < n; j++) {
                    arr12[n * i + j] = tmp + arr[j];
                }
            }

            // 3반 학생들의 몸무게 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }
            // 4반 학생들의 몸무게 입력
            arr34 = new long[n * n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                tmp = Long.parseLong(st.nextToken());
                for (int j = 0; j < n; j++) {
                    arr34[n * i + j] = tmp + arr[j];
                }
            }

            // 3, 4반 조합 정렬
            Arrays.sort(arr34);

            abs = k - 3 > 40_000_001 - k ? k - 3 : 40_000_0001 - k;
            for (int i = 0; i < n * n; i++) {
                binarySearch(arr12[i]);
                if(result == k) break;
            }

            answer.append(result + "\n");
        }

        System.out.print(answer);
    }

    private static void binarySearch(long num) {

        int s = 0, e = n * n - 1, m;
        long tmp;
        while(s <= e) {
            m = (s + e) / 2;
            tmp = arr34[m] + num - k;

            if(abs > Math.abs(tmp)) {
                abs = Math.abs(tmp);
                result = arr34[m] + num;
            }else if(abs == Math.abs(tmp) && tmp < 0) {
                result = arr34[m] + num;
            }

            if(arr34[m] + num < k) s = m + 1;
            else if(arr34[m] + num == k) return;
            else e = m - 1;
        }
    }
}