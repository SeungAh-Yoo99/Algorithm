import java.util.*;

class Solution {
    public String solution(String s) {
        
        char[] arr = s.toCharArray();
        StringBuilder answer = new StringBuilder();
        
        for(int i = 0; i < arr.length; i++) {

            // 단어의 첫 문자일 경우
            if(i == 0 || arr[i - 1] == ' ') {
                // 소문자라면 대문자로 변경
                if(arr[i] >= 'a' && arr[i] <= 'z') {
                    arr[i] = (char)(arr[i] - 'a' + 'A');
                }
            }
            // 단어의 첫 문자가 아닐 경우
            else {
                // 대문자라면 소문자로 변경
                if(arr[i] >= 'A' && arr[i] <= 'Z') {
                    arr[i] = (char)(arr[i] - 'A' + 'a');
                }
            }
            
            // 저장
            answer.append(arr[i]);
        }
        
        return answer.toString();
    }
}