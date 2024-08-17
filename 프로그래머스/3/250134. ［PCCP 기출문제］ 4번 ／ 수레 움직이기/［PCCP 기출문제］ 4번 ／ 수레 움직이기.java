class Solution {
    
    static int x, y;
    static int[][] maze;
    static boolean[][] blue;
    static boolean[][] red;
    static int answer;
    
    // 사방탐색
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maze) {
        
        this.x = maze.length; // 세로 길이
        this.y = maze[0].length; // 가로 길이
        this.maze = maze;
        
        blue = new boolean[x][y]; // 파란색 수레의 방문 배열
        red = new boolean[x][y]; // 빨간색 수레의 방문 배열
        
        // 수레 시작 칸 찾기
        int[] b = new int[2]; int[] r = new int[2];
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                if(maze[i][j] == 1) {
                    r = new int[] {i, j};
                    red[i][j] = true;
                }
                else if(maze[i][j] == 2) {
                    b = new int[] {i, j};
                    blue[i][j] = true;
                }
            }
        }
        
        answer = 0;
        backTracking(0, b, r);
        return answer;
    }
    
    private static void backTracking(int n, int[] b, int[] r) {
        
        // 도착한 경우
        if(maze[b[0]][b[1]] == 4 && maze[r[0]][r[1]] == 3) {
            answer = answer == 0 ? n : Math.min(answer, n);
            return;
        }
        
        int bx, by, rx, ry;
        
        // 파란색 수레가 이미 도착했다면
        if(maze[b[0]][b[1]] == 4) {
            for(int i = 0; i < 4; i++) { // 빨간색 수레 이동
                rx = r[0] + dx[i];
                ry = r[1] + dy[i];
                if(rx >= 0 && rx < x && ry >= 0 && ry < y) { // 범위 체크
                    if(!red[rx][ry] && maze[rx][ry] != 5) { // 이동 가능한 곳이라면
                        if(!(b[0] == rx && b[1] == ry)) { // 같은 자리에 오지 않음
                            red[rx][ry] = true;
                            backTracking(n + 1, b, new int[] {rx, ry});
                            red[rx][ry] = false;
                        }
                    }
                }
            }
        }
        // 빨간색 수레가 이미 도착했다면
        else if(maze[r[0]][r[1]] == 3) {
            for(int i = 0; i < 4; i++) { // 파란색 수레 이동
                bx = b[0] + dx[i];
                by = b[1] + dy[i];
                if(bx >= 0 && bx < x && by >= 0 && by < y) { // 범위 체크
                    if(!blue[bx][by] && maze[bx][by] != 5) { // 이동 가능한 곳이라면
                        if(!(r[0] == bx && r[1] == by)) { // 같은 자리에 오지 않음
                            blue[bx][by] = true;
                            backTracking(n + 1, new int[] {bx, by}, r);
                            blue[bx][by] = false;
                        }
                    }
                }
            }
        }
        else {
            for(int i = 0; i < 4; i++) { // 파란색 수레 이동
                bx = b[0] + dx[i];
                by = b[1] + dy[i];
                if(bx >= 0 && bx < x && by >= 0 && by < y) { // 범위 체크
                    if(!blue[bx][by] && maze[bx][by] != 5) { // 이동 가능한 곳이라면
                        for(int j = 0; j < 4; j++) { // 빨간색 수레 이동
                            rx = r[0] + dx[j];
                            ry = r[1] + dy[j];
                            if(rx >= 0 && rx < x && ry >= 0 && ry < y) { // 범위 체크
                                if(!red[rx][ry] && maze[rx][ry] != 5) { // 이동 가능한 곳이라면
                                    if(!(bx == r[0] && by == r[1] && rx == b[0] && ry == b[1])) { // 수레끼리 자리를 바꾸지 않음
                                        if(!(bx == rx && by == ry)) { // 같은 자리에 오지 않음
                                            blue[bx][by] = true;
                                            red[rx][ry] = true;
                                            backTracking(n + 1, new int[] {bx, by}, new int[] {rx, ry});
                                            blue[bx][by] = false;
                                            red[rx][ry] = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}