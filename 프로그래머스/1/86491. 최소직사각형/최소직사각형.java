class Solution {
    public int solution(int[][] sizes) {
        
        // 명함의 더 긴 쪽이 무조건 가로로 오게 해서 최대값 구하기
        int x = 0, y = 0;
        int row, column;
        for(int i = 0; i < sizes.length; i++) {
            row = Math.max(sizes[i][0], sizes[i][1]);
            column = Math.min(sizes[i][0], sizes[i][1]);
            
            x = Math.max(x, row);
            y = Math.max(y, column);
        }
        
        int answer =  x * y;
        return answer;
    }
}