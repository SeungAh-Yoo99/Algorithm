class Solution {
    public String solution(String my_string, int m, int c) {
        
        StringBuilder answer = new StringBuilder();
        
        int idx = c - 1;
        while(idx < my_string.length()) {
            answer.append(my_string.charAt(idx));
            idx += m;
        }
        
        return answer.toString();
    }
}