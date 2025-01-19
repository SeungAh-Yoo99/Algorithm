class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        // 이분탐색
        int s = 1, e = 100_000, m;
        long t;
        while(s <= e) {
            m = (s + e) / 2;
            
            // 숙련도 m으로 limit 안에 퍼즐을 모두 해결할 수 있는지 확인
            t = times[0];
            for(int i = 1; i < diffs.length; i++) {
                // 숙련도 m으로 한 번에 풀 수 없는 문제인 경우
                if(diffs[i] > m) t += (times[i - 1] + times[i]) * (diffs[i] - m) + times[i];
                // 숙련도 m으로 한 번에 풀 수 있는 문제인 경우
                else t += times[i];
            }
            
            // 숙련도 m으로 limit 안에 퍼즐을 모두 해결할 수 있는 경우
            if(t <= limit) {
                answer = m;
                e = m - 1; // 더 낮은 숙련도 확인
            }
            // 퍼즐을 모두 해결할 수 없는 경우 더 높은 숙련도 확인
            else s = m + 1;
        }
        return answer;
    }
}