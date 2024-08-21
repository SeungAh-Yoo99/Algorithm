class Solution {
    public int solution(int[] arr) {
        
        // arr에서 가장 큰 수 찾기
        int maxNum = 0;
        for(int a : arr) {
            maxNum = Math.max(maxNum, a);
        }
        
        
        int answer = maxNum;
        
        boolean flag;
        while(true) {
            flag = true;
            
            // 현재 answer로 다 나누어 떨어지는지 확인
            for(int a : arr) {
                if(answer % a != 0) { // 나누어 떨어지지 않는 수를 발견한 경우
                    flag = false;
                    break;
                }
            }
            
            // 모든 수가 나누어 떨어진 경우 while문 break
            if(flag) break;
            answer++;
        }
        
        return answer;
    }
}