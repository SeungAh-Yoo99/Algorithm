class Solution {
    public int solution(int[] numbers, int k) {
        
        int idx = 0;
        for(int i = 1; i < k; i++) {
            idx = (idx + 2) % numbers.length;
        }
        
        return numbers[idx];
    }
}