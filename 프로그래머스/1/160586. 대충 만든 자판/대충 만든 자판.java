import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        HashMap<Character, Integer> km = new HashMap<>();
        
        // 각 키별로 가장 적게 누를 수 있는 횟수 저장
        String key; char k;
        for(int i = 0; i < keymap.length; i++) {
            key = keymap[i];
            for(int j = 0; j < key.length(); j++) {
                k = key.charAt(j);
                if(km.get(k) == null || km.get(k) > j + 1)
                    km.put(k, j + 1);
            }
        }
        
        int[] answer = new int[targets.length];
        
        for(int i = 0; i < targets.length; i++) {
            key = targets[i];
            for(int j = 0; j < key.length(); j++) {
                k = key.charAt(j);
                if(km.get(k) == null) {
                    answer[i] = -1;
                    break;
                }
                else answer[i] += km.get(k);
            }
        }
        
        return answer;
    }
}