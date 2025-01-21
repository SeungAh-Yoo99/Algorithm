import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // 0부터 L개의 수를 합친 값
        int sum = 0;
        for (int i = 0; i < L; i++) {
           sum += i;
        }

        // N을 나타낼 수 있는 연속된 수의 개수 구하기
        while(sum < N && L <= 100 && (N - sum) % L != 0) sum += L++;

        // 수열을 구할 수 없는 경우
        if(sum > N || L > 100) {
            System.out.println(-1);
            return;
        }

        StringBuilder answer = new StringBuilder();
        int start = (N - sum) / L;
        for (int i = 0; i < L; i++) {
            answer.append(start + i).append(" ");
        }
        System.out.println(answer);
    }
}