class Solution {
    public int solution(int n) {
        int answer = 0;
        
        // 투포인터
        int l = 1, r = 1; 
        int sum = 1; // l과 r 사이의 합
        while(r <= n) {
            if(sum == n) { // n을 만들 수 있는 조합 발견
                answer++;
                
                // l 포인터 이동
                sum -= l;
                l++;
            }
            else if(sum < n) { // 합이 작으면 r 포인터를 이동하여 합을 키워줌
                r++;
                sum += r;
            }
            else { // 합이 크면 l 포인터를 이동하여 합을 낮춤
                sum -= l;
                l++;
            }
        }
        
        return answer;
    }
}