class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 소수가 아닌 것을 표시하는 배열
        boolean[] isNotPrimeNumber = new boolean[n + 1];
        
        for(int i = 2; i <= n; i++) {
            if(!isNotPrimeNumber[i]) {
                
                answer ++;
                
                // i가 소수일 때, i의 배수들은 소수가 아님
                for(int j = 2 * i; j <= n; j += i) isNotPrimeNumber[j] = true;
            }
        }
        
        return answer;
    }
}