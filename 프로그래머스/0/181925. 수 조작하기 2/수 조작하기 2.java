class Solution {
    public String solution(int[] numLog) {
        
        StringBuilder answer = new StringBuilder();
        
        int num;
        for(int i = 1; i < numLog.length; i++) {
            num = numLog[i] - numLog[i - 1];
            
            if(num == 1) answer.append("w");
            else if(num == -1) answer.append("s");
            else if(num == 10) answer.append("d");
            else answer.append("a");
        }
        
        return answer.toString();
    }
}