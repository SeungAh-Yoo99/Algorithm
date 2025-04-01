class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int[] answer = {7, 7};
        
        for(int i = 0; i < 6; i++) {
            
            if(lottos[i] == 0) {
                answer[0]--;
                continue;
            }
            
            for(int j = 0; j < 6; j++) {
                if(lottos[i] == win_nums[j]) {
                    answer[0]--;
                    answer[1]--;
                    break;
                }
            }
        }
        
        if(answer[0] == 7) answer[0]--;
        if(answer[1] == 7) answer[1]--;
        
        return answer;
    }
}