import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        
        // delete_list의 모든 원소를 담는다
        HashSet<Integer> set = new HashSet<>();
        for(int d : delete_list)
            set.add(d);
        
        // 답을 임시로 담을 리스트
        ArrayList<Integer> list = new ArrayList<>();
        for(int a : arr) {
            if(!set.contains(a)) list.add(a);
        }
        
        // 리스트 -> 배열
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
}