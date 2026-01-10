import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        
        // 각 수마다 만들 수 있는 최소 연산 횟수 저장
        int[] cost = new int[y + 1];
        Arrays.fill(cost, y + 1);
        cost[x] = 0;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, 0});
        
        int[] now;
        while(!q.isEmpty()) {
            now = q.poll();
            
            // n 더하기
            if(now[0] + n <= y && cost[now[0] + n] > now[1] + 1) {
                cost[now[0] + n] = now[1] + 1;
                q.add(new int[] {now[0] + n, now[1] + 1});
            }
            
            // 2 곱하기
            if(now[0] * 2 <= y && cost[now[0] * 2] > now[1] + 1) {
                cost[now[0] * 2] = now[1] + 1;
                q.add(new int[] {now[0] * 2, now[1] + 1});
            }
            
            // 3 곱하기
            if(now[0] * 3 <= y && cost[now[0] * 3] > now[1] + 1) {
                cost[now[0] * 3] = now[1] + 1;
                q.add(new int[] {now[0] * 3, now[1] + 1});
            }
        }
        
        return cost[y] == y + 1 ? -1 : cost[y];
    }
}