import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        
        int answer = 0;
        
        // key := 문자열 길이
        // value := 개수
        Map<Integer, Integer> map = new HashMap<>();
        
        int count;
        for(int i = 0; i < strArr.length; i++) {
            count = map.getOrDefault(strArr[i].length(), 0) + 1;
            map.put(strArr[i].length(), count);
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
}