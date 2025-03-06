class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0, 0};
        
        for(String key : keyinput) {
            if(key.equals("left")) {
                if(answer[0] - 1 >= -1 * board[0] / 2) answer[0] -= 1;
            }
            else if(key.equals("right")) {
                if(answer[0] + 1 <= board[0] / 2) answer[0] += 1;
            }
            else if(key.equals("up")) {
                if(answer[1] + 1 <= board[1] / 2) answer[1] += 1;
            }
            else {
                if(answer[1] - 1 >= -1 * board[1] / 2) answer[1] -= 1;
            }
        }
        
        return answer;
    }
}