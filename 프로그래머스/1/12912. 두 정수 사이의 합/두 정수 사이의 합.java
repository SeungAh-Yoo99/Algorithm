class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        // a와 b 중 더 작은 수를 a에 저장
        if(a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        
        for(int i = a; i <= b; i++) {
            answer += i;
        }
        
        return answer;
    }
}