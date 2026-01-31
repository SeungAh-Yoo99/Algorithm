import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        // 사이즈별 귤의 갯수 세기
        Integer[] count = new Integer[10_000_001];
        Arrays.fill(count, 0);
        
        for(int i = 0; i < tangerine.length; i++) {
            count[tangerine[i]]++;
        }
        
        // 사이즈별 갯수 순으로 정렬
        Arrays.sort(count, (o1, o2) -> o2 - o1);
        
        // 종류
        int answer = 0;
        
        // 고른 갯수
        int pick = 0;
        
        for(int i = 0; i < 10_000_001; i++) {
            pick += count[i];
            if(pick >= k) {
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
}