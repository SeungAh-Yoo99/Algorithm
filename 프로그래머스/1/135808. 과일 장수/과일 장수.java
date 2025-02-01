import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        
        // 정렬
        Arrays.sort(score);
        
        int answer = 0;
        int lowerIndex = score.length - m;
        while(lowerIndex >= 0) {
            answer += m * score[lowerIndex];
            lowerIndex -= m;
        }
        
        return answer;
    }
}