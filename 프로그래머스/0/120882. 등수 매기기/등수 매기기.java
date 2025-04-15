import java.util.*;

class Solution {
    public int[] solution(int[][] score) {
        
        // (영어 점수 + 수학 점수)와 학생 번호를 담은 배열
        int[][] arr = new int[score.length][2];
        for(int i = 0; i < score.length; i++) {
            arr[i][0] = score[i][0] + score[i][1];
            arr[i][1] = i;
        }
        
        // 점수를 기준으로 내림차순 정렬
        Arrays.sort(arr, (o1, o2) -> o2[0] - o1[0]);
        
        // 등수 매기기
        int ranking = 1;
        int same = 0;
        
        int[] answer = new int[score.length];
        answer[arr[0][1]] = ranking;
        
        for(int i = 1; i < score.length; i++) {
            if(arr[i - 1][0] != arr[i][0]) { // 이전 사람과 점수가 다르다면
                ranking += same + 1;
                same = 0;
            }
            else // 이전 사람과 점수가 같다면 
                same ++;
            
            answer[arr[i][1]] = ranking;
        }
        
        return answer;
    }
}