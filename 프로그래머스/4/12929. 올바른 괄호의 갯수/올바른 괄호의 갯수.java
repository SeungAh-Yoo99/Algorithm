class Solution {
    
    static int n;
    static int answer;
    
    public int solution(int n) {
        
        this.n = n;
        
        answer = 0;
        backTracking(0, 0);
        return answer;
    }
    
    // open := 열린 괄호가 사용된 개수
    // close := 닫힌 괄호가 사용된 개수
    private static void backTracking(int open, int close) {
        
        if(open == n && close == n) {
            answer++;
            return;
        }
        
        // 올 수 있는 열린 괄호 개수가 남았다면
        if(open < n) {
            backTracking(open + 1, close);
        }
        
        // 올 수 있는 닫힌 괄호 개수가 남았다면
        if(open > close) {
            backTracking(open, close + 1);
        }
    }
}
