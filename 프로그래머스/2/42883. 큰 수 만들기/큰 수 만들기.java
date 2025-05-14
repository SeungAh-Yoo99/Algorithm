class Solution {
    public String solution(String number, int k) {
        
        StringBuilder answer = new StringBuilder();
        
        // 현재 지울 수 있는 개수
        int count = k;
        
        int now = 0, next;
        while(now < number.length()) {
            // 현재 위치에서 가장 가까운 자신보다 큰 수 찾기
            next = now + 1;
            while(next < number.length() && number.charAt(now) >= number.charAt(next))
                next++;
            
            // 자신보다 큰 수까지 모두 지울 수 있으면 지우기
            if(count >= next - now) {
                count -= next - now;
                now = next;
            }
            else {
                answer.append(number.charAt(now));
                now++;
            }
        }
        
        return answer.toString();
    }
}