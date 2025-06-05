import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] sudoku;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(0, 0);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                result.append(sudoku[i][j]).append(" ");
            }
            result.append("\n");
        }
        System.out.print(result);
    }

    static boolean backTracking(int x, int y) {

        // 현재 위치에서 올 수 있는 숫자들
        boolean[] isPossible = new boolean[10];
        Arrays.fill(isPossible, true);

        for (int i = x; i < 9; i++) {
            for (int j = i == x ? y : 0; j < 9; j++) {
                if(sudoku[i][j] == 0) { // 아직 채우지 않은 수를 발견했다면

                    // 현재 위치에 올 수 있는 숫자들 구하기
                    for (int k = 0; k < 9; k++) {
                        // 가로줄 확인
                        isPossible[sudoku[i][k]] = false;
                        // 세로줄 확인
                        isPossible[sudoku[k][j]] = false;
                        // 3x3 칸 확인
                        isPossible[sudoku[i / 3 * 3 + k / 3][j / 3 * 3 + k % 3]] = false;
                    }

                    for (int k = 1; k <= 9; k++) {
                        if(isPossible[k]) { // 가능한 수를 발견했다면
                            sudoku[i][j] = k;

                            if(backTracking(i, j)) { // 다음 자리까지 모두 완료되면
                                return true;
                            }

                        }
                    }

                    // 채울 수 있는 수를 발견하지 못한 경우, 뒤로 되돌아감
                    sudoku[i][j] = 0;
                    return false;
                }
            }
        }

        return true;
    }
}
