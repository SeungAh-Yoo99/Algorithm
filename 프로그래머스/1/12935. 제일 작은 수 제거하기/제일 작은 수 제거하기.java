class Solution {
    public int[] solution(int[] arr) {
        
        if(arr.length == 1) return new int[] {-1};
        
        // 가장 작은 수 구하기
        int min = Integer.MAX_VALUE;
        for(int a : arr) {
            min = Math.min(min, a);
        }
        
        int[] answer = new int[arr.length - 1];
        int idx = 0;
        for(int a : arr) {
            if(a != min) answer[idx++] = a;   
        }
        return answer;
    }
}