class Solution {
    
    int[] count;
    
    public int solution(String numbers) {
        
        // numbers를 구성하는 숫자 개수
        count = new int[10];
        for(int i = 0; i < numbers.length(); i++)
            count[numbers.charAt(i) - '0']++;
        
        // 숫자 조합으로 만들 수 있는 가장 큰 수
        int max = 0;
        for(int i = 9; i >= 0; i--)
            for(int j = 0; j < count[i]; j++)
                max = max * 10 + i;
        
        // 소수가 아닌 수를 표시할 배열
        boolean[] isNotPrime = new boolean[max + 1];
        
        int answer = 0;
        for(int i = 2; i <= max; i++) {
            if(!isNotPrime[i]) { // 소수를 발견했다면
                // 숫자 조각들로 만들 수 있는 수인지 확인
                if(canMake(i)) answer++;
                // i의 배수들은 소수가 아님
                for(int j = 2 * i; j <= max; j += i)
                    isNotPrime[j] = true;
            }
        }
    
        return answer;
    }
    
    boolean canMake(int num) {
        
        int[] numCount = new int[10];
        while(num > 0) {
            numCount[num % 10]++;
            num /= 10;
        }
        
        for(int i = 0; i < 10; i++)
            // 가진 조각보다 더 많은 조각이 필요하면 만들 수 없음
            if(count[i] < numCount[i]) return false;
        
        return true;
    }
}