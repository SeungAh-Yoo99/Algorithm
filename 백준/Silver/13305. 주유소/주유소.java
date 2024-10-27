import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 인접한 두 도시의 도로의 길이
        int[] length = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            length[i] = Integer.parseInt(st.nextToken());
        }

        // 리터당 가격
        int[] price = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        long result = 0;

        // 현재 도시보다 값이 싼 주유소가 있는 도시까지 이동할 수 있는 양만큼 현재 도시에서 주유
        long sum;
        int now = 0, next = 0;
        while(now < N - 1) {
            sum = 0;

            while(next < N - 1 && price[now] <= price[next]) {
                sum += length[next];
                next++;
            }

            result += sum * price[now];
            now = next;
        }

        System.out.println(result);
    }
}