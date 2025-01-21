import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        // 답을 임시로 담을 리스트
        List<Integer> list = new ArrayList<>();
        
        for(int a : arr) {
            if(a % divisor == 0) list.add(a);
        }
        
        // 배열에 담기
        if(list.size() == 0) return new int[] {-1};
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        // 정렬
        Arrays.sort(answer);
        
        return answer;
    }
}