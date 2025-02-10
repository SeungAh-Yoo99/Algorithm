import java.util.*;

class Solution {
    public int solution(String s) {
        
        StringTokenizer st = new StringTokenizer(s);
        
        int answer = 0;
        
        int pre = 0; // 이전에 나온 숫자
        String tmp;
        while(st.hasMoreTokens()) {
            tmp = st.nextToken();
            
            if(tmp.equals("Z")) answer -= pre;
            else {
                pre = Integer.parseInt(tmp);
                answer += pre;
            }
        }
        
        return answer;
    }
}