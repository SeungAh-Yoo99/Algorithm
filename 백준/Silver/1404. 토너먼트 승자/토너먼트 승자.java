import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 각 선수들이 이길 확율
        int[][] win = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 8; j++) {
                win[i][j] = Integer.parseInt(st.nextToken());
                win[j][i] = 100 - win[i][j];
            }
        }

        // 라운드 1에서 이길 확율
        int[] round1 = new int[8];
        for (int i = 0; i < 4; i++) {
            round1[2 * i] = win[2 * i][2 * i + 1];
            round1[2 * i + 1] = win[2 * i + 1][2 * i];
        }

        // 라운드 2에서 이길 확율
        int[] round2 = new int[8];
        for (int i = 0; i < 2; i++) {
            round2[4 * i] = round1[4 * i] *
                    (round1[4 * i + 2] * win[4 * i][4 * i + 2] + round1[4 * i + 3] * win[4 * i][4 * i + 3]);
            round2[4 * i + 1] = round1[4 * i + 1] *
                    (round1[4 * i + 2] * win[4 * i + 1][4 * i + 2] + round1[4 * i + 3] * win[4 * i + 1][4 * i + 3]);
            round2[4 * i + 2] = round1[4 * i + 2] *
                    (round1[4 * i] * win[4 * i + 2][4 * i] + round1[4 * i + 1] * win[4 * i + 2][4 * i + 1]);
            round2[4 * i + 3] = round1[4 * i + 3] *
                    (round1[4 * i] * win[4 * i + 3][4 * i] + round1[4 * i + 1] * win[4 * i + 3][4 * i + 1]);
        }


        // 라운드 3에서 이길 확율
        long[] round3 = new long[8];
        for (int i = 0; i < 4; i++) {
            for (int j = 4; j < 8; j++) {
                round3[i] += round2[j] * win[i][j];
            }
            round3[i] *= round2[i];

        }
        for (int i = 4; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                round3[i] += round2[j] * win[i][j];
            }
            round3[i] *= round2[i];
        }

        for (int i = 0; i < 8; i++) {
            System.out.printf("%.10f ", (double) round3[i] * 0.00000000000001);
        }
    }
}
