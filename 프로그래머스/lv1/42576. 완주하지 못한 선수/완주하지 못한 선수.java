import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        // 입력 받은 두 배열 모두 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        // 두 배열이 정렬된 상태이므로
        // 다른 값이 나왔다면 그 값이 답이다.
        for(int i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                answer = participant[i];
                break;
            }
        }
        // 만약 루프를 다 돌 때까지 답을 찾지 못했다면
        // 정렬된 participant 배열의 마지막 사람이 답
        if(answer.equals(""))
            answer = participant[participant.length - 1];
        
        return answer;
    }
}