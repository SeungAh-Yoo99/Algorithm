import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        
        int[] answer;
        
        // 최고의 집합을 만들 수 없는 경우
        if(n > s) {
            answer = new int[] {-1};
            return answer;
        }
        
        answer = new int[n];
        
        // 모든 원소가 수를 골고루 나눠 가져야 유리
        int q = s / n; // 몫
        int r = s % n; // 나머지
        
        for(int i = 0; i < n; i++) {
            answer[i] += q;
            if(r-- > 0) answer[n - 1 - i]++; // 오름차순 정렬하기 위해 뒤에서부터 나머지를 더해줌
        }
        
        return answer;
    }
}