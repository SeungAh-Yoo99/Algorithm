import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        // maps 크기
        int n = maps.length;
        int m = maps[0].length;
        
        // 사방탐색
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // (1, 1)에서 출발하여 각 위치의 최단거리를 저장하고 있는 배열
        int[][] minLength = new int[n][m];
        for(int i = 0; i < n; i++) { // 최대값으로 초기화
            Arrays.fill(minLength[i], Integer.MAX_VALUE);
        }
        minLength[0][0] = 1;
        
        // bfs
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0, 1});
        
        int[] now; int nx, ny;
        int answer = -1;
        while(!q.isEmpty()) {
            now = q.poll();
            
            if(now[0] == n - 1 && now[1] == m - 1) {
                answer = now[2];
                break;
            }
            
            for(int i = 0; i < 4; i++) { // 사방탐색
                nx = now[0] + dx[i];
                ny = now[1] + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) { // 범위 탐색
                    if(maps[nx][ny] == 1 && minLength[nx][ny] > now[2] + 1) { // 벽이 아니고, 최단 거리일 때만 이동
                        minLength[nx][ny] = now[2] + 1;
                        q.add(new int[] {nx, ny, minLength[nx][ny]});
                    }
                }
            }
        }
    
        return answer;
    }
}