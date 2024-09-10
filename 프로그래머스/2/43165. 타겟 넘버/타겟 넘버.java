class Solution {
    
    static int[] numbers;
    static int target;
    static int answer;
    
    public int solution(int[] numbers, int target) {
        
        this.numbers = numbers;
        this.target = target;
        answer = 0;
        
        dfs(0, 0);
        
        return answer;
    }
    
    private static void dfs(int idx, int num) {
        
        // 마지막 숫자까지 연산 완료
        if(idx == numbers.length) {
            if(num == target) answer++;
            return;
        }
        
        // 더하기
        dfs(idx + 1, num + numbers[idx]);
        // 빼기
        dfs(idx + 1, num - numbers[idx]);
    }
}