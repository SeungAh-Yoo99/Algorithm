import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        
        // 출발지점과 도착지점을 추가한 배열 생성
        int[] rocksArr = new int[rocks.length + 2];
        for(int i = 0; i < rocks.length; i++) rocksArr[i + 2] = rocks[i];
        rocksArr[0] = 0;
        rocksArr[1] = distance;
        
        // 오름차순 정렬
        Arrays.sort(rocksArr);
         
        // 최솟값 이분탐색
        int answer = 0;
        int s = 0, e = distance, m;
        int count, start;
        boolean flag;
        while(s <= e) {
            m = (s + e) / 2;
            count = 0; // 제거한 바위 개수
            start = 0; // 이전 바위 위치
            flag = false;
            
            for(int i = 1; i < rocksArr.length; i++) {
                // m보다 작은 바위 간의 거리 발견
                if(rocksArr[i] - start < m) {
                    // 아직 제거할 수 있는 바위 개수가 남았다면 제거
                    if(count < n) {
                        count++;
                        continue;
                    }
                    // 제거할 수 있는 바위 개수가 남지 않았다면
                    else {
                        e = m - 1;
                        flag = true;
                        break;   
                    }
                }
                start = rocksArr[i];
            }
            
            // m보다 큰 바위 간의 거리를 찾지 못했다면
            if(!flag) {
                answer = m;
                s = m + 1;
            }
        }
        
        return answer;
    }
}