class Solution {
    public int solution(String[] board) {
        int answer = 0;
        
        // board를 char 배열로 변환
        char[][] b = new char[3][3];
        for(int i = 0; i < 3; i++) b[i] = board[i].toCharArray();
        
        // O, X의 개수
        int oNum = 0, xNum = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(b[i][j] == 'O') oNum++;
                else if(b[i][j] == 'X') xNum++;
            }
        }
        
        // O, X의 빙고 개수 세기
        int oBingo = 0, xBingo = 0;
        for(int i = 0; i < 3; i++) {
            // 가로 확인
            if(b[i][0] == 'O' && b[i][1] == 'O' && b[i][2] == 'O') oBingo++;
            if(b[i][0] == 'X' && b[i][1] == 'X' && b[i][2] == 'X') xBingo++;
            // 세로 확인
            if(b[0][i] == 'O' && b[1][i] == 'O' && b[2][i] == 'O') oBingo++;
            if(b[0][i] == 'X' && b[1][i] == 'X' && b[2][i] == 'X') xBingo++;
        }
        // 대각선 확인
        if(b[0][0] == 'O' && b[1][1] == 'O' && b[2][2] == 'O') oBingo++;
        if(b[0][0] == 'X' && b[1][1] == 'X' && b[2][2] == 'X') xBingo++;
        if(b[0][2] == 'O' && b[1][1] == 'O' && b[2][0] == 'O') oBingo++;
        if(b[0][2] == 'X' && b[1][1] == 'X' && b[2][0] == 'X') xBingo++;
        
        
        // 나올 수 있는 게임 상황인 경우 확인
        // O, X 개수가 같거나, O의 개수가 하나 더 많은 상태에서 빙고가 나오지 않음
        if(oBingo == 0 && xBingo == 0 && (oNum == xNum || oNum == xNum + 1)) answer = 1;
        // O 빙고가 나왔다면 X 빙고는 나오지 않고 O를 X를 보다 한 개 더 놓은 상태에서 게임이 끝나야 함
        else if(oBingo == 1 && xBingo == 0 && oNum == xNum + 1) answer = 1;
        // x 빙고가 나왔다면 O 빙고는 나오지 않고 O와 x를 같은 개수로 놓은 상태에서 게임이 끝나야 함
        else if(oBingo == 0 && xBingo == 1 && oNum == xNum) answer = 1;
        // O 빙고가 마지막에 O를 넣으면서 2 빙고를 만들며 끝난 경우
        else if(oBingo == 2 && xBingo == 0 && oNum == 5 && xNum == 4) answer = 1;
        
        return answer;
    }
}