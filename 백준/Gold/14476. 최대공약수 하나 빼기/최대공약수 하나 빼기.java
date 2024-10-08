import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 0 ~ i까지의 최대공약수를 담을 배열
        int[] lgcd = new int[N];
        lgcd[0] = arr[0];
        for (int i = 1; i < N; i++) {
            lgcd[i] = gcd(lgcd[i - 1], arr[i]);
        }

        // i ~ N - 1까지의 최대공약수를 담을 배열
        int[] rgcd = new int[N];
        rgcd[N - 1] = arr[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            rgcd[i] = gcd(rgcd[i + 1], arr[i]);
        }

        int result = -1; // K를 뺏을 때의 최대공약수
        int resultArr = 0;

        int temp, tGcd;
        for (int i = 0; i < N; i++) {
            // i를 뺏을 때의 최대공약수
            if(i == 0) temp = rgcd[1];
            else if(i == N - 1) temp = lgcd[N - 2];
            else temp = gcd(lgcd[i - 1], rgcd[i + 1]);

            if(arr[i] % temp != 0 && result < temp) {
                result = temp;
                resultArr = arr[i];
            }
        }

        if(result == -1) System.out.println(-1);
        else System.out.println(result + " " + resultArr);
    }

    private static int gcd(int a, int b) {

        int temp;
        while(a % b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }

        return b;
    }
}