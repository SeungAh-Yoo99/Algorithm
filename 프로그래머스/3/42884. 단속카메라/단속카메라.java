import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        // 들어온 순으로 정렬
        Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0]);
        
        // 필요한 CCTV 개수
        int answer = 0;
        
        // 들어온 차가 나갈 순서
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int now = 0; // 이번에 들어올 차
        while(now < routes.length) {
            
            // 아직 들어온 차가 없다면
            if(pq.isEmpty()) {
                pq.add(routes[now][1]);
                now++;
                continue;
            }
            
            // 이번에 들어올 차보다 먼저 나가는 차가 있다면
            if(routes[now][0] > pq.peek()) {
                // routes[now][0]에 cctv를 설치함으로써 현재 도로에 있는 모든 차들의 경로에 cctv가 있게 함
                answer++;
                pq.clear();
            }
            // 가장 먼저 나가는 차보다 다음으로 들어오는 차가 더 먼저라면
            else {
                pq.add(routes[now][1]);
                now++;
            }
        }
        
        // 아직 도로에 남아있는 차량이 있다면 cctv 한 대 더 설치
        if(!pq.isEmpty()) answer++;
        
        
        return answer;
    }
}