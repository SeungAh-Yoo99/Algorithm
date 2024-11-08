import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        
        // 인덱스에 해당하는 사이즈인 귤의 개수
        int[] size = new int[10_000_001];
        
        for(int s : tangerine) {
            size[s]++;
        }
        
        // 개수를 기준으로 정렬
        Arrays.sort(size);
        
        int answer = 0;
        for(int i = 10_000_000; i > 0; i--) {
            // 귤을 다 담았다면 반복문 탈출
            if(k <= 0) break;
            
            k -= size[i];
            answer++;
        }
        
        return answer;
    }
}