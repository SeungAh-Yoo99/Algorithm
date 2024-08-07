import java.util.*;

class Solution {
    public int[] solution(long n) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        // 맨 뒷자리부터 차례로 list에 넣기
        while(n > 0) {
            list.add((int)(n % 10));
            n /= 10;
        }
        
        // 배열로 옮기기
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}