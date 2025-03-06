class Solution {
    public int solution(String binomial) {
        
        String[] bino = binomial.split(" ");
        
        int answer = Integer.parseInt(bino[0]);
        if(bino[1].equals("+")) answer += Integer.parseInt(bino[2]);
        else if(bino[1].equals("-")) answer -= Integer.parseInt(bino[2]);
        else answer *= Integer.parseInt(bino[2]);
        
        return answer;
    }
}