class Solution {
    public long solution(int price, int money, int count) {
        
        // 총 필요한 금액
        long total = 0;
        for(int i = 1; i <= count; i++) {
            total += price * i;
        }
        
        long answer = total <= money ? 0 : total - money;

        return answer;
    }
}