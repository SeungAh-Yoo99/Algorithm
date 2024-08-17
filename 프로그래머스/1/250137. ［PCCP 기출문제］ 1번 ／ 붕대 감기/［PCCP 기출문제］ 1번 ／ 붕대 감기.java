class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        // 현재 체력
        int answer = health;
        
        // 공격 시작
        answer -= attacks[0][1];
        
        for(int i = 1; i < attacks.length; i++) {
            
            // 이전 공격으로 생존에 실패한 경우
            if(answer <= 0) break;
            
            // 이번 공격이 시작하기 전까지 1초마다 회복
            answer += (attacks[i][0] - attacks[i - 1][0] - 1) * bandage[1];
            // 연속 성공으로 추가로 받은 체력
            answer += ((attacks[i][0] - attacks[i - 1][0] - 1) / bandage[0]) * bandage[2];
            // 최대 체력을 넘을 수 없음
            answer = answer > health ? health : answer;
            
            // 몬스터 공격
            answer -= attacks[i][1];
        }
        
        // 생존 실패한 경우
        if(answer <= 0) answer = -1;
        return answer;
    }
}