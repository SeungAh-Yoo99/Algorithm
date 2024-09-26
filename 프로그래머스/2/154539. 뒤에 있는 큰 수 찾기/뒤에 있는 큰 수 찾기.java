import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        // numbers의 길이
        int n = numbers.length;

        // 뒷 큰수의 인덱스를 담은 배열
        int[] dp = new int[n];
        dp[n - 1] = n; // 가장 마지막 정수는 뒷 큰수가 없음
        
        // 자신보다 크면서 가장 가까이 있는 수를 담은 배열
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        
        for(int i = n - 2; i >= 0; i--) {
            dp[i] = i + 1;
            
            while(dp[i] < n && numbers[dp[i]] <= numbers[i]) {
                dp[i] = dp[dp[i]];
            }
            if(dp[i] != n) answer[i] = numbers[dp[i]];
        }
        
        return answer;
    }
}