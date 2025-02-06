class Solution {
    public String solution(int q, int r, String code) {
        
        StringBuilder answer = new StringBuilder();
        
        int idx = r;
        while(idx < code.length()) {
            answer.append(code.charAt(idx));
            idx += q;
        }
        
        return answer.toString();
    }
}