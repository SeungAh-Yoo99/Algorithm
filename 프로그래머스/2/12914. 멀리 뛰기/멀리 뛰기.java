class Solution {
    
    static final int MOD = 1_234_567;
    
    public long solution(int n) {
        
        if(n == 1) return 1;
        else if(n == 2) return 2;
        
        long[] dp = new long[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            dp[i] += dp[i - 1];
            dp[i] += dp[i - 2];
            dp[i] %= MOD;
        }
        
        long answer = dp[n];
        return answer;
    }
}