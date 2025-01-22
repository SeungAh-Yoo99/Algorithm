import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        
        // 순위를 담을 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int[] answer = new int[score.length];
        
        for(int i = 0; i < score.length; i++) {
            pq.add(score[i]);
            
            // 우선순위 큐에 k개 초과로 점수가 들어있다면
            // 명예의 전당 순위에서 빠진 점수 하나를 빼줌
            if(pq.size() > k) pq.poll();
            
            // 최하위 점수 기록
            answer[i] = pq.peek();
        }
        
        return answer;
    }
}