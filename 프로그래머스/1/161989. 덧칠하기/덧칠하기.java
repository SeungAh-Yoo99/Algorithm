class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        // 페인트 한 번 칠했을 때, 롤러가 끝나는 위치
        int endOfRoller = 0;
        for(int i = 0; i < section.length; i++) {
            if(section[i] > endOfRoller) { // 이전에 칠한 롤러가 i번째 벽면까지 칠할 수 없다면, 페인트 칠을 한 번 더 함
                answer++;
                endOfRoller = section[i] + m - 1; // section[i]에 롤러 왼쪽 끝을 맞췄을 때, 롤러 오른쪽 끝의 위치
            }
        }
        
        return answer;
    }
}