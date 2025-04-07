class Solution {
    public int solution(int[][] board) {
        
        int answer = (int) Math.pow(board.length, 2);
        
        // 위험 구역
        boolean[][] danger = new boolean[board.length][board.length];
        
        // 현위치 + 8방탐색
        int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        
        int nx, ny;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                if(board[i][j] == 1) { // 지뢰 발견
                    for(int k = 0; k < 9; k++) { // 현위치 + 8방 탐색
                        nx = i + dx[k];
                        ny = j + dy[k];
                        
                        if(nx >= 0 && nx < board.length
                          && ny >= 0 && ny < board.length) { // board 범위를 넘어가지 않고
                            if(!danger[nx][ny]) { // 처음으로 위험 구역으로 선정됐다면
                                danger[nx][ny] = true;
                                answer--;
                            }
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}