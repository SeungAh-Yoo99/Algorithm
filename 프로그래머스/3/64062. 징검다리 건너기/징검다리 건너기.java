import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        
        // 점프할 수 있는 거리의 디딤돌의 숫자 순으로 내림차순 정렬할 큐
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        
        // 현재 위치
        int point = -1;
        
        // 마지막으로 큐에 넣은 디딤돌 위치
        int visited = -1;
        
        // 항상 최선의 위치로 이동했을 때의 최솟값
        int answer = Integer.MAX_VALUE;
        
        int[] next;
        while(point + k < stones.length) {
            
            // 현재 위치에서 점프할 수 있는 디딤돌들 큐에 넣어줌
            for(int i = visited + 1; i <= point + k; i++) {
                pq.add(new int[] {stones[i], i});
            }
            visited = point + k;
            
            // 다음에 이동할 디딤돌 고르기
            next = new int[] {0, -2};
            while(next[1] < point) next = pq.poll(); // 이미 뛰어넘은 곳은 넘어감
            
            // 다음으로 이동할 디딤돌 위치
            point = next[1];
            
            // 건넌 디딤돌 중 최솟값 저장
            answer = Math.min(answer, next[0]);
        }
        
        
        return answer;
    }
}
