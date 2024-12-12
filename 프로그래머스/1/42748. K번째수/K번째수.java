import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        int[] tmp;
        int len;
        for(int i = 0; i < commands.length; i++) {
            len = commands[i][1] - commands[i][0] + 1;
            tmp = new int[len];
            for(int j = 0; j < len; j++) {
                tmp[j] = array[j + commands[i][0] - 1];
            }
            Arrays.sort(tmp);
            answer[i] = tmp[commands[i][2] - 1];
        }
        
        return answer;
    }
}