class Solution {
    public String solution(String rny_string) {
        
        StringBuilder answer = new StringBuilder();
        
        for(char c : rny_string.toCharArray()) {
            if(c == 'm') answer.append("rn");
            else answer.append(c);
        }
        
        return answer.toString();
    }
}