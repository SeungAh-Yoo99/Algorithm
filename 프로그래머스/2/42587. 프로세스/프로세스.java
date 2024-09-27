import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        // 인덱스 번호와 우선순위를 담은 배열을 넣을 큐
        Deque<int[]> deque = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++) {
            deque.offerLast(new int[] {i, priorities[i]});
        }
        
        // 우선순위를 내림차순으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }
        
        int[] now;
        int answer = 0;
        while(!deque.isEmpty()) {
            now = deque.pollFirst();
            
            // 우선순위가 가장 높은 프로세스가 아니라면
            if(now[1] != pq.peek()) {
                deque.addLast(now);
            }
            // 우선순위가 가장 높은 프로세스라면
            else {
                pq.poll();
                answer++;
                
                // 몇 번째로 실행되는지 알고 싶은 프로세스를 찾았다면
                if(now[0] == location) {
                    break;
                }
            }
        }
        
        return answer;
    }
}