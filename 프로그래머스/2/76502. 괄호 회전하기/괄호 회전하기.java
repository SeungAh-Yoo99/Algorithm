import java.util.*;

class Solution {
    public int solution(String s) {
        
        int answer = 0;
        
        List<Character> sList = new LinkedList<>();
        for(int i = 0; i < s.length(); i++) {
            sList.add(s.charAt(i));
        }
        
        Stack<Character> stack = new Stack<>();
        boolean flag;
        for(int i = 0; i < s.length(); i++) {
            flag = true;
            
            for(int j = 0; j < sList.size(); j++) {
                if(sList.get(j) == '(' || sList.get(j) == '{' || sList.get(j) == '[')
                    stack.push(sList.get(j));
                else if((sList.get(j) == ')' && !stack.isEmpty() && stack.peek() == '(') ||
                        (sList.get(j) == '}' && !stack.isEmpty() &&  stack.peek() == '{') ||
                        (sList.get(j) == ']' && !stack.isEmpty() &&  stack.peek() == '['))
                            stack.pop();
                else {
                    flag = false;
                    break;
                }
            }
            
            if(stack.size() != 0) flag = false;
            
            if(flag) answer++;
            
            sList.add(sList.get(0));
            sList.remove(0);
        }
        
        return answer;
    }
}