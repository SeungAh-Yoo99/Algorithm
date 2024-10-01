import java.util.*;

class Solution {
    public int solution(String s) {
        
        int answer = 0;
        
        List<String> numbers = new ArrayList<>(Arrays.asList("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"));
        
        // s를 char 배열로 변환
        char[] arr = s.toCharArray();
        
        int index;
        StringBuilder tmp = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            
            // 숫자 그대로인 경우
            if(arr[i] >= '0' & arr[i] <= '9') answer = answer * 10 + (arr[i] - '0');
            
            // 문자로 변환된 경우
            else {
                tmp.append(arr[i]);
                
                // tmp에 대응하는 문자열이 있다면 문자열로 변환
                index = numbers.indexOf(tmp.toString());
                if(index != -1) {
                    answer = answer * 10 + index;
                    tmp = new StringBuilder();
                }
            }
        }
        
        return answer;
    }
}