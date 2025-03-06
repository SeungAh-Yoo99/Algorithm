import java.util.*;

class Solution {
    public String[] solution(String myString) {
        
        // "x"를 기준으로 문자열 자르기
        StringTokenizer st = new StringTokenizer(myString, "x");
        
        String[] answer = new String[st.countTokens()];
        for(int i = 0; i < answer.length; i++) answer[i] = st.nextToken();
        
        // 정렬
        Arrays.sort(answer);
        
        return answer;
    }
}