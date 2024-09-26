import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        // numbers의 길이
        int n = numbers.length;

        // 뒷 큰수의 인덱스를 담은 배열
        int[] dp = new int[n];
        dp[n - 1] = n; // 가장 마지막 정수는 뒷 큰수가 없음
        
        // 뒷 큰수를 담은 배열
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        
        for(int i = n - 2; i >= 0; i--) { // 뒤에서부터 시작
            dp[i] = i + 1; // 처음 뒷 큰수는 바로 뒤를 참조
            
            // 현재 numbers[dp[i]]가 numbers[i]보다 작으면
            // 다음으로 numbers[dp[i]]보다 큰 수인 dp[dp[i]]로 이동
            while(dp[i] < n && numbers[dp[i]] <= numbers[i]) {
                dp[i] = dp[dp[i]];
            }
            if(dp[i] != n) answer[i] = numbers[dp[i]];
        }
        
        return answer;
    }
}
