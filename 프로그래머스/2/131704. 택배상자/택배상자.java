import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        int pointer = 1; // 컨테이너 벨트의 가장 앞에 있는 택배 번호
        
        Deque<Integer> deq = new ArrayDeque<>(); // 보조 컨테이너 벨트
        
        for(int i = 0; i < order.length; i++) {
            
            // 컨테이너 벨트에 남아있는 택배 중 하나를 실어야 하는 경우
            while(order[i] > pointer) {
                deq.addFirst(pointer++);
            }
            
            // 컨테이너 벨트의 가장 앞에 있는 택배를 실을 차례
            if(order[i] == pointer) {
                answer++;
                pointer++;
            }
            // 보조 컨테이너 벨트의 가장 앞에 있는 택배를 실을 차례
            else if(!deq.isEmpty() && order[i] == deq.peek()) {
                deq.poll();
                answer++;
            }
            else break;
        }
        
        return answer;
    }
}