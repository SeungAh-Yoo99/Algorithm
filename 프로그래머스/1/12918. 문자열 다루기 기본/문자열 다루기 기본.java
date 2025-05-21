class Solution {
    public boolean solution(String s) {
        
        // 길이 체크
        if(s.length() != 4 && s.length() != 6)
            return false;
        
        // 문자 체크
        for(char c : s.toCharArray()) {
            if(c < '0' || c > '9') return false;
        }
        
        return true;
    }
}