class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        int temp;
        while(storey > 0) {
            
            temp = storey % 10;
            storey /= 10;
            
            // 1의 자리가 5 미만이면 버리고, 초과면 올림
            if(temp < 5) answer += temp;
            else if(temp > 5){
                answer += 10 - temp;
                storey++;
            }
            else { // 5일 경우엔
                if(storey % 10 < 5) {
                    answer += temp;
                }
                else {
                    answer += 10 - temp;
                    storey++;
                }
            }
        }
        
        return answer;
    }
}