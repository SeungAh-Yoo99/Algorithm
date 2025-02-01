import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        // 1, 2, 3번 수포자가 찍는 방식을 담은 배열
        int[][] pick = new int[][] {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        
        // 점수
        int[] scores = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            for(int j = 0; j < 3; j++) {
                if(answers[i] == pick[j][i % pick[j].length]) scores[j]++;
            }
        }
        
        // 가장 높은 점수를 받은 사람 구하기
        int maxScore = scores[0];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        
        for(int i = 1; i < 3; i++) {
            if(maxScore < scores[i]) {
                maxScore = scores[i];
                list.clear();
                list.add(i + 1);
            }
            else if(maxScore == scores[i])
                list.add(i + 1);
        }
        
        // 가장 높은 점수를 받은 사람 리스트를 배열로 변경
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}