import java.util.*;

class Solution {
    public int solution(int[] elements) {
        
        // 중복 제거를 위한 맵
        Set<Integer> set = new HashSet<>();
        
        int sum, idx;
        for(int i = 1; i <= elements.length; i++) { // 수열의 길이
            for(int j = 0; j < elements.length; j++) { // 시작 부분
                sum = 0;
                for(int k = 0; k < i; k++) {
                    sum += elements[(j + k) % elements.length];
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}