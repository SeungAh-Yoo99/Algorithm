import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        
        // food_times를 올림차순으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < food_times.length; i++) {
            pq.add(food_times[i]);
        }
        
        // 몇 번 회전했는지 저장
        int count = 0;
        
        int min;
        while(!pq.isEmpty() && k >= pq.size()) {
            // 현재 가장 적게 남은 음식
            min = pq.peek() - count;
            
            // 가장 적게 남은 음식이 끝날 때까지 회전
            if(k >= (long)min * pq.size()) {
                count += min;
                k -= (long)min * pq.size();
            }
            // 가장 적게 남은 음식이 끝날 때까지 회전하진 못한다면
            else {
                // 돌 수 있는 만큼은 돌기
                count += k / pq.size();
                k %= (long)pq.size();
            }
            
            // 끝난 음식 제거
            while(!pq.isEmpty() && pq.peek() == count) pq.poll();
        }
        
        // 회전할 수 있는만큼 회전했으므로
        // 마지막으로 순회하며 먹기 시작하는 음식 구하기
        int answer = -1;
        for(int i = 0; i < food_times.length; i++) {
            if(food_times[i] > count) k--;
            // 다시 먹기 시작하는 음식 찾음
            if(k == -1) {
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
}
