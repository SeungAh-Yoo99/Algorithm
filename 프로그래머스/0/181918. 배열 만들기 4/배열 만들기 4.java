import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        // 스택으로 사용할 덱
        Deque<Integer> stack = new ArrayDeque<>();
        
        // 스택 자료구조를 사용해 작업 수행
        int idx = 0;
        while(idx < arr.length) {
            if(stack.isEmpty())
                stack.add(arr[idx++]);
            else if(stack.peekLast() < arr[idx])
                stack.add(arr[idx++]);
            else stack.pollLast();
        }
        
        int[] stk = new int[stack.size()];
        for(int i = 0; i < stk.length; i++)
            stk[i] = stack.poll();
        return stk;
    }
}