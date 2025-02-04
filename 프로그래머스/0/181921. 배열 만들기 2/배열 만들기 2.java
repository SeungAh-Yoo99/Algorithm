import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        
        // 정답을 임시로 담을 리스트
        List<Integer> list = new ArrayList<>();
        
        for(int i = l % 5 == 0 ? l : (l / 5 + 1) * 5; i <= r; i += 5) {
            if(isIn05(i)) list.add(i);
        }
        
        if(list.size() == 0) return new int[] {-1};
        
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
    
    boolean isIn05(int num) {
        
        while(num > 0) {
            if(num % 10 != 0 && num % 10 != 5) return false;
            num /= 10;
        }
        
        return true;
    }
}