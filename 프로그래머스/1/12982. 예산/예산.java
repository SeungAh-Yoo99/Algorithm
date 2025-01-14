import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        
        int answer = 0;
        
        // 정렬
        Arrays.sort(d);
        
        // 지급 가능한 부서 개수 세기
        for(int price : d) {
            if(budget >= price) {
                answer++;
                budget -= price;
            }
        }
        
        return answer;
    }
}