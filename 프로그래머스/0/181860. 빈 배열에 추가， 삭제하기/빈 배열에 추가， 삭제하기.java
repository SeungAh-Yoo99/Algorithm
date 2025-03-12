import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        
        // X의 원소들을 임시로 담아둘 Deque
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 0; i < flag.length; i++) {
            if(flag[i]) {
                for(int j = 0; j < arr[i] * 2; j++)
                    dq.addLast(arr[i]);
            }
            else {
                for(int j = 0; j < arr[i]; j++)
                    dq.pollLast();
            }
        }
        
        // Deque -> 배열
        int[] answer = new int[dq.size()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = dq.pollFirst();
        return answer;
    }
}