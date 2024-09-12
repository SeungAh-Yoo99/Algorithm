import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int yPrice = 0, mPrice = 0, price;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price = Integer.parseInt(st.nextToken());
            yPrice += 10 * (price / 30 + 1);
            mPrice += 15 * (price / 60 + 1);
        }

        if(yPrice < mPrice) { // 영식 요금제가 더 싼 경우
            System.out.println("Y " + yPrice);
        } else if(yPrice > mPrice) { // 민식 요금제가 더 싼 경우
            System.out.println("M " + mPrice);
        } else { // 두 요금제의 요금이 같은 경우
            System.out.println("Y M " + yPrice);
        }
    }
}