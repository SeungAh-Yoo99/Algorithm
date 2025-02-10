import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        
        // 스코빌 지수를 오름차순으로 정렬해 담을 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville) pq.add(s);
        
        int answer = 0;
        
        // 가장 맵지 않은 음식의 스코빌 지수가 K 이상이 될 때까지
        int s1, s2;
        while(pq.peek() < K && pq.size() >= 2) {
            // 가장 맵지 않은 음식
            s1 = pq.poll();
            // 두 번째로 맵지 않은 음식
            s2 = pq.poll();
            
            // 섞기
            pq.add(s1 + s2 * 2);
            answer++;
        }
        
        return pq.peek() < K ? -1 : answer;
    }
}