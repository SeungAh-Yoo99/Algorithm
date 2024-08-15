class Solution {
    public int solution(int n, int[] stations, int w) {
        
        int answer = 0;

        int start = 1; // 전파가 닿지 않는 구간의 시작점
        for(int i = 0; i < stations.length; i++) {
            // 다음 기지국이 전파가 닿지 않는 구간을 다 커버하지 못하는 경우
            if(stations[i] - w > start) {
                // 구간을 다 커버할 수 있을만큼 기지국 설치
                answer += (stations[i] - w - start) / (w * 2 + 1);
                answer += (stations[i] - w - start) % (w * 2 + 1) == 0 ? 0 : 1;
            }
            
            // 다음 기지국의 전파가 닿지 않는 구간 설정
            start = Math.max(start, stations[i] + w + 1);
        }

        // 마지막 구간 체크
        if(n >= start) {
            answer += (n - start + 1) / (w * 2 + 1);
            answer += (n - start + 1) % (w * 2 + 1) == 0 ? 0 : 1;
        }

        return answer;
    }
}