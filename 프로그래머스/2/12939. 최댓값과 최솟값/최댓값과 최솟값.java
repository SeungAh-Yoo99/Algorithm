import java.util.*;

class Solution {
    public String solution(String s) {
        
        int min = Integer.MAX_VALUE;
        int max = -1 * Integer.MAX_VALUE;
        
        int tmp;
        StringTokenizer st = new StringTokenizer(s, " ");
        while(st.hasMoreTokens()) {
            tmp = Integer.parseInt(st.nextToken());
            
            min = Math.min(min, tmp);
            max = Math.max(max, tmp);
        }
        
        String answer = min + " " + max;
        return answer;
    }
}