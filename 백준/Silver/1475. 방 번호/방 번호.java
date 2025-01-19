import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 필요한 숫자 개수
        int[] counts = new int[9];

        int n;
        while(N > 0) {
            n = N % 10;

            // 9일 때만 6에 같이 카운트
            if(n == 9) counts[6]++;
            else counts[n]++;

            N /= 10;
        }

        // 제일 많이 필요한 숫자 개수만큼 세트 구매
        int answer = 0;
        for(int i = 0; i < 9; i++) {
            if(i == 6) answer = Math.max(answer, counts[6] / 2 + counts[6] % 2);
            else answer = Math.max(answer, counts[i]);
        }

        System.out.println(answer);
    }
}