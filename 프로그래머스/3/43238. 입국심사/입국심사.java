class Solution {
    public long solution(int n, int[] times) {
        
        long answer = Long.MAX_VALUE;
        
        // 이분탐색
        long s = 0, e = Long.MAX_VALUE, m;
        long count;
        while(s <= e) {
            m = (s + e) / 2;
            
            // m 시간 안에 입국 심사를 끝낼 수 있는지 확인
            count = 0;
            for(int i = 0; i < times.length; i++) {
                count += m / times[i];
                if(count >= n) break;
            }
            
            if(count >= n) { // m 시간 안에 입국 심사를 끝낼 수 있다면
                answer = m;
                e = m - 1; // 더 짧은 시간 안에 끝낼 수 있는지 확인
            }
            else // m 시간 안에 입국 심사를 끝낼 수 없다면
                s = m + 1; // 더 긴 시간 안에 끝낼 수 있는지 확인
        }
        
        return answer;
    }
}