import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        
        StringTokenizer st = new StringTokenizer(my_string);
        
        // 답을 임시로 담을 리스트
        List<String> list = new ArrayList<>();
        while(st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        
        // 배열에 옮겨 담기
        String[] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}