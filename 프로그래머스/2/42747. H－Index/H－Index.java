class Solution {
    public int solution(int[] citations) {
        
        int answer = 0;
        
        // 이분탐색
        int s = 0, e = 10_000, m;
        int count;
        while(s <= e) {
            
            m = (s + e) / 2;
            
            // m번 이상 인용된 논문 개수 세기
            count = 0;
            for(int c : citations) {
                if(c >= m) count++;
            }
            
            if(count >= m) {
                answer = m;
                s = m + 1;
            }
            else e = m - 1;
        }
    
        return answer;
    }
}