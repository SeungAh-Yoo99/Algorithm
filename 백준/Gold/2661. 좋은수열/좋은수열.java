import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        combi(0);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            result.append(arr[i]);
        }
        System.out.println(result);
    }

    private static boolean combi(int n) {

        if(n == N)
            return true;

        for(int i = 1; i <= 3; i++) {
            arr[n] = i;

            // 좋은 수열인지 확인
            if(isGood(n)) {
                if(combi(n + 1)) return true;
            }
        }

        return false;
    }

    private static boolean isGood(int n) {

        boolean flag;
        for (int i = 1; i <= (n + 1) / 2; i++) {

            flag = false;

            for (int j = 0; j < i; j++) {
                if(arr[n - i - j] != arr[n - j]) {
                    flag = true;
                    break;
                }
            }

            if(!flag) return false;
        }

        return true;
    }
}
