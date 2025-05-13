import java.util.*;

class Solution {
    public int solution(String[] order) {
        
        HashSet<String> americano = new HashSet<>();
        americano.addAll(List.of("iceamericano", "americanoice", "hotamericano", "americanohot", "americano", "anything"));
        
        int answer = 0;
        
        for(String o : order) {
            if(americano.contains(o)) answer += 4500;
            else answer += 5000;
        }
        
        return answer;
    }
}