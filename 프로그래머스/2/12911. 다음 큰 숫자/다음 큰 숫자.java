class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // n을 2진수로 변환했을 때 1의 개수
        int num = 0, tmp = n;
        while(tmp > 0) {
            if(tmp % 2 == 1) num++;
            tmp /= 2;
        }
        
        int next = n, count;
        while(true) {
            count = 0;
            tmp = ++next;
            while(tmp > 0) {
                if(tmp % 2 == 1) count++;
                tmp /= 2;
            }
            
            if(count == num) {
                answer = next;
                break;
            }
        }
        
        return answer;
    }
}