class Solution {
    
    char[] words = {'A', 'E', 'I', 'O', 'U'};
    String word;
    int answer;
    
    public int solution(String word) {
        
        this.word = word;
        this.answer = 0;
        
        recursion(new StringBuilder());
        
        return answer;
    }
    
    private boolean recursion(StringBuilder sb) {
        
        if(sb.toString().equals(word)) return true;
        
        if(sb.length() == 5) return false;
        
        int ret; StringBuilder tmp;
        for(int i = 0; i < 5; i++) {
            answer++;
            tmp = new StringBuilder(sb);
            if(recursion(tmp.append(words[i]))) return true;
        }
        
        return false;
    }
}