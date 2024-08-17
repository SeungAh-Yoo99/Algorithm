class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        
        // 처음 겹쳐있는 경우
        if(m1 == 0 && s1 == 0) answer++;
        
        while(h1 * 3600 + m1 * 60 + s1 < h2 * 3600 + m2 * 60 + s2) {
            
             // s1애서 s1 + 1초가 될 때, 분침과 시침이 겹쳐있는 경우
            if((h1 == 11 || h1 == 23) && m1 == 59 && s1 == 59) answer++;
            else {
                // 분침과 초침이 만난 경우
                if(m1 == s1 && !(m1 == 0 && s1 == 0)) answer++;
                // 시침과 초침이 만난 경우
                if((h1 % 12) * 5 + m1 / 12 == s1 && !((h1 % 12 == 0) && m1 == 0 && s1 == 0)) answer++;   
            }
            
            // 1초 증가
            if(s1 == 59) {
                if(m1 == 59) {
                    h1++;
                    m1 = 0;
                    s1 = 0;
                }
                else {
                    m1++;
                    s1 = 0;
                }
            }
            else s1++;
        }
        
        
        return answer;
    }
}