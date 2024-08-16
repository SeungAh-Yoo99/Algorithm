class Solution {
    public boolean solution(int x) {
        
        int sum = 0; // 자릿수 합
        int tmp = x;
        while(tmp > 0) {
            sum += tmp % 10;
            tmp /= 10;
        }
        
        boolean answer;
        if(x % sum == 0) answer = true;
        else answer = false;
        
        return answer;
    }
}