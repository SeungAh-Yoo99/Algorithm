class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i = 1; i <= n ; i++) {
            answer++;
            // 3의 배수일 경우 + 1
            // 숫자 3이 들어갈 경우 숫자 3이 나오지 않을 때까지 + 1
            String s = Integer.toString(answer);
            while(s.contains("3") || answer % 3 == 0) {
                answer++;
                s = Integer.toString(answer);
            }
        }
        
        return answer;
    }
}