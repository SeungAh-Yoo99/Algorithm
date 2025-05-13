class Solution {
    public int solution(String name) {
        
        int answer = 0;
        int dist = name.length() - 1; // dist의 최대길이는 오른쪽 커서만으로 모든 문자를 이동하는 것
        
        int next;
        for(int i = 0; i < name.length(); i++) {
            
            // i번째 글자의 알파벳 조작
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            // 다음으로 등장하는 'A'가 아닌 위치 찾기
            next = i + 1;
            while(next < name.length() && name.charAt(next) == 'A')
                next++;

            // 현재 위치에서 다음 위치로 가는 최단 거리
            dist = Math.min(dist, (i * 2) + name.length() - next); // 현재 위치에서 next로 왼쪽 커서로 이동하는 경우
            dist = Math.min(dist, (name.length() - next) * 2 + i); // next에서 현재 위치로 오른쪽 커서로 이동하는 경우
        }
        
        // 최소 경로의 길이 더하기
        answer += dist;
        
        return answer;
    }
}