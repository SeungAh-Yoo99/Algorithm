class Solution {
    public int solution(int[] nums) {
        
        // 1 이상 3,000 이하의 수 중, 소수인 것들 구하기
        boolean[] isNotPrimeNumber = new boolean[3_001];
        isNotPrimeNumber[1] = true;
        
        for(int i = 2; i * i < 3_001; i++) {
            if(!isNotPrimeNumber[i]) {
                for(int j = i * i; j < 3_001; j += i) {
                    isNotPrimeNumber[j] = true;
                }
            }
        }
        
        
        int answer = 0;

        // nums에서 3개를 골랐을 때 소수이면 answer + 1
        int sum;
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                for(int l = j + 1; l < nums.length; l++) {
                    sum = nums[i] + nums[j] + nums[l];
                    if(!isNotPrimeNumber[sum]) answer++;
                }
            }
        }

        return answer;
    }
}