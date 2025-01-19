import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        // 그리움 정보를 담을 Map
        Map<String, Integer> score = new HashMap<>();
        for(int i = 0; i < name.length; i++) {
            score.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[photo.length];
        for(int i = 0; i < photo.length; i++) {
            for(int j = 0; j < photo[i].length; j++) {
                answer[i] += score.get(photo[i][j]) != null ? score.get(photo[i][j]) : 0;
            }
        }
        
        return answer;
    }
}