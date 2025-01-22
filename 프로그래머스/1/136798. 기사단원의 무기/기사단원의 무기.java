class Solution {
    public int solution(int number, int limit, int power) {
        
        // 약수 개수 구하기
        int[] count = new int[number + 1];
        int pow;
        for(int i = 1; i <= number; i++) {
            pow = 1;
            while(pow * i <= number) count[pow++ * i]++;
        }
        
        // 철의 무게 구하기
        int answer = 0;
        for(int i = 1; i <= number; i++) {
            if(count[i] > limit) answer += power;
            else answer += count[i];
        }
        
        return answer;
    }
}