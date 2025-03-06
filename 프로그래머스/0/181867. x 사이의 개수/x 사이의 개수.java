import java.util.*;

class Solution {
    public int[] solution(String myString) {
        
        // 답을 임시로 담아둘 리스트
        List<Integer> list = new ArrayList<>();
        
        int idx = 0, count;
        while(idx < myString.length()) {
            count = 0;
            
            while(idx < myString.length() && myString.charAt(idx) != 'x') {
                idx++;
                count++;
            }
            
            list.add(count);
            idx++;
        }
        // 마지막이 "x"로 끝난 경우
        if(myString.charAt(myString.length() - 1) == 'x') list.add(0);
        
        // 리스트 -> 배열
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}