import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        
        for(int a : arr) {
            // 이전의 값과 동일하지 않을 때만 list에 넣어줌
            if(list.get(list.size() - 1) != a) list.add(a);
        }
        
        // 리스트를 배열로 변환
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);

        return answer;
    }
}