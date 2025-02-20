class Solution {
    public int solution(int n, String control) {
        int answer = n;
        
        char c;
        for(int i = 0; i < control.length(); i++) {
            c = control.charAt(i);
            
            if(c == 'w') answer++;
            else if(c == 's') answer--;
            else if(c == 'd') answer += 10;
            else answer -= 10;
        }
        
        return answer;
    }
}