import java.util.*;

class Solution {
    public String solution(String s) {
        
        // 일단 다 소문자로 변경
        s = s.toLowerCase();
        
        StringBuilder answer = new StringBuilder();

        int index = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') { // 영어 문자라면
                if(index % 2 == 0) { // 짝수번째 알파벳은 대문자로
                    answer.append((char)(s.charAt(i) - 'a' + 'A'));
                }
                // 홀수번째 알파벳은 소문자로
                else answer.append(s.charAt(i));
                
                index++;
            }
            else { // 영어 문자가 아니라면 그대로 출력
                answer.append(s.charAt(i));
                index = 0;
            }
        }
        
        return answer.toString();
    }
}