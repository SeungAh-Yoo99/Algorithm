class Solution {
    public long solution(long n) {
        
        int[] count = new int[10]; // 인덱스에 해당하는 수가 몇 개인지 저장
        while(n > 0) {
            count[(int)(n % 10)]++;
            n /= 10;
        }
        
        long answer = 0;
        for(int i = 9; i >=0; i--) { // 큰 수부터
            for(int j = 0; j < count[i]; j++) { // 개수만큼 더해줌
                answer *= 10;
                answer += i;
            }
        }
        
        return answer;
    }
}