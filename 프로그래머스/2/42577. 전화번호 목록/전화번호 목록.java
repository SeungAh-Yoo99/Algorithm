import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        // 이전 번호를 담아둠
        Set<String> set = new HashSet<>();
        for(int i = 0; i < phone_book.length; i++)
            set.add(phone_book[i]);
        
        StringBuilder sb;
        for(int i = 0; i < phone_book.length; i++) {
            sb = new StringBuilder();
            
            for(int j = 0; j < phone_book[i].length() - 1; j++) {
                sb.append(phone_book[i].charAt(j)); // i번째 단어의 0 ~ j까지 슬라이싱한 문자열이 담겨 있음
                
                if(set.contains(sb.toString())) { // 다른 번호가 접두어인 경우 false 리턴
                    return false;
                }
            }
        }
        
        return true;
    }
}