import java.util.*;

class Solution {
    public String solution(String s) {
        
        // 각 문자를 아스키 코드로 저장할 배열
        Integer[] code = new Integer[s.length()];
        for(int i = 0; i < s.length(); i++)
            code[i] = (int)s.charAt(i);
        
        // 내림차순으로 정렬
        Arrays.sort(code, (o1, o2) -> o2 - o1);
        
        // 다시 문자열로 변경
        StringBuilder answer = new StringBuilder();
        for(int c : code) answer.append((char)c);
        return answer.toString();
    }
}