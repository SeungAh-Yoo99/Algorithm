class Solution {
    public int[] solution(int[] arr, int n) {
        
        int start = 0;
        if(arr.length % 2 == 0) start = 1;
        
        for(int i = start; i < arr.length; i += 2)
            arr[i] += n;
        
        return arr;
    }
}