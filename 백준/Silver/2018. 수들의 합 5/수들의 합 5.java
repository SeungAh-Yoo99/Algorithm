import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 투포인터
        int s = 1, e = 1;
        int sum = 1;
        int result = 0;
        while(e <= N) {

            if(sum == N) {
                result++;
                sum -= s++;
            }
            else if(sum < N) {
                sum += ++e;
            }
            else {
                sum -= s++;
            }
        }

        System.out.println(result);
    }
}