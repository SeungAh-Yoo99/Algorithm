import java.util.*;

class Solution {
    
    public int solution(int[] A, int[] B) {

        // A, B팀이 부여받은 점수 정렬
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        int bi = 0; // B의 인덱스
        for(int i = 0; i < A.length; i++) {
            // A[i]보다 큰 수 중 가장 작은 수 찾기
            while(bi < B.length && A[i] >= B[bi]) bi++;
            
            // A[i]보다 큰 수가 없다면 더 이상 확인하지 않음
            if(bi == B.length) break;
            
            // A[i]보다 큰 수 중 사용 가능한 가장 작은 수를 찾은 경우
            if(A[i] < B[bi]) {
                bi++;
                answer++;
            }
        }
        
        return answer;
    }
}