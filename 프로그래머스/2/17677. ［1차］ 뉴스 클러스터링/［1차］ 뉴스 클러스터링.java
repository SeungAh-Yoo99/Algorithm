import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        
        // str1의 다중집합
        Map<String, Integer> set1 = new HashMap<>();
        getSet(str1, set1);
        
        // str2의 다중집합
        Map<String, Integer> set2 = new HashMap<>();
        getSet(str2, set2);
        
        // 교집합 갯수 구하기
        int andSet = 0;
        for(String key : set1.keySet()) {
            andSet += Math.min(set1.getOrDefault(key, 0), set2.getOrDefault(key, 0));
        }
        
        // 합집합 갯수 구하기
        int orSet = 0;
        for(String key : set1.keySet()) {
            orSet += Math.max(set1.getOrDefault(key, 0), set2.getOrDefault(key, 0));
        }
        for(String key : set2.keySet()) {
            if(set1.get(key) == null)
                orSet += set2.get(key);
        }
        
        // 다중집합 구하기
        int answer;
        if(orSet == 0) answer = 65536;
        else answer = andSet * 65536 / orSet;
        return answer;
    }
    
    private void getSet(String str, Map<String, Integer> set) {
        
        String tmp;
        for(int i = 1; i < str.length(); i++) {
            // 알파벳이 아닐 경우 넘어가기
            if(!(str.charAt(i - 1) >= 'a' && str.charAt(i - 1) <= 'z')
               && !(str.charAt(i - 1) >= 'A' && str.charAt(i - 1) <= 'Z')) continue;
            if(!(str.charAt(i) >= 'a' && str.charAt(i) <= 'z')
               && !(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')) continue;
            
            tmp = str.substring(i - 1, i + 1).toUpperCase();
            
            set.put(tmp, set.getOrDefault(tmp, 0) + 1);
        }
    }
}