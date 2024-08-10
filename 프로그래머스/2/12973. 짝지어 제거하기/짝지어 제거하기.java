import java.util.*;

class Solution
{   
    public int solution(String s)
    {
        char[] arr = s.toCharArray();
        
        // 문자를 하나씩 확인하며, 스택의 맨 위에 같은 문자가 있으면 pop, 아니라면 push
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(stack.isEmpty() || stack.peek() != arr[i]) stack.push(arr[i]);
            else stack.pop();
        }
        
        int answer = 0;
        if(stack.size() == 0) answer = 1; // 스택이 비어있다면 짝지어 제거하기가 성공한 것

        return answer;
    }
}