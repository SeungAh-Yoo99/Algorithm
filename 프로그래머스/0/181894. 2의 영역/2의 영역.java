import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        
        int s = -1, e = arr.length;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 2) {
                s = i;
                break;
            }
        }
        
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] == 2) {
                e = i;
                break;
            }
        }
        
        // arr에 2가 없는 경우
        if(s == -1 && e == arr.length) return new int[] {-1};
        
        int[] answer = Arrays.copyOfRange(arr, s, e + 1);
        return answer;
    }
}