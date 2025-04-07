class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        int minSide = Math.min(sides[0], sides[1]);
        int maxSide = Math.max(sides[0], sides[1]);
        
        // maxSide가 가장 긴 변인 경우
        answer += maxSide - (maxSide - minSide) - 1;
        
        // 다른 한 변이 가장 긴 변인 경우
        answer += (maxSide + minSide) - maxSide;
        
        return answer;
    }
}