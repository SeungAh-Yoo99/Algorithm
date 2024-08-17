import java.util.*;

class Solution {
    
    static int x, y;
    static int[][] land;
    static int[] sum;
    static boolean[][] visited;
    
    // 사방탐색
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        
        this.x = land.length;
        this.y = land[0].length;
        this.land = land;
        
        // count[i] := i번 째 열에 시추관을 설치했을 때 얻을 수 있는 석유량
        sum = new int[y];
        
        // bfs를 위한 방문 배열
        visited = new boolean[x][y];
        
        // bfs로 각 열마다 얼만큼의 석유량을 얻을 수 있는지 검사
        bfs();
        
        int answer = 0;
        for(int i = 0; i < y; i++) answer = Math.max(answer, sum[i]);
        
        return answer;
    }
    
    private static void bfs() {
        
        Queue<int[]> q = new LinkedList<>();
        boolean[] in;
        
        int[] now; int count, nx, ny;
        for(int i = 0; i < x; i++) {
            for(int j = 0; j < y; j++) {
                // 처음 발견한 석유 덩어리 발견
                if(land[i][j] == 1 && !visited[i][j]) {
                    in = new boolean[y]; // in[i] := i번째 열에 걸쳐있다고 알려줌
                    
                    q.add(new int[] {i, j});
                    visited[i][j] = true;
                    in[j] = true;
                    count = 1;
                    
                    while(!q.isEmpty()) {
                        now = q.poll();
                        
                        for(int k = 0; k < 4; k++) { // 사방탐색
                            nx = now[0] + dx[k];
                            ny = now[1] + dy[k];
                            if(nx >= 0 && nx < x && ny >= 0 && ny < y) { // 범위 체크
                                if(land[nx][ny] == 1 && !visited[nx][ny]) {
                                    q.add(new int[] {nx, ny});
                                    visited[nx][ny] = true;
                                    in[ny] = true;
                                    count++;
                                }
                            }
                        }
                    }
                    
                    // 해당 덩어리가 지나는 열에 석유량 더해줌
                    for(int k = 0; k < y; k++) {
                        if(in[k]) sum[k] += count;
                    }
                }
            }
        }
    }
}