class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++)
            answer[i] = func(arr, queries[i][0], queries[i][1], queries[i][2]);
        
        return answer;
    }
    
    int func(int[] arr, int s, int e, int k) {
        
        int ret = 1_000_001;
        
        for(int i = s; i <= e; i++) {
            if(arr[i] > k) ret = Math.min(ret, arr[i]);
        }
        
        if(ret == 1_000_001) return -1;
        return ret;
    }
}