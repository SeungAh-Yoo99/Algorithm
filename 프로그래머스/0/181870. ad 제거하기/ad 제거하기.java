import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        
        // 답 임시 저장 리스트
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i < strArr.length; i++) {
            if(!strArr[i].contains("ad")) list.add(strArr[i]);
        }
        
        // 배열로 변환
        String[] answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}