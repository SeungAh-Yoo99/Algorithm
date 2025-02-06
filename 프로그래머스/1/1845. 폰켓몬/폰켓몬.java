import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        // 중복 제거를 위한 set
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        
        int answer = Math.min(nums.length / 2, set.size());
        return answer;
    }
}