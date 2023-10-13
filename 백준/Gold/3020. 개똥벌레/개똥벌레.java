import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N := 동굴의 길이, H := 동굴의 높이
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        // down[i] := 높이가 i인 석순의 개수
        int[] down = new int[H];
        // up[i] := 높이가 i인 종유석의 개수
        int[] up = new int[H];

        int tmp;
        for (int i = 0; i < N; i++) {
            tmp = Integer.parseInt(br.readLine());
            if((i & 1) == 1) { // 홀수일 때는 석순
                down[tmp]++;
            } else { // 짝수일 때는 종유석
                up[tmp]++;
            }
        }

        // 누적합으로 해당 위치에 석순과 종유석이 얼마나 있는지 구하기
        // 석순 구하기
        int[] downSum = new int[H + 1];
        for (int i = H - 1; i > 0; i--) {
            downSum[i] = downSum[i + 1] + down[i];
        }
        // 종유석 구하기
        int[] upSum = new int[H + 1];
        for (int i = 2; i <= H; i++) {
            upSum[i] = upSum[i - 1] + up[H - i + 1];
        }

        // 높이별 석순 개수 + 종유석 개수가 가장 적은 값 구하기
        int result = downSum[1] + upSum[1];
        int resultSum = 1;
        for (int i = 2; i <= H; i++) {
            if(result == downSum[i] + upSum[i]) resultSum++;
            else if(result > downSum[i] + upSum[i]) {
                result = downSum[i] + upSum[i];
                resultSum = 1;
            }
        }

        // 출력
        System.out.println(result + " " + resultSum);
    }
}