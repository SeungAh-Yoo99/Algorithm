import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        
        Queue<int[]> q = new LinkedList();
        if(info[0][0] < n) q.add(new int[] {info[0][0], 0});
        if(info[0][1] < m) q.add(new int[] {0, info[0][1]});
        
        Queue<int[]> next;
        boolean[][] visited;
        
        int[] tmp;
        for(int i = 1; i < info.length; i++) {
            next = new LinkedList();
            visited = new boolean[n + 1][m + 1];
            while(!q.isEmpty()) {
                tmp = q.poll();
                
                if(tmp[0] + info[i][0] < n && !visited[tmp[0] + info[i][0]][tmp[1]]) {
                    next.add(new int[] {tmp[0] + info[i][0], tmp[1]});
                    visited[tmp[0] + info[i][0]][tmp[1]] = true;
                }
                if(tmp[1] + info[i][1] < m && !visited[tmp[0]][tmp[1] + info[i][1]]) {
                    next.add(new int[] {tmp[0], tmp[1] + info[i][1]});
                    visited[tmp[0]][tmp[1] + info[i][1]] = true;
                }
            }
            q = next;
        }
        
        int answer = n;
        while(!q.isEmpty()) {
            tmp = q.poll();
            answer = Math.min(answer, tmp[0]);
        }
        
        if(answer == n) return -1;
        else return answer;
    }
}