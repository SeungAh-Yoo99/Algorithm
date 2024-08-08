class Solution {
    
    static final int MOD = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] map = new int[m + 1][n + 1]; // 웅덩이 정보
        int[][] dp = new int[m + 1][n + 1]; // 이동 경로 정보(오른쪽과 아래쪽으로만 이동 가능하므로 항상 최단거리를 보장한다.)
        dp[1][1] = 1;
        
        for(int i = 0; i < puddles.length; i++) { // 웅덩이 정보 map에 저장
            map[puddles[i][0]][puddles[i][1]] = 1;
        }
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                // 물 웅덩이면 이동 불가
                if(map[i][j] == 1) continue;
                
                // 위에서 아래쪽으로 내려오는 경우
                if(i - 1 >= 1) dp[i][j] += dp[i - 1][j];
                
                // 왼쪽에서 오른쪽으로 온 경우
                if(j - 1 >= 1) dp[i][j] += dp[i][j - 1];
                
                // 모드 연산
                dp[i][j] %= MOD;
            }
        }
        
        int answer = dp[m][n];
        return answer;
    }
}