import java.util.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        
        int a = slicer[0], b = slicer[1], c = slicer[2];
        
        int[] answer;
        
        if(n == 1) answer = Arrays.copyOfRange(num_list, 0, b + 1);
        else if(n == 2) answer = Arrays.copyOfRange(num_list, a, num_list.length);
        else if(n == 3) answer = Arrays.copyOfRange(num_list, a, b + 1);
        else {
            answer = new int[(b - a) / c + 1];
            int idx = 0;
            for(int i = a; i <= b; i += c) answer[idx++] = num_list[i];
        }
        
        return answer;
    }
}