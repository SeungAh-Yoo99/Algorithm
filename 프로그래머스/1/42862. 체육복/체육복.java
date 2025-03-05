import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        // 체육복을 도난 당하지 않은 학생 수
        int answer = n - lost.length;
        
        // 체육복 잃어버린 학생 배열
        boolean[] isLost = new boolean[n + 2]; // 앞뒤로 마진 주기
        for(int l : lost) isLost[l] = true;
        
        // 여벌의 체육복을 가져온 학생 배열 정렬
        Arrays.sort(reserve);
        
        // 본인도 잃어버려 체육복을 빌려줄 수 없는 학생 배열
        boolean[] cantLend = new boolean[reserve.length];
        for(int i = 0; i < reserve.length; i++) {
            if(isLost[reserve[i]]) {
                isLost[reserve[i]] = false;
                answer++;
                cantLend[i] = true;
            }
        }
        
        
        // 체육복 빌려주기
        int r;
        for(int i = 0; i < reserve.length; i++) {
            // 본인이 잃어버렸으면 빌려줄 수 없음
            if(cantLend[i]) continue;
            
            r = reserve[i];
            // 앞 사람 빌려주기
            if(isLost[r - 1]) {
                isLost[r - 1] = false;
                answer++;
            }
            // 뒷 사람 빌려주기
            else if(isLost[r + 1]) {
                isLost[r + 1] = false;
                answer++;
            }
        }
        
        return answer;
    }
}