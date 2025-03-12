import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        
        // 중복 체크를 위한 Set
        Set<Integer> set = new HashSet<>();
        
        int[] answer = new int[k];
        int index = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(!set.contains(arr[i])) { // 지금까지 나온 적이 없는 수라면
                answer[index++] = arr[i];
                set.add(arr[i]);
                // 서로 다른 k개의 수를 모두 저장하면 break
                if(index == k) break;
            }
        }
        
        // 완성된 배열의 길이가 k보다 작으면 나머지 값을 전부 -1로 채우기
        while(index < k) answer[index++] = -1;
        return answer;
    }
}