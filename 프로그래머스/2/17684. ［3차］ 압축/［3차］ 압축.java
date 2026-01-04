import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        // 답
        List<Integer> answer = new ArrayList<>();
        
        // 사전
        Map<String, Integer> dic = new HashMap<>();
        
        // 사전 정보 초기화
        for(int i = 0; i <= 'z' - 'a'; i++)
            dic.put(new String(new char[] {(char)((int)'A' + i)}), i + 1);
        
        int idx = 0, len = 1;
        String tmp = "";
        while(idx < msg.length()) {
            while(idx + len <= msg.length()) {
                tmp = msg.substring(idx, idx + len);
                if(dic.get(tmp) != null) len++;
                else {
                    answer.add(dic.get(msg.substring(idx, idx + len - 1)));
                    dic.put(tmp, dic.size() + 1);
                    idx += len - 1;
                    len = 1;
                    break;
                }
            }
            
            if(idx + len > msg.length()) {
                if(dic.get(tmp) != null) answer.add(dic.get(tmp));
                break;
            }
            
        }
        
        int[] answerToArray = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++)
            answerToArray[i] = answer.get(i);
        
        return answerToArray;
    }
}