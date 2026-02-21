import java.util.*;

class Solution {
    public int solution(String[] maps) {
        
        // 시작 지점, 출구, 레버 위치 찾기
        int[] S = new int[2];
        int[] E = new int[2];
        int[] L = new int[2];
        
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                if(maps[i].charAt(j) == 'S') {
                    S[0] = i;
                    S[1] = j;
                }
                else if(maps[i].charAt(j) == 'E') {
                    E[0] = i;
                    E[1] = j;
                }
                else if(maps[i].charAt(j) == 'L') {
                    L[0] = i;
                    L[1] = j;
                }
            }
        }
        
        // 시작 지점 -> 레버 최단거리 구하기
        int sToL = getMiniDist(maps, S, L);
        if(sToL == -1) return -1;
        
        // 레버 -> 출구 최단거리 구하기
        int lToE = getMiniDist(maps, L, E);
        if(lToE == -1) return -1;

        return sToL + lToE;
    }
    
    // s부터 e까지의 최단 거리
    private int getMiniDist(String[] maps, int[] s, int[] e) {
        
        // 최단거리 저장 배열
        int[][] visited = new int[maps.length][maps[0].length()];
        for(int i = 0; i < visited.length; i++) {
            for(int j = 0; j < visited[0].length; j++) {
                visited[i][j] = visited.length * visited[0].length;
            }
        }
        visited[s[0]][s[1]] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.add(new int[] {s[0], s[1], 0});
        
        int[] now;
        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy= new int[] {0, 0, -1, 1};
        int nx, ny;
        while(!pq.isEmpty()) {
            now = pq.poll();
            
            // 사방탐색
            for(int i = 0; i < 4; i++) {
                nx = now[0] + dx[i];
                ny = now[1] + dy[i];
                
                if(nx < 0 || nx >= maps.length ||ny < 0 || ny >= maps[0].length())
                    continue;
                
                // 도착지점
                if(nx == e[0] && ny == e[1])
                    return now[2] + 1;
                
                // 벽인 경우 이동 불가
                if(maps[nx].charAt(ny) == 'X')
                    continue;
                
                // (nx, ny) 에 대해 최단 거리일 때만 이동
                if(visited[nx][ny] > now[2] + 1) {
                    visited[nx][ny] = now[2] + 1;
                    pq.add(new int[] {nx, ny, now[2] + 1});
                }
            }
        }
        
        // 도착지점까지 이동하지 못한 경우
        return -1;
    }
}