class Solution {
    boolean solution(String s) {
        boolean answer = true;

        char[] arr = s.toCharArray();
        
        int p = 0, y = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 'P' || arr[i] == 'p') p++;
            else if(arr[i] == 'Y' || arr[i] == 'y') y++;
        }
        
        if(p != y) answer = false;

        return answer;
    }
}