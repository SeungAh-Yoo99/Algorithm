import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visiter = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visiter[i] = Integer.parseInt(st.nextToken());
        }

        // 0 ~ X - 1까지의 합 구하기
        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += visiter[i];
        }
        int maxSum = sum;
        int count = 1;

        // 슬라이딩 윈도우
        for (int i = X; i < N; i++) {
            sum += visiter[i];
            sum -= visiter[i - X];

            if(maxSum < sum) {
                maxSum = sum;
                count = 1;
            }
            else if(maxSum == sum) {
                count++;
            }
        }

        // 최대 방문자 수가 0명인 경우
        if(maxSum == 0) {
            System.out.println("SAD");
        }
        else {
            System.out.println(maxSum + "\n" + count);
        }
    }
}