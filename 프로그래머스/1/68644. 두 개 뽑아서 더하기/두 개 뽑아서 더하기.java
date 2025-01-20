import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        // 중복 제거를 위한 set
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        
        // 배열에 저장
        int[] answer = new int[set.size()];
        int idx = 0;
        for(int n : set) {
            answer[idx++] = n;
        }
        
        // 정렬
        Arrays.sort(answer);
        
        return answer;
    }
}