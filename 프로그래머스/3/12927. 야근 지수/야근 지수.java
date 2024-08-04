import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        
        // 내림차순 정렬을 위한 pq
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        // 남은 작업량을 내림차순 정렬
        for(int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }
        
        // 가장 작업량이 많이 남은 작업부터 꺼내서 처리
        int w;
        for(int i = 0; i < n; i++) {
            w = pq.poll() - 1;
            
            // 해당 작업을 끝냈다면 다시 넣지 않음
            if(w > 0) pq.add(w);
            
            // 더 이상 처리할 작업이 없다면 끝냄
            if(pq.isEmpty()) break;
        }
        
        // 피로도 구하기
        long answer = 0;
        while(!pq.isEmpty()) answer += Math.pow(pq.poll(), 2);
        
        return answer;
    }
}