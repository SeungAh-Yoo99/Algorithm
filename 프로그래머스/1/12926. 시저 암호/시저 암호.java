import java.util.*;

class Solution {
    public String solution(String s, int n) {
        
        StringBuilder answer = new StringBuilder();
        
        char c;
        for(int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            
            if(c >= 'A' && c <= 'Z') {
                c = (char)((c - 'A' + n) % ('Z' - 'A' + 1) + 'A');
            }
            else if(c >= 'a' && c <= 'z') {
                c = (char)((c - 'a' + n) % ('z' - 'a' + 1) + 'a');
            }
            
            answer.append(c);
        }
        
        return answer.toString();
    }
}