class Solution {
    public int solution(int n) {
        
        // n보다 작거나 같은 수 중 가장 큰 3의 제곱 구하기
        int pow = 0;
        while(n >= (int)Math.pow(3, pow)) pow++;
        pow--;
        
        // 3진법 구하고 뒤집어 10진법으로 변환
        int answer = 0;
        int tmp;
        for(int i = pow; i >= 0; i--) {
            tmp = n / (int)(Math.pow(3, i));
            answer += tmp * (int)(Math.pow(3, pow - i));
            n %= (int) Math.pow(3, i);
        }
        
        return answer;
    }
}