class Solution {
    public int solution(String dirs) {
        
        // (-5, 5) 지점을 (0, 0)으로
        // (0, 0) 지점을 (5, 5)로 변경
        // (i, j, 0)가 true라면 (i, j)의 윗 길이 이미 걸어본 길을 뜻함 (상하우좌)
        boolean[][][] map = new boolean[11][11][4];
        
        int x = 5, y = 5;
        
        int answer = 0;
        
        char c;
        for(int i = 0; i < dirs.length(); i++) {
            c = dirs.charAt(i);
            
            if(c == 'U') { // 위쪽으로 한 칸 가기
                if(x - 1 >= 0) { // 범위를 벗어나지 않았다면
                    if(!map[x][y][0]) { // 아직 걸어본 길이 아니라면
                        answer++;
                        map[x][y][0] = true;
                        // 현재 좌표의 윗 길과 이동한 좌표의 아랫길은 동일한 길이므로 방문 처리
                        map[x - 1][y][1] = true;
                    }
                    x--;
                }
            }
            else if(c == 'D') {
                if(x + 1 <= 10) {
                    if(!map[x][y][1]) {
                        answer++;
                        map[x][y][1] = map[x + 1][y][0] = true;
                    }
                    x++;
                }
            }
            else if(c == 'R') {
                if(y + 1 <= 10) {
                    if(!map[x][y][2]) {
                        answer++;
                        map[x][y][2] = map[x][y + 1][3] = true;
                    }
                    y++;
                }
            }
            else {
                if(y - 1 >= 0) {
                    if(!map[x][y][3]) {
                        answer++;
                        map[x][y][3] = map[x][y - 1][2] = true;
                    }
                    y--;
                }
            }
        }
        
        return answer;
    }
}