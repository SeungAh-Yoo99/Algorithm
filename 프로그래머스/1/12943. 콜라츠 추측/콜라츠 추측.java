class Solution {
    public int solution(int num) {
        int answer = 0;
        
        long n = num;
        while(n > 1) {
            
            if(++answer == 501) { // 400번 반복할 때까지 1이 되지 않은 경우
                answer = -1; // -1 반환
                break;
            }
            
            if((n & 1) == 0) { // 짝수인 경우
                n = n >> 1; // 2 나눔
            } else { // 홀수인 경우
                n = n * 3 + 1; // 3을 곱하고 1을 더함
            }
        }
        
        return answer;
    }
}