import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        // X의 원소를 임시로 담아둘 리스트
        List<Integer> list = new ArrayList<>();
        
        for(int a : arr) {
            for(int i = 0; i < a; i++)
                list.add(a);
        }
        
        // 리스트를 배열로 변환
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++)
            answer[i] = list.get(i);
        return answer;
    }
}