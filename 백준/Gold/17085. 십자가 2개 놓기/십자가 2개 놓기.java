import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static char[][] board;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N := 격자판의 세로 크기, M := 격자판의 가로 크기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 격자판
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        // 십자가 놓을 수 있는 모든 경우를 확인한 후 답 구하기
        int result = firstCross();
        System.out.println(result);
    }

    private static int firstCross() { // 첫 번째 십자가 놓기

        int ret = 0;

        int size, tmp = 0;
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                size = 0;
                while(putCross(j, k, size)) { // (j, k)를 가운데로 하는 size 크기의 십자가를 놓을 수 있다면
                    tmp = secondCross(j, k); // 다음 십자가를 놓는 경우 중에 가장 큰 경우 구하기
                    ret = Math.max(ret, tmp * (1 + size * 4));
                    size++;
                }
                // 원래대로 되돌리기
                backCross(j, k, size - 1);
            }
        }

        return ret;
    }

    private static int secondCross(int x, int y) { // 두번째 십자가 놓기

        int ret = 0;

        int size;
        for (int i = x; i < N; i++) {
            for (int j = 0; j < M; j++) {
                size = 0;
                // 놓을 수 있을 만큼 십자가 놓기
                while(putCross(i, j, size)) size++;
                size--;
                ret = Math.max(ret, 1 + size * 4); // 가장 큰 값으로 리턴
                // 십자가 놓기 전으로 되돌리기
                backCross(i, j, size);
            }
        }

        return ret;
    }

    private static boolean putCross(int x, int y, int size) {

        /**
         * 가운데 좌표가 (x, y)인 십자가를 놓을 수 있는지 확인
         *
         * size - 1 크기의 십자가는 놓을 수 있다는 것을 확인하고 size 크기를 확인할 것이기 때문에
         *
         * 가운데 좌표로부터 size 크기만큼 떨어져 있는 상하좌우에 있는 4개의 좌표만 확인해주면 됨
         */

        // 상에 놓을 수 없는 경우
        if(x - size < 0 || board[x - size][y] == '.') return false;
        // 하
        if(x + size >= N || board[x + size][y] == '.') return false;
        // 좌
        if(y - size < 0 || board[x][y - size] == '.') return false;
        // 우
        if(y + size >= M || board[x][y + size] == '.') return false;

        // 놓을 수 있다면 놓아주기
        board[x - size][y] = '.';
        board[x + size][y] = '.';
        board[x][y - size] = '.';
        board[x][y + size] = '.';
        return true;
    }

    private static void backCross(int x, int y, int size) { // 십자가 놓아주었던 곳을 원래대로 되돌리기

        for (int i = 0; i <= size; i++) {
            if(i == 0) board[x][y] = '#';
            else {
                board[x - i][y] = '#'; // 상
                board[x + i][y] = '#'; // 하
                board[x][y - i] = '#'; // 좌
                board[x][y + i] = '#'; // 우
            }
        }
    }
}