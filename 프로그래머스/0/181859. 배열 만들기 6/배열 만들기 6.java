import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        // stk의 원소를 임시 저장할 List
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(list.isEmpty()) {
                list.add(arr[i]);
            }
            else if(list.get(list.size() - 1) == arr[i]) {
                list.remove(list.size() - 1);
            }
            else {
                list.add(arr[i]);
            }
        }
        
        // List -> 배열
        if(list.isEmpty()) return new int[] {-1};
        int[] stk = new int[list.size()];
        for(int i = 0; i < stk.length; i++)
            stk[i] = list.get(i);
        return stk;
    }
}