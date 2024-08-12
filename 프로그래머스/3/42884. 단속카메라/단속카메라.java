import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        // 끝나는 순으로 정렬
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        
        // 필요한 CCTV 개수
        int answer = 0;
        
        // 하나의 cctv 설치 이후 처음 들어온 차량의 나가는 시간
        int out = -30_001;
        for(int[] car : routes) {
            
            // out에 cctv를 설치해줄 거임
            // out보다 먼저 들어온 차량은 out에 cctv를 설치함으로써 경로에 cctv가 하나 이상 생기게 됨
            // out보다 늦게 들어온 차량은 또 다른 cctv를 설치해주어야 함
            
            // out보다 늦게 들어온 차량 발견 시,
            // out에 cctv 설치해줌
            if(out < car[0]) {
                answer++; // cctv 설치
                out = car[1]; // 새로운 cctv 설치 장소 저장
            }
        }
        
        return answer;
    }
}