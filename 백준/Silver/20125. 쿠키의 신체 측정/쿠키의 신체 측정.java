import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        // 머리, 심장 위치
        int[] head = new int[2];
        int[] heart = new int[2];
        for1: for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] == '*') {
                    head[0] = i;
                    head[1] = j;
                    heart[0] = i + 1;
                    heart[1] = j;
                    break for1;
                }
            }
        }

        // 팔 길이 구하기
        int leftArm = 0, rightArm = 0;
        for (int i = 0; i < N; i++) {
            if(board[heart[0]][i] == '*') {
                leftArm = heart[1] - i;
                break;
            }
        }
        if(leftArm == 0) leftArm = heart[1];
        for (int i = N - 1; i >= 0; i--) {
            if(board[heart[0]][i] == '*') {
                rightArm = i - heart[1];
                break;
            }
        }
        if(rightArm == 0) rightArm = N - 1 - heart[1];

        // 허리 길이 구하기
        int waist = 0;
        for (int i = heart[0] + 1; i < N; i++) {
            if(board[i][heart[1]] == '_') {
                waist = i - heart[0] - 1;
                break;
            }
        }

        // 다리 길이 구하기
        int leftLeg = 0, rightLeg = 0;
        int legStart = heart[0] + waist + 1;
        for (int i = legStart; i < N; i++) {
            if(board[i][heart[1] - 1] == '_') {
                leftLeg = i - legStart;
                break;
            }
        }
        if(leftLeg == 0) leftLeg = N - legStart;
        for(int i = legStart; i < N; i++) {
            if(board[i][heart[1] + 1] == '_') {
                rightLeg = i - legStart;
                break;
            }
        }
        if(rightLeg == 0) rightLeg = N - legStart;

        // 출력
        StringBuilder result = new StringBuilder();
        result.append(heart[0] + 1).append(" ").append(heart[1] + 1).append("\n");
        result.append(leftArm).append(" ").append(rightArm).append(" ");
        result.append(waist).append(" ");
        result.append(leftLeg).append(" ").append(rightLeg);
        System.out.println(result);
    }
}