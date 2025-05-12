class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++) {
            if(getNumOfDivisors(i) % 2 == 0) answer += i;
            else answer -= i;
        }
        
        return answer;
    }
    
    int getNumOfDivisors(int num) {
        
        int ret = 0;
        
        for(int i = 1; i <= num; i++)
            if(num % i == 0)
                ret++;
        
        return ret;
    }
}