class Solution {
    public int solution(String dartResult) {
        
        int answer = 0;
        
        // 이전 점수
        int preScore = 0;
        
        // dartResult의 인덱스
        int index = 0;
        
        int score; char bonus;
        while(index < dartResult.length()) {
            // 점수
            score = dartResult.charAt(index++) - '0';
            if(dartResult.charAt(index) == '0') { // 점수가 10일 경우
                score = 10;
                index++;
            }
            
            // 보너스
            bonus = dartResult.charAt(index++);
            if(bonus == 'D') score = (int)Math.pow(score, 2);
            else if(bonus == 'T') score = (int)Math.pow(score, 3);
            
            // 옵션
            if(index < dartResult.length()) {
                if(dartResult.charAt(index) == '*') {
                    preScore *= 2;
                    score *= 2;
                    index++;
                }
                else if(dartResult.charAt(index) == '#') {
                    score *= -1;
                    index++;
                }
            }
            
            answer += preScore;
            preScore = score;
        }
        
        answer += preScore;
        
        return answer;
    }
}