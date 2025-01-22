import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        
        // 로봇들이 지나야 하는 경로를 담은 큐 리스트
        List<ArrayDeque<int[]>> ql = new ArrayList<>();
        
        ArrayDeque q; int[] now;
        for(int i = 0; i < routes.length; i++) {
            
            // i번째 로봇의 경로를 담을 큐
            q = new ArrayDeque<>();
            
            // i번째 로봇의 현재 위치
            now = new int[2];
            now[0] = points[routes[i][0] - 1][0];
            now[1] = points[routes[i][0] - 1][1];
            
            q.add(new int[] {now[0], now[1]});
            
            // routes[i][j - 1]에서 routes[i][j]로 이동하는 경로를 큐에 담기
            for(int j = 1; j < routes[i].length; j++) {
                while(now[0] != points[routes[i][j] - 1][0] ||
                        now[1] != points[routes[i][j] - 1][1]) {
                    // 한 칸 이동
                    if(now[0] < points[routes[i][j] - 1][0]) now[0]++;
                    else if(now[0] > points[routes[i][j] - 1][0]) now[0]--;
                    else if(now[1] < points[routes[i][j] - 1][1]) now[1]++;
                    else if(now[1] > points[routes[i][j] - 1][1]) now[1]--;
                    
                    // 큐에 담기
                    q.add(new int[] {now[0], now[1]});
                }
            }
            
            // 큐 리스트에 담기
            ql.add(q);
        }
        
        // 충돌 위험 횟수 구하기
        int answer = 0;
        String tmp; int[] p;
        Map<String, Boolean> map = new HashMap<>();
        while(!ql.isEmpty()) {
            
            map.clear();
            
            for(int i = ql.size() - 1; i >= 0; i--) {
                // i번째 로봇의 현재 위치 가져오기
                p = ql.get(i).poll();
                
                // 충돌 체크
                tmp = p[0] + " " + p[1];
                if(map.get(tmp) == null) map.put(tmp, false);
                else if(map.get(tmp) == false) {
                    answer++;
                    map.put(tmp, true);
                }
                
                // 이동 끝난 로봇은 물류 센터 벗어나기
                if(ql.get(i).isEmpty()) {
                    ql.remove(i);
                }
            }
        }
        
        return answer;
    }
}