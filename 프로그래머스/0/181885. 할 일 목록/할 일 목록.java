import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        
        // 아직 마치지 못한 일을 임시로 담을 리스트
        List<String> list = new ArrayList<>();
        for(int i = 0; i < todo_list.length; i++) {
            if(!finished[i]) list.add(todo_list[i]);
        }
        
        String[] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}