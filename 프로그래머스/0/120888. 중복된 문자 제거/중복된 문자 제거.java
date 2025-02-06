import java.util.*;

class Solution {
    public String solution(String my_string) {
        
        StringBuilder answer = new StringBuilder();
        
        // 중복 제거를 위한 set
        Set<Character> set = new HashSet<>();
        
        for(char c : my_string.toCharArray()) {
            if(!set.contains(c)) {
                set.add(c);
                answer.append(c);
            }
        }
        
        return answer.toString();
    }
}