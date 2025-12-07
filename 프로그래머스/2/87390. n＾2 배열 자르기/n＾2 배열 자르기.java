class Solution {
    public int[] solution(int n, long left, long right) {
        
        int[] answer = new int[(int)(right - left) + 1];
        
        long x, y, num;
        for(long i = left; i <= right; i++) {
            // 3차원 배열이었을 때의 좌표
            x = i / n;
            y = i % n;
            
            // x, y 중 더 큰 수에 +1 한 값이 저장되어 있음
            answer[(int)(i - left)] = (int)Math.max(x, y) + 1;
        }
        
        return answer;
    }
}