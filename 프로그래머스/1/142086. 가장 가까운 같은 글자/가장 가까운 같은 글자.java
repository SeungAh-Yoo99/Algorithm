import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        // 각 문자가 마지막에 등장한 인덱스 정보를 저장할 배열
        int[] index = new int['z' - 'a' + 1];
        Arrays.fill(index, -1);
        
        int[] answer = new int[s.length()];
        
        char c;
        for(int i = 0; i < s.length(); i++) {
            
            // i번째 문자
            c = s.charAt(i);
            
            // 해당 문자가 처음 나온 경우
            if(index[c - 'a'] == -1) answer[i] = -1;
            // 이전에 나온 문자라면
            // 마지막으로 나왔던 자리가 몇 칸 떨어져 있었는지 계산
            else answer[i] = i - index[c - 'a'];
            
            // 현재 문자가 마지막으로 등장한 위치 저장
            index[c - 'a'] = i;
        }
        return answer;
    }
}