import java.util.*;

class Solution {
    public String solution(String new_id) {
        
        // 1. 대문자 -> 소문자
        String answer = new_id.toLowerCase();
        // 2. 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 제외한 모든 문자 제거
        StringBuilder tmp = new StringBuilder();
        char[] arr = answer.toCharArray();
        for(char c : arr) {
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.')
                tmp.append(c);
        }
        answer = tmp.toString();
        // 3. 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        tmp = new StringBuilder();
        arr = answer.toCharArray();
        tmp.append(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i - 1] != '.' || arr[i] != '.') tmp.append(arr[i]);
        }
        // 4. 마침표(.)가 처음이나 끝에 위치한다면 제거
        if(tmp.length() > 0 && tmp.charAt(0) == '.') tmp.delete(0, 1);
        if(tmp.length() > 0 && tmp.charAt(tmp.length() - 1) == '.') tmp.delete(tmp.length() - 1, tmp.length());
        // 5. 빈 문자열이라면, "a" 대입
        if(tmp.length() == 0) tmp.append("a");
        // 6. 길이가 16자 이상이면, 첫 15개의 문자를 제외한 나머지 문자들은 모두 제거
        //    제거 후 마침표(.)가 끝에 위치한다면 끝에 위치한 마침표(.) 제거
        if(tmp.length() >= 16) tmp.delete(15, tmp.length());
        if(tmp.charAt(tmp.length() - 1) == '.') tmp.delete(tmp.length() - 1, tmp.length());
        // 7. 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 추가
        if(tmp.length() <= 2) {
            while(tmp.length() < 3) tmp.append(tmp.charAt(tmp.length() - 1));
        }
        answer = tmp.toString();
        
        return answer;
    }
}