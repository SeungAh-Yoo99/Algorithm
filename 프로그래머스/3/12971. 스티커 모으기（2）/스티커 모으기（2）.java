class Solution {
    public int solution(int sticker[]) {
        
        // 스티커 조각이 한 개라면 한 개 그대로 땜
        if(sticker.length == 1) return sticker[0];
        
        // dp[i][0] := i번째 스티커를 뜯지 않은 경우 중 최대값
        // dp[i][1] := i번째 스티커를 뜯은 경우 중 최대값
        int[][] dpWith0 = new int[sticker.length][2]; // 0번 스티커를 뜯은 dp 배열
        int[][] dpWithout0 = new int[sticker.length][2]; // 0번 스티커를 뜯지 않은 dp 배열
        
        dpWith0[0][1] = sticker[0];
        for(int i = 1; i < sticker.length; i++) {
            // i번째 스티커를 뜯지 않는다면, i - 1번째 스티커는 뜯던 뜯지 않던 상관없음
            dpWith0[i][0] = Math.max(dpWith0[i - 1][0], dpWith0[i - 1][1]);
            dpWithout0[i][0] = Math.max(dpWithout0[i - 1][0], dpWithout0[i - 1][1]);
            
            // i번째 스티커를 뜯는다면, i -1번째 스티커는 함께 뜯을 수 없음
            dpWith0[i][1] = dpWith0[i - 1][0] + sticker[i];
            dpWithout0[i][1] = dpWithout0[i - 1][0] + sticker[i];
        }
        
        // 0번째 스티커와 n번째 스티커를 한 번에 땐 경우 빼고 최대값 구하기
        int answer = Math.max(dpWith0[sticker.length - 1][0], dpWithout0[sticker.length - 1][0]);
        answer = Math.max(answer, dpWithout0[sticker.length - 1][1]);

        return answer;
    }
}