import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        
        List<Integer> list = new ArrayList<>();
        
        Integer tmp;
        for(String intStr : intStrs) {
            tmp = Integer.parseInt(intStr.substring(s, s + l));
            
            if(tmp > k) list.add(tmp);
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}