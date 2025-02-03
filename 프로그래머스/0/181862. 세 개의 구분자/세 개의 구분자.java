import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        
        StringTokenizer st = new StringTokenizer(myStr, "abc");
        
        List<String> list = new ArrayList<>();
        while(st.hasMoreTokens()) list.add(st.nextToken());
        
        String[] answer;
        if(list.size() > 0) answer = list.toArray(new String[list.size()]);
        else answer = new String[] {"EMPTY"};
        
        
        return answer;
    }
}