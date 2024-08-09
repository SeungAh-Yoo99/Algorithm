class Solution {
    
    private static final int MOD = 1_234_567;
    
    public int solution(int n) {
        
        int[] dp = new int[n + 1]; // 피보나치 수를 저장할 dp 배열
        dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i -2]) % MOD;
        }
        
        int answer = dp[n];
        return answer;
    }
}