import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        // {prices, index}
        Deque<int[]> stack = new ArrayDeque<>();
        
        int[] tmp;
        for(int i = 0; i < prices.length; i++) {
            
            while(!stack.isEmpty() && stack.peekLast()[0] > prices[i]) { // 가격이 떨어진 경우
                tmp = stack.pollLast();
                answer[tmp[1]] = i - tmp[1];
            }
            
            stack.offerLast(new int[] {prices[i], i});
        }
        
        while(!stack.isEmpty()) {
            tmp = stack.pollLast();
            answer[tmp[1]] = prices.length - 1 - tmp[1];
        }
        
        return answer;
    }
}