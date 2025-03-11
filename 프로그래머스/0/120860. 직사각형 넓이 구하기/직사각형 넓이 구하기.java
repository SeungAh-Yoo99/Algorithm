class Solution {
    public int solution(int[][] dots) {
        int height = Math.max(Math.max(Math.max(dots[0][0], dots[1][0]), dots[2][0]), dots[3][0])
            - Math.min(Math.min(Math.min(dots[0][0], dots[1][0]), dots[2][0]), dots[3][0]);
        int width = Math.max(Math.max(Math.max(dots[0][1], dots[1][1]), dots[2][1]), dots[3][1])
            - Math.min(Math.min(Math.min(dots[0][1], dots[1][1]), dots[2][1]), dots[3][1]);
        return height * width;
    }
}