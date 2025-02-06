class Solution {
    public int[][] solution(int n) {
        
        int[][] answer = new int[n][n];
        
        // 우하좌상
        int[] dx = new int[] {0, 1, 0, -1};
        int[] dy = new int[] {1, 0, -1, 0};
        
        // 현재 위치와 방향
        int x = 0, y = -1, d = 0;
        
        int nx, ny;
        for(int i = 1; i <= n * n; i++) {
            nx = x + dx[d];
            ny = y + dy[d];
            
            // 범위를 넘어가거나 이미 방문한 곳이라면 위치 조정
            if(nx < 0 || nx >= n || ny < 0 || ny >= n || answer[nx][ny] != 0) {
                d = d == 3 ? 0 : d + 1;
                nx = x + dx[d];
                ny = y + dy[d];
            }
            
            // 이동
            x = nx;
            y = ny;
            answer[x][y] = i;
        }
        
        return answer;
    }
}