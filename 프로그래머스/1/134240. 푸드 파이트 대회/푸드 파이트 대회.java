import java.util.*;

class Solution {
    public String solution(int[] food) {
        
        StringBuilder answer = new StringBuilder();
        
        // 왼쪽부터 먹는 사람의 음식 순서
        StringBuilder tmp = new StringBuilder();
        for(int i = 1; i < food.length; i++) {
            for(int j = 0; j < food[i] / 2; j++) tmp.append(i);
        }
        
        answer.append(tmp).append("0").append(tmp.reverse());
        return answer.toString();
    }
}