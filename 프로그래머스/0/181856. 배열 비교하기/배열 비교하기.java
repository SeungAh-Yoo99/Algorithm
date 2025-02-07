class Solution {
    public int solution(int[] arr1, int[] arr2) {
        
        if(arr1.length > arr2.length) return 1;
        else if(arr1.length == arr2.length) {
            int sum1 = sum(arr1);
            int sum2 = sum(arr2);
            if(sum1 > sum2) return 1;
            else if(sum1 == sum2) return 0;
            else return -1;
        }
        else return -1;
    }
    
    int sum(int[] arr) {
        
        int ret = 0;
        
        for(int a : arr) ret += a;
        
        return ret;
    }
}