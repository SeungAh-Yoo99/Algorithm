class Solution {
    public int solution(int chicken) {
        int newCoupon = chicken; // 새로 생길 쿠폰
        int remainCoupon = 0; // 사용하고 남은 쿠폰
        int answer = 0; // 서비스 치킨 수
        
        while(newCoupon + remainCoupon >= 10) {
            int tmp1 = (newCoupon + remainCoupon) / 10;
            int tmp2 = (newCoupon + remainCoupon) % 10;
            
            newCoupon = tmp1;
            remainCoupon = tmp2;
            answer += newCoupon; // 시켜먹은 만큼 새로운 쿠폰이 생길 것이니까
        }
        
        return answer;
    }
}