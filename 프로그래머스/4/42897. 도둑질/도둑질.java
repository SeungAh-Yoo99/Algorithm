class Solution {
    public int solution(int[] money) {
        
        // dp1[i] := i번째 집을 털었을 경우의 최대값(턴 집 리스트에 0번째 집이 포함되어 있음)
        // dp2[i] := i번째 집을 털었을 경우의 최대값(턴 집 리스트에 0번째 집이 포함되어 있지 않음)
        // dp3[i] := i번째 집을 털지 않았을 경우의 최대값(턴 집 리스트에 0번째 집이 포함되어 있음)
        // dp4[i] := i번째 집을 털지 않았을 경우의 최대값(턴 집 리스트에 0번째 집이 포함되어 있지 않음)
        int[] dp1 = new int[money.length];
        int[] dp2 = new int[money.length];
        int[] dp3 = new int[money.length];
        int[] dp4 = new int[money.length];
        
        dp1[0] = money[0];
        for(int i = 1; i < money.length - 1; i++) {
            // i번째 집을 터는 경우, i - 1번째 집은 무조건 털 수 없음
            dp1[i] = dp3[i - 1] + money[i];
            dp2[i] = dp4[i - 1] + money[i];
            
            // i번째 집을 털지 않는 경우. i - 1번째 집은 털거나 털지 않거나 상관 없음
            // 더 큰 경우를 저장
            dp3[i] = Math.max(dp1[i - 1], dp3[i - 1]);
            dp4[i] = Math.max(dp2[i - 1], dp4[i - 1]);
        }
        
        // 0번째 집과 마지막 집도 인접해 있으므로
        // 마지막 집을 터는 경우, 턴 집 리스트에 0번째 집이 포함되어 있으면 안됨.
        int last = money.length - 1; // 마지막 집 인덱스
        
        // 0번째 집 털지 않고 마지막 집 터는 경우
        dp2[last] = dp4[last - 1] + money[last];
        
        // 0번째 집을 털은 경우 중, 마지막 전 집을 터는 경우와 털지 않은 경우 중 큰 수와 비교
        dp3[last] = Math.max(dp1[last - 1], dp3[last - 1]);
        
        // 0번째 집을 털지 않은 경우 중, 마지막 전 집을 터는 경우와 털지 않은 경우 중 큰 수와 비교
        dp4[last] = Math.max(dp2[last - 1], dp4[last - 1]);
        
        int answer = Math.max(dp2[last], dp3[last]);
        answer = Math.max(answer, dp4[last]);
        
        return answer;
    }
}