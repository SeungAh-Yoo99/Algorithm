import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        // 두 배열 합치기
        int[] queue = new int[queue1.length + queue2.length];
        
        // 투 포인터
        int l = 0, r = queue1.length - 1;
        
        // queue[l] ~ queue[r]까지의 합과 전체 합 구하기
        long totalSum = 0, sum = 0;
        
        for(int i = 0; i < queue1.length; i++) {
            totalSum += queue1[i];
            sum += queue1[i];
            queue[i] = queue1[i];
        }
        for(int i = 0; i < queue2.length; i++) {
            totalSum += queue2[i];
            queue[i + queue1.length] = queue2[i];
        }
        
        // 전체 합이 홀수라면 답을 구할 수 없음
        if(totalSum % 2L == 1) return -1;
        
        int answer = -1;
        int count = 0;
        while(l <= r && r < queue.length) {
            if(totalSum / 2 == sum) {
                answer = count;
                break;
            }
            else if(totalSum / 2 < sum) {
                count++;
                sum -= queue[l++];
            }
            else {
                count++;
                if(++r < queue.length) sum += queue[r];
            }
        }
        
        return answer;
    }
}