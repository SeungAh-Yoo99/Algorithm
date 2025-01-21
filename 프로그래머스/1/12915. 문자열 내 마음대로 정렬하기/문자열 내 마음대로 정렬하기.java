import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings, (o1, o2) ->
                    o1.charAt(n) == o2.charAt(n) // n번째 글자가
                        ? o1.compareTo(o2) // 같다면 사전순 정렬
                        : o1.charAt(n) - o2.charAt(n)); // 다르면 n번째 글자 기준 오름차순 정렬
        
        return strings;
    }
}