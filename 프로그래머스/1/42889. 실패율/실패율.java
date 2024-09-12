import java.util.*;

class Solution {
    
    public int[] solution(int N, int[] stages) {
        
        // 누적합으로 스테이지에 도착한 인원수 저장할 배열
        int[] sum = new int[N + 2];
        
        // 스테이지별 클리어 못한 플레이어 수 더하기
        for(int i = 0; i < stages.length; i++) {
            sum[stages[i]]++;
        }
        
        // 스테이지에 도달한 플레이어 수 누적합 구하기
        for(int i = N; i >= 1; i--) {
            sum[i] += sum[i + 1];
        }
        
        // 인덱스와 함께 실패율 저장
        double[][] failure = new double[N + 1][2];
        for(int i = 1; i <= N; i++) {
            failure[i][0] = sum[i] == 0 ? 0 : (double)(sum[i] - sum[i + 1]) / sum[i];
            failure[i][1] = i;
        }
        
        // 실패율 기준 내림차순 정렬
        Arrays.sort(failure,
                    (o1, o2) -> o1[0] == o2[0]
                        ? o1[1] < o2[1] ? -1 : 1
                        : o1[0] < o2[0] ? 1 : -1);
        
        // 답 저장
        int[] answer = new int[N];
        int idx = 0;
        for(int i = 0; i <= N; i++) {
            if(failure[i][1] != 0) {
                answer[idx++] = (int)failure[i][1];
            }
        }
        
        return answer;
    }
}