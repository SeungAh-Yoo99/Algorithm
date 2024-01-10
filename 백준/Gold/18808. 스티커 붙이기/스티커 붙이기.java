import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static ArrayList<int[][]> stickers;
    static int[][] laptop;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 노트북의 세로 길이, M := 노드북의 가로 길이, K := 스티커의 개수
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        stickers = new ArrayList<>(); // 스티커
        int[] numOfSticker = new int[K]; // 스티커의 1 개수
        int[][] sticker; int R, C, num;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            sticker = new int[R][C];
            num = 0;
            for (int j = 0; j < R; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < C; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                    if(sticker[j][k] == 1) num ++;
                }
            }
            stickers.add(sticker);
            numOfSticker[i] = num;
        }

        // 노트북
        laptop = new int[N][M];

        // 스티커 붙이기
        int result = 0;
        for (int i = 0; i < K; i++) {
            // 스티커 붙이는데에 성공했다면, i번째 스티커의 칸 수 더해줌
            if(putSticker(i)) result += numOfSticker[i];
        }

        // 답 출력
        System.out.println(result);
    }

    private static boolean putSticker(int k) {
        /**
         * k번째 스티커 붙이는 메소드
         *
         * 스티커를 붙이는데 성공했다면 true,
         * 실패했다면 false 리턴
         */

        int turn = 0;


        int r, c;
        while(true) { // 스티커를 0도, 90도, 180도, 270도 돌린 후 붙일 수 있는지 확인

            r = stickers.get(k).length; // 스티커 세로 길이
            c = stickers.get(k)[0].length; // 스티커 가로 길이

            for (int i = 0; i <= N - r; i++) {
                for (int j = 0; j <= M - c; j++) {
                    // 스티커를 성공적으로 붙인 경우
                    if(canPut(k, i, j)) return true;
                }
            }

            // 스티커를 붙이지 못한 경우 90도 회전
            if(turn == 3) return false; // 이미 270도 회전까지 확인한 경우, 스티커를 붙일 수 없음
            turn++;
            stickers.set(k, turn90(k));
        }
    }

    private static boolean canPut(int k, int x, int y) { // k번째 스티커를 (x, y)에 붙일 수 있는지 확인 후 붙일 수 있다면 붙임

        int[][] sticker = stickers.get(k);
        int r = sticker.length; // 스티커 가로 길이
        int c = sticker[0].length; // 스티커 세로 길이

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 이미 스티커가 붙어 있다면 붙일 수 없음
                if(sticker[i][j] == 1 && laptop[i + x][j + y] == 1) return false;
            }
        }

        // 자리가 있다면
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 스티커를 붙여줌
                if(sticker[i][j] == 1) laptop[i + x][j + y] = 1;
            }
        }

        return true;
    }

    private static int[][] turn90(int k) { // 스티커를 시계방향으로 90도 회전시켜 리턴

        int[][] sticker = stickers.get(k);
        int r = sticker.length;
        int c = sticker[0].length;

        int[][] ret = new int[c][r]; // 90도 뒤집은 스티커 저장

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                ret[j][r - 1 - i] = sticker[i][j];
            }
        }

        return ret;
    }
}