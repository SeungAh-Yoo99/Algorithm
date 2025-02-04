import java.util.*;

class Solution {
    public String solution(String myString) {
        
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < myString.length(); i++) {
            if(myString.charAt(i) == 'a' || myString.charAt(i) == 'A')
                answer.append('A');
            else if(myString.charAt(i) >= 'B' && myString.charAt(i) <= 'Z')
                answer.append((char)(myString.charAt(i) - 'A' + 'a'));
            else answer.append(myString.charAt(i));
        }
        
        return answer.toString();
    }
}