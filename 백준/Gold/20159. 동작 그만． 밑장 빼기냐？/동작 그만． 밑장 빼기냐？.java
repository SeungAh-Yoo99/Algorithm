import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N := 카드의 개수
        int N = Integer.parseInt(br.readLine());

        // 카드 누적합
        long[] card1 = new long[N / 2 + 1];
        long[] card2 = new long[N / 2 + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N / 2; i++) {
            card1[i] = card1[i - 1] + Long.parseLong(st.nextToken());
            card2[i] = card2[i - 1] + Long.parseLong(st.nextToken());
        }


        // 중간에 밑장 빼기 했을 경우, 최대값이라면 밑장 빼기를 해줌
        Long result = card1[N / 2];
        Long tmp;
        for (int i = 0; i < N; i++) {
            // 정훈이의 차례에서 밑장 빼기를 한 경우
            if(i % 2 == 1) {
                tmp = card1[i / 2] + (card2[N / 2] - card2[i / 2]);
            }
            // 상대 차례에서 밑장 빼기를 한 경우
            else {
                tmp = card1[i / 2 + 1] + (card2[N / 2 - 1] - card2[i / 2]);
            }
            result = Math.max(result, tmp);
        }

        // 출력
        System.out.println(result);
    }
}