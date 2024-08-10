class Solution {
    public long solution(long n) {
        
        // n에 대한 루트 계산
        long x = (long)Math.sqrt(n);
        
        // 다시 제곱
        long tmp = (long)Math.pow(x, 2);
        
        // tmp가 n과 같다면, n은 x의 제곱
        long answer;
        if(n == tmp) answer = (long)Math.pow(x + 1, 2);
        else answer = -1;

        return answer;
    }
}